package com.gupaoedu.mvcframework.v1.servlet;

import com.gupaoedu.mvcframework.annotation.GPAutowired;
import com.gupaoedu.mvcframework.annotation.GPController;
import com.gupaoedu.mvcframework.annotation.GPRequestMapping;
import com.gupaoedu.mvcframework.annotation.GPService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class GPDispatcherServlet extends HttpServlet {

    // 用于保存 class 与 实例, HashMap 的 key 可以重复的吗？
    private Map<String, Object> classmMapping = new HashMap<String, Object>();

    // claszzName and Instance
    private Map<String, Object> classNameAndInstance = new HashMap<String, Object>();

    // url 和 Method 的映射
    private Map<String, Method> urlAndMethod = new HashMap<String, Method>();



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 处理请求
        System.out.println("doPost()");
        try {
            doDispatch(req, resp);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    public void doDispatch(HttpServletRequest req, HttpServletResponse resp) throws IOException, InvocationTargetException, IllegalAccessException {
        String url = req.getRequestURI();
        System.out.println("request url :" + url);
        String contextPath = req.getContextPath();
        System.out.println("Context Path :" + contextPath);

        url = url.replaceAll(contextPath, "").replaceAll("/+", "/");
        if (!this.urlAndMethod.containsKey(url)) {
            resp.getWriter().write("404 Not Found !!!");
            return;
        }
        
        Method method = (Method) this.urlAndMethod.get(url);
        Map<String, String[]> params = req.getParameterMap();
        // method.invoke(req, resp, new Object[]{req, resp, params.get("name")[0]});
        method.invoke(this.classNameAndInstance.get(method.getDeclaringClass().getName()),new Object[]{req,resp,params.get("name")[0]});
    }

    /*
    @Override
    protected void aservice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.aservice(req, resp);
        // aservice 实际上就是根据分配的 doGet, doPost 方法;
    }
    */

    // ServletConfig 这个参数也不知道是哪里赋值与传过来的
    @Override
    public void init(ServletConfig config) throws ServletException {
        // 初始化;
        System.out.println("init()");
        InputStream is = null;
        try {
            is = this.getClass().getClassLoader().getResourceAsStream(
                    config.getInitParameter("contextConfigLocation"));

            // 如果换成 xml 文件又该如何处理呢？
            Properties properties = new Properties();
            properties.load(is);

            String scanPackage = properties.getProperty("scanPackage");
            System.out.println("scanPackage :" + scanPackage);

            // 加载完所有的 类
            URL classUrl = this.getClass().getClassLoader()
                    .getResource("/" + scanPackage.replaceAll("\\.", "/"));
            File file = new File(classUrl.getFile());

            doScanner(file);

            System.out.println("classMapping :" + classmMapping.size());

            for ( String clazzName : classmMapping.keySet()) {
                Class clazz = Class.forName(clazzName);

                // 如果类标注了 GPController 的注解;
                if (clazz.isAnnotationPresent(GPController.class)) {
                    // 将 clazzName 与 实例对象映射起来: clazzName: com.gupaoedu.demo.mvc.controller.DemoController
                    classNameAndInstance.put(clazzName, clazz.newInstance());
                    String baseUrl = "";
                    if (clazz.isAnnotationPresent(GPRequestMapping.class)) {
                        GPRequestMapping requestMapping = (GPRequestMapping) clazz.getAnnotation(GPRequestMapping.class);
                        // 类的  url: /demo
                        baseUrl = requestMapping.value();
                    }

                    Method[] methods = clazz.getMethods();
                    for (Method method : methods) {
                        if (!method.isAnnotationPresent(GPRequestMapping.class)) {
                            continue;
                        }
                        GPRequestMapping requestMapping = method.getAnnotation(GPRequestMapping.class);
                        String url = (baseUrl + "/" + requestMapping.value()).replaceAll("/+", "/");
                        // 将 url 与 method 映射起来

                        urlAndMethod.put(url, method);
                        System.out.println("Mapped " + url + ", " + method);
                    }
                } else if (clazz.isAnnotationPresent(GPService.class)) {
                    GPService service = (GPService) clazz.getAnnotation(GPService.class);
                    String beanName = service.value();
                    if ("".equals(beanName)) {
                        beanName = clazz.getName();// ? SimpleName 还会 包名加上类名
                        if (clazz.getInterfaces().length > 0) {
                            Class[] interfaces = clazz.getInterfaces();
                            beanName = interfaces[0].getName();
                        }
                    }
                    System.out.println("beanName :" + beanName);
                    Object instance = clazz.newInstance();

                    classNameAndInstance.put(beanName, instance);

                    /*
                    for (Class i : clazz.getInterfaces()) { // 我觉得这里可以不要的 ???
                        classmMapping.put(i.getName(), instance);
                    }
                    */

                } else {
                    continue;
                }
            }

            // 这里应该就是开始注入了
            for (Object object : classNameAndInstance.values()) {
                if (object == null ) { continue; }
                Class clazz = object.getClass();

                if (clazz.isAnnotationPresent(GPController.class)){
                    Field[] fields = clazz.getDeclaredFields(); // 获取当前类 所有的字段(包括 private)
                    for ( Field field : fields) {
                        if (!field.isAnnotationPresent(GPAutowired.class)) { continue; }
                        GPAutowired autowired = field.getAnnotation(GPAutowired.class);
                        String beanName = autowired.value();
                        if ("".equals(beanName)) {
                            // ??? field.getType()
                            beanName = field.getType().getName();
                        }
                        System.out.println("field.getType() :" + field.getType());
                        System.out.println("field.getType().getName() :" + field.getType().getName());
                        field.setAccessible(true); // 强制访问字段

                        // field.set(classNameAndInstance.get(clazz.getName()), classNameAndInstance.get(beanName));
                        // field.set(classNameAndInstance.get(clazz.getName()), classNameAndInstance.get("com.gupaoedu.demo.aservice.impl.DemoService"));
                        // 接口和实现了的 key 不是一样的;
                        field.set(classNameAndInstance.get(clazz.getName()), classNameAndInstance.get(beanName));
                    }
                }
            }

        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("GP MVC Framework is init.");
    }


    // com.gupaoedu.demo
    /*  这个 递归算法是有问题的;
    private void doScanner(String scanPackage) {
        //System.out.println(this.getClass().getClassLoader().getResource("/com/gupaoedu/demo"));
        URL url = this.getClass().getClassLoader().getResource("/" + scanPackage.replaceAll("\\.", "/"));
        File classDir = new File(url.getFile());
        for ( File file : classDir.listFiles()) {
            if (file.isDirectory()) {
                doScanner(scanPackage + "." + file.getName());
            } else {
                if (!file.getName().endsWith(".class")) {
                    continue;
                }
                String clazzName = scanPackage + "."
                        + file.getName().replace(".class", "");
                System.out.println("clazzName :" + clazzName);
                // 添加所有的类, 到 mapping 中来; clazzName: com.gupaoedu.demo.mvc.controller.DemoController
                classmMapping.put(clazzName, null);
            }
        }
        System.out.println("classmMapping length :" + classmMapping.size());
    }
    */
    private void doScanner(File file) {
        if (file != null) {
            File[] f = file.listFiles();
            if (f != null) {
                for (int i = 0; i < f.length; i++) {
                    doScanner(f[i]);
                }
            } else {
                System.out.println(file);

                // 处理文件的相对路径:
                putRelativePathToMap(file);
            }
        }
    }

    public void putRelativePathToMap(File file) {
        String filePath = file.getPath().replaceAll("\\\\", "\\.");
        int a  = filePath.indexOf("com.gupaoedu");
        System.out.println("a:" + a);
        filePath = filePath.substring(a).replace(".class", "");
        classmMapping.put(filePath, null);
    }


}

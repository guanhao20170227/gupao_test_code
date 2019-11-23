package com.haohao.designpatterns.f_delegate.demo2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class MyDispatchServlet2 extends HttpServlet {

    private static Map<String, Object> mapController = new HashMap<String, Object>();
    private static Map<String, MyDispatchServlet2> mapInstance = new HashMap<String, MyDispatchServlet2>();

    static {
        mapController.put("getMemberById", new MemberController());
        mapController.put("getOrderById", new OrderController());
        mapController.put("logout", new SystemController());

        mapInstance.put(MyDispatchServlet2.class.getName(), new MyDispatchServlet2());
    }

    // 使用容器式单例吧，

    // web.xml 中
    // <servlet-class>com.haohao.designpatterns.f_delegate.demo2.MyDispatchServlet2</servlet-class>
    // 要求该类必须有默认的构造方法, 所有后面看这个地方还怎么处理的把.
    /*private MyDispatchServlet2() {
        // 1 防止反射破坏单例;
        if (mapController.get(MyDispatchServlet2.class.getName()) != null) {
            throw new RuntimeException("不能创建多个实例");
        }
    }*/

    // 2， 防止序列化破坏单例;
    public Object readResolve(){ return mapInstance.get(MyDispatchServlet2.class.getName()); }

    // 单例的全局访问点
    public static MyDispatchServlet2 getInstance() throws IllegalAccessException, InstantiationException {
        if (!mapInstance.containsKey(MyDispatchServlet2.class.getName())) {
            mapInstance.put(MyDispatchServlet2.class.getName(), MyDispatchServlet2.class.newInstance());
        }
        return mapInstance.get(MyDispatchServlet2.class.getName());
    }




    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            doDispatch(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void doDispatch(HttpServletRequest req, HttpServletResponse resp) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        String uri = req.getRequestURI().replace("/web/", "");
        Object obj = mapController.get(uri);

        try {
            // 获取 Object 的方法并执行
            Method method = obj.getClass().getMethod(uri,String.class);
            System.out.println(method);
            method.invoke(obj, "12345");
        } catch(Exception ex) {
            try {
                resp.getWriter().write("404 Not Found.");
            } catch (IOException e) {
                e.printStackTrace();
            }
            ex.printStackTrace();
        }
    }




}

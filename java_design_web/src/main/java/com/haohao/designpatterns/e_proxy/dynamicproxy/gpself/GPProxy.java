package com.haohao.designpatterns.e_proxy.dynamicproxy.gpself;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 这个是用于生成源码的工具类
 */
public class GPProxy {

    public static final String LN = "\r\n";
    private static Map<Class, Class> mappings = new HashMap<Class, Class>();

    static {
        mappings.put(int.class, Integer.class);
    }

    /***
     *
     * @param classLoader
     * @param interfaces : 这个就是 被代理对象 实现的接口;
     * @param handler
     * @return
     */
    public static Object newProxyInstance(GPClassLoader classLoader, Class<?>[] interfaces,
                                          GPInvocationHandler handler) {
        try {
            // 1 生成 *.java 文件
            String src = generateSrc(interfaces);
            System.out.println("######");
            System.out.println(src);
            System.out.println("######");

            // 2 Java 输出到磁盘
            String filePath = GPProxy.class.getResource("").getPath();
            // System.out.println("filePath :" + filePath);
            //filePath = "I:/develop/code/idea_code/gupao_test_code/java_design/out/production/java_design/com/haohao/e_proxy/dynamicproxy/gpself/";
            //System.out.println("filePath :" + filePath);
            File file = new File(filePath + "$Proxy0.java");
            FileWriter fw = new FileWriter(file);
            fw.write(src);

            fw.flush();
            fw.close();

            // 3 编译 *.java 源文件成 *.class 文件
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager manager = compiler.getStandardFileManager(null, null, null);
            Iterable iterable = manager.getJavaFileObjects(file);
            JavaCompiler.CompilationTask task = compiler.getTask(null, manager, null, null, null, iterable);
            task.call();

            manager.close();

            // 4 将 *.class 文件加载到 JVM 中来;
            Class proxyClass = classLoader.findClass("$Proxy0");
            System.out.println("######");
            System.out.println(proxyClass);
            System.out.println("######");
            Constructor c = proxyClass.getConstructor(GPInvocationHandler.class);

            file.delete();

            // 5 返回字节码重组后新的代理对象;
            return c.newInstance(handler);

        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private static String generateSrc(Class<?>[] interfaces) {
        StringBuffer sb = new StringBuffer();
        sb.append("package com.haohao.e_proxy.dynamicproxy.gpself;" + LN);
        sb.append("import com.haohao.e_proxy.dynamicproxy.gpself.Person;" + LN);
        sb.append("import java.lang.reflect.*;" + LN);
        sb.append("public class $Proxy0 implements " + interfaces[0].getName() +" {" + LN);
            sb.append("public GPInvocationHandler handler;" + LN);
            sb.append("public $Proxy0(GPInvocationHandler handler) {" +LN);
                sb.append("this.handler = handler;" + LN);
            sb.append("}" +LN);
            for (Method method : interfaces[0].getMethods()) {
                // method 有哪些方法呀！
                Class<?>[] params = method.getParameterTypes();

                // 参数类型
                StringBuffer paramNames = new StringBuffer();
                // 参数值
                StringBuffer paramVales = new StringBuffer();
                // 参数类型的 Class 对象
                StringBuffer paramClasses = new StringBuffer();

                for (int i = 0; i < params.length; i ++) {
                    Class clazz = params[i];

                    //
                    String type = clazz.getName();
                    //
                    System.out.println("clazz.getSimpleName() :" + clazz.getSimpleName());
                    String paramName = toLowerFirstCase(clazz.getSimpleName());
                    paramNames.append(type + " " + paramName);
                    paramVales.append(paramName);
                    // eg: String.class, Object.Class
                    paramClasses.append(clazz.getName() + ".class");
                    if (i > 0 && i < params.length -1) {
                        paramNames.append(",");
                        paramClasses.append(",");
                        paramVales.append(",");
                    }
                }
                sb.append("public " + method.getReturnType().getSimpleName() + " " + method.getName()
                        + "(" + paramNames.toString() + ") {" + LN);
                    sb.append("try {" + LN);
                        sb.append("Method method = " + interfaces[0].getName() + ".class.getMethod(\""
                            + method.getName() + "\", new Class[] {" +paramClasses.toString() + "});" + LN);
                        sb.append((hasReturnValue(method.getReturnType()) ? "return" : "") +
                            getCaseCode("this.handler.invoke(this, method, new Object[]{" + paramVales+ "})", method.getReturnType()) + ";" + LN);
                    sb.append("} catch(Throwable ex) {" + LN);
                        sb.append("ex.printStackTrace();" + LN);
                    sb.append("}" + LN);
                    sb.append(getReturnEmptyCode(method.getReturnType()));
                sb.append("}" +LN);

            }

        sb.append("}");
        return sb.toString();
    }


    private static String toLowerFirstCase(String name) {
        char[] chars = name.toCharArray();
        chars[0] += 32;
        return String.valueOf(chars);
    }

    private static boolean hasReturnValue(Class<?> clazz) {
        return clazz != void.class;
    }

    private static String getCaseCode(String code, Class<?> returnClass) {
        if (mappings.containsKey(returnClass)) {
            return "((" + mappings.get(returnClass).getName() + ")" + code + ")." +
                    returnClass.getSimpleName() + "Value()";
        }
        return code;
    }

    private static String getReturnEmptyCode(Class<?> returnClass) {
        if (mappings.containsKey(returnClass)) {
            return "return 0;";
        } else if (returnClass == void.class) {
            return "";
        } else {
            return "return null;";
        }
    }
}

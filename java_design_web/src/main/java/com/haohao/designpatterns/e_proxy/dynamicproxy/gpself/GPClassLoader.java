package com.haohao.designpatterns.e_proxy.dynamicproxy.gpself;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class GPClassLoader extends ClassLoader {

    private File classPathFile;

    public GPClassLoader() {
        String classPath = GPClassLoader.class.getResource("").getPath();
        this.classPathFile = new File(classPath);
        System.out.println("classPathFile: " + classPathFile);
    }

    protected Class<?> findClass(String name) {

        String className = GPClassLoader.class.getPackage().getName() + "." + name;
        if (classPathFile != null) {
            // 看一下这个 classFile
            File classFile =
                    new File(classPathFile, name.replaceAll("\\.", "/") + ".class");
            if (classFile.exists()) {
                FileInputStream fis = null;
                ByteArrayOutputStream baos = null;

                try {
                    fis = new FileInputStream(classFile);
                    baos = new ByteArrayOutputStream();
                    byte[] buff = new byte[1024];
                    int len;
                    while ((len = fis.read(buff)) != -1) {
                        baos.write(buff, 0, len);
                    }
                    return defineClass(className, baos.toByteArray(), 0, baos.size());
                } catch(Exception ex) {
                    ex.printStackTrace();
                } finally {
                    if (null != fis) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (null != baos) {
                        try {
                            baos.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return null;
    }
}

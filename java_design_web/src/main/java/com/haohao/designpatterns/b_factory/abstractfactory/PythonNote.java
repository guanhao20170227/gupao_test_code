package com.haohao.designpatterns.b_factory.abstractfactory;

public class PythonNote implements INote {
    @Override
    public void edit() {
        System.out.println("编写 python 笔记.");
    }
}

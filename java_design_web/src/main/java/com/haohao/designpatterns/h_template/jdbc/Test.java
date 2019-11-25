package com.haohao.designpatterns.h_template.jdbc;

import java.util.List;

/**
 * 这个类没有测试 到后面学习了 spring + mybatis hou, 在了解 这个设计吧
 */

public class Test {

    public static void main(String[] args) {
        MemberDao dao = new MemberDao(null);
        List<?> result = dao.selectAll();
        System.out.println(result);
    }
}

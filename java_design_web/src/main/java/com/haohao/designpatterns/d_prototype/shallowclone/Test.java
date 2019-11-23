package com.haohao.designpatterns.d_prototype.shallowclone;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {

        ConcretePrototypeA prototypeA = new ConcretePrototypeA();

        prototypeA.setAge(18);
        prototypeA.setName("pie");
        List<String> hobbies = new ArrayList<String>();
        hobbies.add("swimming");
        prototypeA.setHobbies(hobbies);

        System.out.println(prototypeA);

        // copy
        Client client = new Client(prototypeA);
        ConcretePrototypeA copyA = (ConcretePrototypeA) client.startClone(prototypeA);

        System.out.println(copyA);

        System.out.println("克隆对象中引用类型属性的地址：" + copyA.getHobbies());
        System.out.println("原对象中引用类型属性的地址：" + prototypeA.getHobbies());

        System.out.println(copyA.getHobbies() == prototypeA.getHobbies()); // 地址都是一样的
        System.out.println(copyA.getAge() == prototypeA.getAge());
        System.out.println(copyA.getName() == prototypeA.getName());


    }
}

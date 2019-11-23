package com.haohao.designpatterns.d_prototype.shallowclone;

public class Client {

    private MyPrototype myPrototype;

    public Client(MyPrototype myPrototype) {
        this.myPrototype = myPrototype;
    }

    public MyPrototype startClone(MyPrototype concretePrototype) {
        return concretePrototype.clone();
    }
}

package com.haohao.designpatterns.d_prototype.deepclone;

import java.io.Serializable;

public class JinGuBang implements Serializable {

    public float h = 100;
    public float d = 10;

    public void becomeBig() {
        this.d *= 2;
        this.h *= 2;
    }

    public void becomeSmall() {
        this.d /= 2;
        this.h /= 2;
    }

}

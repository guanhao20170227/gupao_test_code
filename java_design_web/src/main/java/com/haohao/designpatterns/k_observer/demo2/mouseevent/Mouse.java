package com.haohao.designpatterns.k_observer.demo2.mouseevent;

import com.haohao.designpatterns.k_observer.demo2.MyEventListener;

public class Mouse extends MyEventListener {

    public void click() {
        System.out.println("调用鼠标的 click 方法.");
        this.trigger(MouseEventType.ON_CLICK);
    }

    public void doubleClick() {
        System.out.println("调用鼠标 doubleClick 的方法.");
        this.trigger(MouseEventType.ON_DOUBLE_CLICK);
    }

    public void up() {
        System.out.println("调用鼠标 up 的方法.");
        this.trigger(MouseEventType.ON_UP);
    }
}

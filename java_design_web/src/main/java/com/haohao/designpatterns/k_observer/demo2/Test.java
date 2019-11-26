package com.haohao.designpatterns.k_observer.demo2;

import com.haohao.designpatterns.k_observer.demo2.mouseevent.Mouse;
import com.haohao.designpatterns.k_observer.demo2.mouseevent.MouseEventCallback;
import com.haohao.designpatterns.k_observer.demo2.mouseevent.MouseEventType;

public class Test {

    public static void main(String[] args) {

        MouseEventCallback callback = new MouseEventCallback();

        Mouse mouse = new Mouse();
        mouse.addListener(MouseEventType.ON_CLICK, callback);
        mouse.addListener(MouseEventType.ON_DOUBLE_CLICK, callback);
        mouse.addListener(MouseEventType.ON_UP, callback);

        mouse.click();
        mouse.doubleClick();
        mouse.up();

    }
}

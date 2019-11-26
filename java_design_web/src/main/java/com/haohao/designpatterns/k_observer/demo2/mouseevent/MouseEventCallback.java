package com.haohao.designpatterns.k_observer.demo2.mouseevent;

import com.haohao.designpatterns.k_observer.demo2.MyEvent;

public class MouseEventCallback {

    public void onClick(MyEvent event) {
        System.out.println("---触发鼠标单击事件---" + "\n" + event);
    }

    public void onDoubleClick(MyEvent event) {
        System.out.println("---触发鼠标双击事件---" + "\n" + event);
    }

    public void onUp(MyEvent event) {
        System.out.println("---触发鼠标弹起事件---" + "\n" + event);
    }
}

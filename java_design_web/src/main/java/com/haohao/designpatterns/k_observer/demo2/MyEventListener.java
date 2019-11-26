package com.haohao.designpatterns.k_observer.demo2;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class MyEventListener {

    protected Map<String, MyEvent> events = new HashMap<String, MyEvent>();

    // 根据事件名称和一个目标对象来触发事件;
    public void addListener(String eventType, Object target) {
        try {
            this.addListener(eventType, target,
                    target.getClass().getMethod("on" + toUpperFirstCase(eventType), MyEvent.class));
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    public void addListener(String eventType, Object target, Method callback) {
        events.put(eventType, new MyEvent(target, callback));
    }

    public String toUpperFirstCase(String str) {
        char[] chars = str.toCharArray();
        chars[0] -= 32; // a(ASCII97), A(65)
        return String.valueOf(chars);
    }

    // 触发事件
    private void trigger(MyEvent myEvent) {
        myEvent.setSource(this);
        myEvent.setTime(System.currentTimeMillis());

        try {
            // 回调
            if (myEvent.getCallback() != null) {
                myEvent.getCallback().invoke(myEvent.getTarget(), myEvent);
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    protected void trigger(String trigger) {
        if (!this.events.containsKey(trigger)) {
            return;
        }
        trigger(this.events.get(trigger));
    }
}

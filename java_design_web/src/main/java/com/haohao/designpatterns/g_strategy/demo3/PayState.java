package com.haohao.designpatterns.g_strategy.demo3;

public class PayState {

    private Integer uid;
    private String payResult;
    private Object description;

    public PayState(Integer uid, String payResult, Object description) {
        this.uid = uid;
        this.payResult = payResult;
        this.description = description;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getPayResult() {
        return payResult;
    }

    public void setPayResult(String payResult) {
        this.payResult = payResult;
    }

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "PayState{" +
                "uid=" + uid +
                ", payResult='" + payResult + '\'' +
                ", description=" + description +
                '}';
    }
}

package com.haohao.designpatterns.i_adapter.electric;

public class Test {

    public static void main(String[] args) {

        AC220V ac220V = new AC220V();
        IDC5V idc5V = new ElectricAdapter(ac220V);
        idc5V.outputDC5V();

    }
}

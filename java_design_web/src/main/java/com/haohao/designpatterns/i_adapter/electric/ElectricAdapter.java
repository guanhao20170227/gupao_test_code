package com.haohao.designpatterns.i_adapter.electric;

public class ElectricAdapter implements IDC5V {

    private AC220V ac220V;

    public ElectricAdapter(AC220V ac220V) {
        this.ac220V = ac220V;
    }

    @Override
    public Integer outputDC5V() {
        int inputElectricValue = ac220V.outputAC220V();
        // 执行变化的算法
        int outputValue = inputElectricValue/44;
        System.out.println("使用 ElectricAdapter 输入 AC: " + inputElectricValue +
                "V, 输出 DC: " + outputValue + "V.");
        return outputValue;
    }
}

package com.haohao.designpatterns.i_adapter.electric;
/**
 *  原有的 220v 交流电电压;
 */

public class AC220V {

    public Integer outputAC220V() {
        int output = 220;
        System.out.println("输出交流电压: " + output + "V.");
        return output;
    }

}

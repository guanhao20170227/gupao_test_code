package com.haohao.designpatterns.i_adapter.electric;

/***
 *  手机充电器电压: DC 5V;
 *      新的需要输出的手机电压--> 所以需要适配器适配 5V 电压;
 */

public interface IDC5V {
    Integer outputDC5V();
}

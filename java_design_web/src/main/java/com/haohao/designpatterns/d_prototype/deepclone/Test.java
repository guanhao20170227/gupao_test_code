package com.haohao.designpatterns.d_prototype.deepclone;

public class Test {

    public static void main(String[] args) {

        try {
            QiTianDaSheng qiTianDaSheng = new QiTianDaSheng();

            QiTianDaSheng clone = (QiTianDaSheng) qiTianDaSheng.clone();

            System.out.println("深克隆: " + (qiTianDaSheng.jinGuBang == clone.jinGuBang));
        } catch(Exception ex) {
            ex.printStackTrace();
        }


        try {
            QiTianDaSheng q2 = new QiTianDaSheng();

            QiTianDaSheng shallowClone = (QiTianDaSheng) q2.shallowClone(q2);

            System.out.println("浅克隆: " + (q2.jinGuBang == shallowClone.jinGuBang));
        } catch(Exception ex) {
            ex.printStackTrace();
        }

    }
}

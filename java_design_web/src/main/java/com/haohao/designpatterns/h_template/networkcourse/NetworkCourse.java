package com.haohao.designpatterns.h_template.networkcourse;

/**
 *  接口定义网课制作的流程
 */
public abstract class NetworkCourse {

    protected final void createCourse() {

        // 1, 发布预习资料;
        postPreResource();

        // 2, 制作 PPT 课件;
        createPPT();

        // 3. 在线直播
        liveVideo();

        // 4. 发布课堂笔记
        postNotes();

        // 5. 提交源码
        postSource();

        // 6. 布置作业, 有作业的还要检查作业, 没有作业的流程就完成了;
        if (needHomework()) {
            checkHomework();
        } else {
            System.out.println("6 没有作业.");
        }
    }

    abstract void checkHomework();

    // needHomework  就是一个钩子函数, 实现流程的微调;
    protected boolean needHomework() { return false; }

    final void postSource() {
        System.out.println("5 老师提交源码.");
    }

    final void postNotes() {
        System.out.println("4 老师发布课堂笔记.");
    }


    final void postPreResource() {
        System.out.println("1 老师负责提交预习资料.");
    }

    final void createPPT() {
        System.out.println("2 老师负责制作 PPT.");
    }

    final void liveVideo() {
        System.out.println("3 老师负责在线直播课程.");
    }
}

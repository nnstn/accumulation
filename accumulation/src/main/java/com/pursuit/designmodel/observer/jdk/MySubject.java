package com.pursuit.designmodel.observer.jdk;

import java.util.Observable;

/**
 * 被观察者，开发填写自己所需要实现的功能
 * @author christmas
 */
public class MySubject extends Observable {

    // 目标的内容
    private String sujectContent;

    public String getSujectContent() {
        return sujectContent;
    }

    public void setSujectContent(String sujectContent) {
        this.sujectContent = sujectContent;
        // 是用jdk 必须要先调用此方法。
        setChanged();
        // 通知观察则变化 拉模式
        //notifyObservers();
        // 通知观察则变化 推模式
        notifyObservers(sujectContent);
     }
}

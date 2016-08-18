package com.pursuit.designmodel.observer.jdk;

import java.util.Observable;
import java.util.Observer;

public class MyObserver implements Observer {

    private String observerName;

    @Override
    public void update(Observable o, Object arg) {
        MySubject subject = (MySubject) o;
        System.out.println(observerName + "收到了目标变化，拉模式，获取变化的内容"
                + subject.getSujectContent());

        System.out.println(observerName + "收到了目标变化，推模式，获取变化的内容" + arg);
    }

    public String getObserverName() {
        return observerName;
    }

    public void setObserverName(String observerName) {
        this.observerName = observerName;
    }

}
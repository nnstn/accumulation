package com.pursuit.designmodel.observer.my;

import java.util.Vector;

public interface IObservable {
	Vector<IObserver> updatelist =  new Vector<IObserver>();
	public boolean addObserver(IObserver observer);
	public boolean deleteObserver(IObserver observer);
	public void info();
	
}

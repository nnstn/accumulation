package com.pursuit.designmodel.observer.my;

public class MyObservable implements IObservable {

	@Override
	public boolean addObserver(IObserver observer) {
		return updatelist.add(observer);

	}

	@Override
	public boolean deleteObserver(IObserver observer) {
		return updatelist.remove(observer);

	}

	@Override
	public void info() {
		for (int i = 0; i < updatelist.size(); i++) {
			updatelist.get(i).update(new Object());;
		}
	}

}

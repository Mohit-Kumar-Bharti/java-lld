package com.mohit.observer;

import java.util.ArrayList;
import java.util.List;

public interface Subject {
    void addObserver(Observer obs);
    void removeObserver(Observer obs);
    void notifyAllObserver();
}

class IPL implements Subject {
    List<Observer> observers;

    public IPL() {
        observers = new ArrayList<>();
    }

    @Override
    public void addObserver(Observer obs) {
        observers.add(obs);
    }

    @Override
    public void removeObserver(Observer obs) {
        int index = observers.indexOf(obs);
        if(index != -1) observers.remove(index);
    }

    @Override
    public void notifyAllObserver() {
        for(Observer obs : observers) {
            obs.update();
        }
    }
}





package com.mohit.observer;

public interface Observer {
    void update() ;
}

class TV implements Observer{
    @Override
    public void update() {
        System.out.println("Tv is updated");
    }
}

class JIOCinema implements Observer {
    @Override
    public void update() {
        System.out.println("JIO Cinema is update");
    }
}

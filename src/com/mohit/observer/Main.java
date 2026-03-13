package com.mohit.observer;

public class Main {
    static void main() {

        System.out.println("this is main class");
        Subject subject = new IPL();

        Observer obs1 = new JIOCinema();
        Observer obs2 = new TV();

        subject.addObserver(obs1);
        subject.addObserver(obs2);

        subject.notifyAllObserver();

        subject.removeObserver(obs1);

        subject.notifyAllObserver();


    }
}

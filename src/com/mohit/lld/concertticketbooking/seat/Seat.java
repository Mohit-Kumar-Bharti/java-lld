package com.mohit.lld.concertticketbooking.seat;

public class Seat {
    String id;
    int seatNumber;
    SeatType type;
    SeatStatus status;
    double price;

    public Seat(String id, int seatNumber, SeatType type, double price) {
        this.id = id;
        this.seatNumber = seatNumber;
        this.type = type;
        this.price = price;
        this.status = SeatStatus.AVALIABLE;
    }

    public synchronized boolean book() {
        if(status == SeatStatus.AVALIABLE) {
            status = SeatStatus.UNAVAILABLE;
            return true;
        }
        return false;
    }

    public synchronized void unbook() {
        if(status == SeatStatus.UNAVAILABLE) {
            status = SeatStatus.AVALIABLE;
        }
    }

    public synchronized boolean isAvailable() {
        if(status == SeatStatus.AVALIABLE) {
            return true;
        }
        return false;
    }
}

package com.mohit.lld.concertticketbooking.concert;

import com.mohit.lld.concertticketbooking.seat.Seat;

import java.util.List;

public class Concert {
    String id;
    String artist;
    List<Seat> seats;

    public Concert(String id, String artist) {
        this.id = id;
        this.artist = artist;
    }

    public String getId() {
        return id;
    }

}

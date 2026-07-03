package com.mohit.bookmyshow;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Show {
    String id;
    int to,from;
    LocalDateTime date;
    Movie movie;
    List<Seat> bookedSearts = new ArrayList<>();
    List<Seat> lockedSeats = new ArrayList<>();
}

package com.mohit.lld.concertticketbooking.booking;

import com.mohit.lld.concertticketbooking.concert.Concert;
import com.mohit.lld.concertticketbooking.seat.Seat;
import com.mohit.lld.concertticketbooking.user.User;

import java.util.List;

public class Booking {
    String id;
    User user;
    List<Seat> seats;
    Concert concert;
    BookingStatus bookingStatus;

    public Booking(String id, User user, Concert concert, List<Seat> seats) {
        this.id = id;
        this.user = user;
        this.concert = concert;
        this.bookingStatus = BookingStatus.PENDING;
        this.seats = seats;
    }

    public void confirmBooking(){
        bookingStatus = BookingStatus.CONFIRMED;
    }

    public void cancelBooking(){
        seats.forEach(seat -> seat.unbook());
        bookingStatus = BookingStatus.CANCELLED;
    }

    public String getBookingId() {
        return this.id;
    }



}

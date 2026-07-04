package com.mohit.lld.concertticketbooking;

import com.mohit.lld.concertticketbooking.booking.Booking;
import com.mohit.lld.concertticketbooking.concert.Concert;
import com.mohit.lld.concertticketbooking.seat.Seat;
import com.mohit.lld.concertticketbooking.user.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class ConcertTicketSer {
    private static ConcertTicketSer Instance;
    Map<String, Booking> bookingRegistry;
    Map<String, Concert> concertRegistry;
    Object lock = new Object();

    private ConcertTicketSer() {
        bookingRegistry = new ConcurrentHashMap<>();
        concertRegistry = new ConcurrentHashMap<>();
    }

    public static synchronized ConcertTicketSer getInstance() {
        if (Instance == null) {
           Instance = new ConcertTicketSer();
        }
        return Instance;
    }

    public void addConcert(Concert concert) {
        concertRegistry.put(concert.getId(), concert);
    }

    public void removeConcert(Concert concert) {
        concertRegistry.remove(concert.getId());
    }

    public Concert getConcert(String id) {
        return concertRegistry.get(id);
    }

    public Booking bookTicket(Concert concert, List<Seat> seats, User user) {
        synchronized (lock) {
            for (Seat seat : seats) {
                if(!seat.isAvailable())
                    return null;
            }

            seats.forEach(seat -> seat.book());

            Booking booking = new Booking(UUID.randomUUID().toString(), user, concert, seats);
            bookingRegistry.put(booking.getBookingId(), booking);

            booking.confirmBooking();
            return booking;
        }
    }

    public void cancelTicket(String bookingId) {
        Booking booking = bookingRegistry.get(bookingId);
        if (booking == null) {
            return;
        }
        bookingRegistry.remove(booking.getBookingId());
        booking.cancelBooking();
    }
}

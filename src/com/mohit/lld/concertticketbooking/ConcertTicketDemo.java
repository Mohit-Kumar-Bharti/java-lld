package com.mohit.lld.concertticketbooking;

import com.mohit.lld.concertticketbooking.booking.Booking;
import com.mohit.lld.concertticketbooking.concert.Concert;
import com.mohit.lld.concertticketbooking.seat.Seat;
import com.mohit.lld.concertticketbooking.seat.SeatType;
import com.mohit.lld.concertticketbooking.user.User;

import java.util.ArrayList;
import java.util.List;

public class ConcertTicketDemo {
    public static void main(String[] args) {
        User user = new User("admin", "mohit", "abc@gmail.com");


        List<Seat> seats = generateSeat(100);

        Concert concert = new Concert("con_id", "arijit");

        ConcertTicketSer concertTicketSer = ConcertTicketSer.getInstance();

        concertTicketSer.addConcert(concert);

        Booking booking =  concertTicketSer.bookTicket(concert,seats,user);
        if (booking != null) {
            System.out.println("Concert booking is created");
        } else  {
            System.out.println("Concert booking isn't created");
        }

        concertTicketSer.cancelTicket(booking.getBookingId());



    }

    public static List<Seat> generateSeat(int count) {
        List<Seat> seats = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String seatId = "id" + i;
            int seatNumber = i + 1;
            double price = seatId.length() * seatNumber;
            seats.add(new Seat(seatId, seatNumber, SeatType.REGULAR, price));
        }
        return seats;
    }
}

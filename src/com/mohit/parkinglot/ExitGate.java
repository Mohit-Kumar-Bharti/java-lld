package com.mohit.parkinglot;

import java.time.LocalDateTime;

public class ExitGate {
    BillingService billingServie;
    public ExitGate(BillingService billingService){
        this.billingServie = billingService;
    }

    public void processExit(Ticket ticket) {
        double price = billingServie.calculatePrice(ticket, LocalDateTime.now());
        System.out.println("pay ... " + price);

    }


}

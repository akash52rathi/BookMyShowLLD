package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class Booking {
    private Show show;
    private List<Seat>boookedsheats = new ArrayList<>();
    private Payment payment;

    public Booking(Show userShow, Payment payment) {
        show=userShow;
        payment=payment;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public List<Seat> getBoookedsheats() {
        return boookedsheats;
    }

    public void setBoookedsheats(List<Seat> boookedsheats) {
        this.boookedsheats = boookedsheats;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}

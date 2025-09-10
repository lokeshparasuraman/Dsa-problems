package Oops.HashMapTrainBookingSystem;

import Oops.HashMapTrainBookingSystem.Passenger;

public class Ticket{
    String ticketId;
    Passenger passenger;
    String berth;
    String status;

    Ticket(String ticketId, Passenger passenger, String berth, String status) {
        this.ticketId = ticketId;
        this.passenger = passenger;
        this.berth = berth;
        this.status = status;
    }
    @Override
    public String toString(){
        return "Ticket ID:"+ticketId+"Passenger:"+passenger+"Berth:"+berth+"Status:"+status;
    }
}


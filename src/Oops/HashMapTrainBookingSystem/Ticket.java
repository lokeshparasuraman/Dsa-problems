package Oops.HashMapTrainBookingSystem;

public class Ticket {
    String ticketId;
    Passenger passenger;
    String berth;
    String status;
    int trainNo;
    String trainName;

    Ticket(String ticketId, Passenger passenger, String berth, String status, int trainNo, String trainName) {
        this.ticketId = ticketId;
        this.passenger = passenger;
        this.berth = berth;
        this.status = status;
        this.trainNo = trainNo;
        this.trainName = trainName;
    }

    @Override
    public String toString() {
        return "Ticket ID: " + ticketId +
                " | Passenger: " + passenger +
                " | Berth: " + berth +
                " | Status: " + status +
                " | Train No: " + trainNo +
                " | Train Name: " + trainName;
    }
}

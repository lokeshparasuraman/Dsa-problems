package Oops.TrainBookApplication;

public class Passenger {
    String name;
    int age;
    String gender;
    String berthPreferred;
    String allottedBerth;
    String ticketId;

    Passenger(String name, int age, String gender, String berthPreferred, String allocatedBerth, String tickerId) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.berthPreferred = berthPreferred;
        this.allottedBerth = allocatedBerth;
        this.ticketId = tickerId;
    }

    @Override
    public String toString() {
        return "TicketId:" + ticketId + " Passenger_Name:" + name + " Age:" + age + " Gender:" + gender + " Berth:" + allottedBerth;
    }
}

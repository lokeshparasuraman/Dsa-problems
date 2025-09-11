package Oops.HashMapTrainBookingSystem;

import java.util.*;

public class BookingSystem {
    public static HashMap<String, Ticket> tickets = new HashMap<>();
    public static HashMap<Integer, Train> trains = new HashMap<>();

    public void bookTicket(int trainNo, Passenger p) {
        Train train = trains.get(trainNo);
        if (train == null) {
            System.out.println("Train not found!");
            return;
        }

        String ticketId = "T" + train.tc++;
        String berth = null, status = null;

        // Try preference first
        if ((p.age > 60 || p.gender.equalsIgnoreCase("female")) && !train.lowerBerths.isEmpty()) {
            berth = train.lowerBerths.poll();
            status = "Confirmed";
        } else if (p.berthPreference.equals("L") && !train.lowerBerths.isEmpty()) {
            berth = train.lowerBerths.poll();
            status = "Confirmed";
        } else if (p.berthPreference.equals("U") && !train.upperBerths.isEmpty()) {
            berth = train.upperBerths.poll();
            status = "Confirmed";
        }
        // Assign opposite berth if preference not available
        else if (!train.lowerBerths.isEmpty()) {
            berth = train.lowerBerths.poll();
            status = "Confirmed";
        } else if (!train.upperBerths.isEmpty()) {
            berth = train.upperBerths.poll();
            status = "Confirmed";
        }
        // No berths → RAC
        else if (train.racQueue.size() < train.racLimit) {
            status = "RAC";
            Ticket t = new Ticket(ticketId, p, null, status, trainNo, train.trainName);
            train.racQueue.add(t);
            tickets.put(ticketId, t);
            return;
        }
        // No RAC → WL
        else if (train.waitingList.size() < train.wlLimit) {
            status = "Waiting";
            Ticket t = new Ticket(ticketId, p, null, status, trainNo, train.trainName);
            train.waitingList.add(t);
            tickets.put(ticketId, t);
            return;
        } else {
            System.out.println("Booking failed! No berth, RAC, or WL available.");
            return;
        }


        Ticket ticket = new Ticket(ticketId, p, berth, status, trainNo, train.trainName);
        tickets.put(ticketId, ticket);
        train.confirmedTickets.put(ticketId, ticket);
    }

    public void viewTrainDetails() {
        for (Train train : trains.values()) {
            System.out.println("\nTrain No: " + train.trainNo + " | " + train.trainName);

            int totalCapacity = train.getTotalBerthCapacity();
            int booked = train.confirmedTickets.size();

            System.out.println("Confirmed Tickets: " + booked + "/" + totalCapacity);
            System.out.println("RAC: " + train.racQueue.size() + "/" + train.racLimit);
            System.out.println("WL: " + train.waitingList.size() + "/" + train.wlLimit);
            System.out.println("---------------------------");
        }
    }


    public void viewTickets() {
        if (tickets.isEmpty()) {
            System.out.println("No tickets available.");
            return;
        }
        for (Train t : trains.values()) {
            System.out.println("Train Number:" + t.trainNo + "|" + "Train Name:" + t.trainName);
            for (Ticket ticket : tickets.values()) {
                System.out.println("Ticket ID: " + ticket.ticketId);
                System.out.println(ticket.passenger);
                System.out.println("Train No: " + ticket.trainNo + " | " + ticket.trainName);
                System.out.println("Berth: " + ticket.berth);
                System.out.println("Status: " + ticket.status);
                System.out.println("---------------------------");
            }
        }

    }

    public void cancelTicket(String ticketId) {
        Ticket ticket = tickets.get(ticketId);
        if (ticket == null || ticket.status.equals("Cancelled")) return;

        Train train = trains.get(ticket.trainNo);
        if (train == null) {
            System.out.println("Train not found for ticket " + ticketId);
            return;
        }

        // Free berth if confirmed
        if (ticket.status.equals("Confirmed")) {
            String cancelledBerth = ticket.berth;
            if (cancelledBerth.startsWith("L")) train.lowerBerths.add(cancelledBerth);
            else if (cancelledBerth.startsWith("U")) train.upperBerths.add(cancelledBerth);

            // Upgrade RAC → Confirmed
            if (!train.racQueue.isEmpty()) {
                Ticket racTicket = train.racQueue.poll();
                if (!train.lowerBerths.isEmpty()) racTicket.berth = train.lowerBerths.poll();
                else if (!train.upperBerths.isEmpty()) racTicket.berth = train.upperBerths.poll();
                racTicket.status = "Confirmed";
                train.confirmedTickets.put(racTicket.ticketId, racTicket);
                System.out.println("RAC Ticket " + racTicket.ticketId + " upgraded to Confirmed");

                // Upgrade WL → RAC
                if (!train.waitingList.isEmpty()) {
                    Ticket wlTicket = train.waitingList.poll();
                    wlTicket.status = "RAC";
                    train.racQueue.add(wlTicket);
                    System.out.println("WL Ticket " + wlTicket.ticketId + " moved to RAC");
                }
            }
        } else if (ticket.status.equals("RAC")) {
            train.racQueue.remove(ticket);
            if (!train.waitingList.isEmpty()) {
                Ticket wlTicket = train.waitingList.poll();
                wlTicket.status = "RAC";
                train.racQueue.add(wlTicket);
                System.out.println("WL Ticket " + wlTicket.ticketId + " moved to RAC");
            }
        } else if (ticket.status.equals("Waiting")) {
            train.waitingList.remove(ticket);
        }


        tickets.remove(ticketId);
        train.confirmedTickets.remove(ticketId);

        ticket.status = "Cancelled";
        System.out.println("Ticket " + ticketId + " cancelled successfully from Train " + train.trainNo);
    }


}

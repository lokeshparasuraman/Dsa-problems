package Oops.HashMapTrainBookingSystem;

import java.util.*;

public class BookingSystem {
    public static HashMap<String, Ticket> tickets = new HashMap<>();
    public static HashMap<Integer, Train> trains = new HashMap<>();
    int tc = 1000;

    public void bookTicket(int trainNo, Passenger p) {
        Train train = trains.get(trainNo);
        if (train == null) {
            System.out.println("Train not found!");
            return;
        }

        String ticketId = "T" + tc++;
        String berth = null, status = null;

        // Try preference first
        if (p.berthPreference.equals("L") && !train.lowerBerths.isEmpty()) {
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
            Ticket t = new Ticket(ticketId, p, null, status);
            train.racQueue.add(t);
            tickets.put(ticketId, t);
            return;
        }
        // No RAC → WL
        else if (train.waitingList.size() < train.wlLimit) {
            status = "Waiting";
            Ticket t = new Ticket(ticketId, p, null, status);
            train.waitingList.add(t);
            tickets.put(ticketId, t);
            return;
        } else {
            System.out.println("Booking failed! No berth, RAC, or WL available.");
            return;
        }

        // Create confirmed ticket
        Ticket ticket = new Ticket(ticketId, p, berth, status);
        tickets.put(ticketId, ticket);
    }

    public void viewTrains() {
        if (trains.isEmpty()) {
            System.out.println("No trains available.");
            return;
        }
        for (Train train : trains.values()) {
            System.out.println("\nTrain No: " + train.trainNo + " | " + train.trainName);
            System.out.println("Available Lower Berths: " + train.lowerBerths.size());
            System.out.println("Available Upper Berths: " + train.upperBerths.size());
            System.out.println("RAC Occupied: " + train.racQueue.size() + "/" + train.racLimit);
            System.out.println("Waiting List Occupied: " + train.waitingList.size() + "/" + train.wlLimit);
        }

    }

    public void cancelTicket(String ticketId) {
        Ticket ticket = tickets.get(ticketId);
        if (ticket == null || ticket.status.equals("Cancelled")) return;

        Train train = trains.values().iterator().next(); // assume single train for now

        // Free berth if confirmed
        if (ticket.status.equals("Confirmed")) {
            if (ticket.berth.startsWith("L")) train.lowerBerths.add(ticket.berth);
            else if (ticket.berth.startsWith("U")) train.upperBerths.add(ticket.berth);

            // Upgrade RAC → Confirmed
            if (!train.racQueue.isEmpty()) {
                Ticket racTicket = train.racQueue.poll();
                if (!train.lowerBerths.isEmpty()) racTicket.berth = train.lowerBerths.poll();
                else if (!train.upperBerths.isEmpty()) racTicket.berth = train.upperBerths.poll();
                racTicket.status = "Confirmed";
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

        ticket.status = "Cancelled";
    }

}

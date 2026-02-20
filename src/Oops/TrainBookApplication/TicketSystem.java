package Oops.TrainBookApplication;

import java.util.*;

public class TicketSystem {
    public static List<String> availableBerths = new ArrayList<>(Arrays.asList("L", "U", "M"));
    public static List<Passenger> confirmed = new ArrayList<>();
    public static Queue<Passenger> wList = new LinkedList<>();
    public static Queue<Passenger> racQueue = new LinkedList<>();
    public static int ticketNumber = 1000;


    public static String bookTicket(String name, int age, String gender, String berthPreferred) {
        String ticketId = "T" + ticketNumber++;

        if (!availableBerths.isEmpty()) {
            String allottedBerth = allottedBerth(age, gender, berthPreferred);
            Passenger passenger = new Passenger(name, age, gender, berthPreferred, allottedBerth, ticketId);
            confirmed.add(passenger);
            availableBerths.remove(allottedBerth);
            System.out.println("Ticket Confirmed:\n" + passenger);
        } else if (racQueue.size() < 1) {
            Passenger passenger = new Passenger(name, age, gender, berthPreferred, "RAC", ticketId);
            racQueue.offer(passenger);
            System.out.println("Ticket in RAC" + passenger);
        } else if (wList.size() < 1) {
            Passenger passenger = new Passenger(name, age, gender, berthPreferred, "WaitingList", ticketId);
            wList.offer(passenger);
            System.out.println("Ticket in WaitingList:" + passenger);
        } else {
            System.out.println("No Tickets Available ");
        }
        return ticketId;

    }

    public static String allottedBerth(int age, String gender, String berthPreferred) {
        if (age > 60 || gender.equalsIgnoreCase("female") && availableBerths.contains("L")) {
            return "L";
        }
        if (berthPreferred != null && !berthPreferred.isEmpty() && availableBerths.contains(berthPreferred)) {
            return berthPreferred;
        }

        return availableBerths.get(0);
    }

    public static void cancelTicket(String ticketId) {
        Optional<Passenger> passengerOpt = confirmed.stream().filter(p -> Objects.equals(p.ticketId, ticketId)).findFirst();
        if (passengerOpt.isPresent()) {
            Passenger p = passengerOpt.get();
            confirmed.remove(p);
            if (p.allottedBerth != null && !p.allottedBerth.equalsIgnoreCase("RAC")
                    && !p.allottedBerth.equalsIgnoreCase("WaitingList")) {
                availableBerths.add(p.allottedBerth);
            }

            if (!racQueue.isEmpty()) {
                Passenger rac = racQueue.poll();
                String allottedberth = allottedBerth(rac.age, rac.gender, rac.berthPreferred);
                rac.allottedBerth = allottedberth;
                confirmed.add(rac);
                availableBerths.remove(allottedberth);
                System.out.println("RAC ticket moved to confirmed" + rac);
            }
            if (!wList.isEmpty()) {
                Passenger wL = wList.poll();
                wL.allottedBerth = "RAC";
                racQueue.offer(wL);
                System.out.println("WaitingList ticket to RAC" + wL);
            }
            System.out.println("Ticket cancelled " + ticketId);
        } else {
            System.out.println("Ticket not found with ID :" + ticketId);
        }

    }

    public static void ticketsList() {
        System.out.println("************************************");
        System.out.println("..Confirmed tickets..");
        if (confirmed.isEmpty()) {
            System.out.println("No tickets confirmed\n");
        }
        else{
            for (Passenger p : confirmed) {
                System.out.println(p);
            }
        }

        System.out.println("..RAC tickets..");
        if (racQueue.isEmpty()) {
            System.out.println("No tickets in RAC\n");
        }
        else{
            for (Passenger p : racQueue) {
                System.out.println(p);
            }
        }

        System.out.println("..WaitingList tickets..");
        if (wList.isEmpty()) {
            System.out.println("No tickets in Waiting List\n");
        }
        else{
            for (Passenger p : wList) {
                System.out.println(p);
            }
        }
        System.out.println("************************************");
    }

    public static void availableTickets() {
        System.out.println("Available berths:" + availableBerths.size());
        System.out.println("Available RAC tickets:" + (1 - racQueue.size()));
        System.out.println("Available waitingList tickets:" + (1 - wList.size()));

    }
}

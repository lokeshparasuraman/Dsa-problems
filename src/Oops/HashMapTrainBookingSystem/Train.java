package Oops.HashMapTrainBookingSystem;

import java.util.*;

public class Train {
    int trainNo;
    String trainName;

    Queue<String> lowerBerths = new LinkedList<>();
    Queue<String> upperBerths = new LinkedList<>();
    Queue<Ticket> racQueue = new LinkedList<>();
    Queue<Ticket> waitingList = new LinkedList<>();

    Map<String, Ticket> confirmedTickets = new HashMap<>();

    int racLimit;
    int wlLimit;
    int tc = 1000;

    int totalLower;
    int totalUpper;

    public Train(int trainNo, String trainName, int lowerCount, int upperCount, int racLimit, int wlLimit) {
        this.trainNo = trainNo;
        this.trainName = trainName;

        // Fill lower berths
        for (int i = 1; i <= lowerCount; i++) {
            lowerBerths.add("L" + i);
        }
        // Fill upper berths
        for (int i = 1; i <= upperCount; i++) {
            upperBerths.add("U" + i);
        }

        this.racLimit = racLimit;
        this.wlLimit = wlLimit;

        this.totalLower = lowerCount;
        this.totalUpper = upperCount;
    }

    public int getTotalBerthCapacity() {
        return totalLower + totalUpper;
    }
}

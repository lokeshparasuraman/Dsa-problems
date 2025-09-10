package Oops.HashMapTrainBookingSystem;

import java.util.*;

public class Train {
    int trainNo;
    String trainName;
    Queue<String> lowerBerths;
    Queue<String> upperBerths;
    Queue<Ticket> racQueue;
    Queue<Ticket> waitingList;
    int racLimit;
    int wlLimit;
    int lowerLimit;
    int upperLimit;

    Train(int trainNo, String trainName, int lowerCount, int upperCount, int racLimit, int wlLimit) {
        this.trainNo = trainNo;
        this.trainName = trainName;
        this.lowerBerths = new LinkedList<>();
        this.upperBerths = new LinkedList<>();
        this.racQueue = new LinkedList<>();
        this.waitingList = new LinkedList<>();
        this.lowerLimit = lowerCount;
        this.upperLimit = upperCount;
        this.racLimit = racLimit;
        this.wlLimit = wlLimit;

        for (int i = 1; i <= lowerCount; i++) lowerBerths.add("L" + i);
        for (int i = 1; i <= upperCount; i++) upperBerths.add("U" + i);
    }

}
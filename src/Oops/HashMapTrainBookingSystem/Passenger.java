package Oops.HashMapTrainBookingSystem;

public class Passenger {
    String name;
    int age;
    String gender;
    String berthPreference;

    Passenger(String name, int age, String gender, String berthPreference) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.berthPreference = berthPreference;
    }

    @Override
    public String toString() {
        return " Passenger_Name:" + name + " Age:" + age + " Gender:" + gender + " Berth Preference:" + berthPreference;
    }
}

package Oops.HashMapTrainBookingSystem;
import java.util.Scanner;
import static Oops.HashMapTrainBookingSystem.BookingSystem.tickets;
import static Oops.HashMapTrainBookingSystem.BookingSystem.trains;

public class RunApp {
    static Scanner sc = new Scanner(System.in);
    static BookingSystem ticket = new BookingSystem();

    public static void main(String[] args) {
        boolean con = true;

        while (con) {
            System.out.println("... Train Booking App ...");
            System.out.println("1.Add Train\n2.Book Ticket\n3.Cancel Ticket\n4.View trains\n5.Exit");
            System.out.println("Enter Your Option");
            int c = sc.nextInt();
            sc.nextLine();
            switch (c) {
                case 1: {
                    System.out.println("ENTER TRAIN NO");
                    int trainNo = sc.nextInt();
                    sc.nextLine();
                    System.out.println("ENTER TRAIN NAME");
                    String tname = sc.nextLine().toUpperCase();
                    System.out.println("ENTER TRAIN LOWER_BERTHS COUNT");
                    int lB = sc.nextInt();
                    System.out.println("ENTER TRAIN UPPER_BERTHS COUNT");
                    int uB = sc.nextInt();
                    System.out.println("ENTER TRAIN RAC COUNT");
                    int rac = sc.nextInt();
                    System.out.println("ENTER TRAIN WAITING LIST COUNT");
                    int wL = sc.nextInt();
                    Train train = new Train(trainNo, tname, lB, uB, rac, wL);
                    trains.put(trainNo, train);
                    break;
                }
                case 2: {
                    if(trains.isEmpty()){
                        System.out.println("ADD A TRAIN FIRST TO START BOOKING");
                        break;
                    }
                    System.out.println("ENTER TRAIN NUMBER");
                    int trainNo = sc.nextInt();
                    sc.nextLine();
                    System.out.println("ENTER NAME:");
                    String name = sc.nextLine().toUpperCase();
                    System.out.println("ENTER AGE:");
                    int age = sc.nextInt();
                    sc.nextLine();
                    System.out.println("ENTER GENDER(MALE/FEMALE):");
                    String gender = sc.nextLine().toUpperCase();
                    System.out.println("ENTER BERTH YOU PREFER(L/U):");
                    String berth = sc.nextLine().toUpperCase();
                    ticket.bookTicket(trainNo, new Passenger(name, age, gender, berth));
                    break;
                }

                case 3: {
                    if(tickets.isEmpty()){
                        System.out.println("NO TICKETS WERE BOUGHT!!");
                        break;
                    }
                    System.out.println("ENTER TICKET ID TO CANCEL");
                    String id = sc.nextLine();
                    ticket.cancelTicket(id);
                    break;
                }
                case 4: {
                    if(trains.isEmpty()){
                        System.out.println("NO TRAINS WERE ADDED TO VIEW!!");
                        break;
                    }
                    ticket.viewTrains();
                    break;
                }
                case 5: {
                    System.out.println("Thank you come again");
                    System.exit(0);
                    con = false;
                    break;
                }

                default: {
                    System.out.println("Invalid option");
                }
            }
        }


    }
}

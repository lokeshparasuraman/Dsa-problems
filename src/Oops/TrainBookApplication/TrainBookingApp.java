package Oops.TrainBookApplication;

import java.util.Scanner;

public class TrainBookingApp {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean con = true;

        while (con) {
            System.out.println("... Train Booking App ...");
            System.out.println("1.Book Tickets\n2.Cancel Ticket\n3.Tickets List\n4.Exit\n5.Available berths");
            System.out.println("Enter Your Option");
            int c = sc.nextInt();
            sc.nextLine();
            switch (c) {
                case 1: {
                    System.out.println("ENTER NAME:");
                    String name = sc.nextLine().toUpperCase();
                    System.out.println("ENTER AGE:");
                    int age = sc.nextInt();
                    sc.nextLine();
                    System.out.println("ENTER GENDER(MALE/FEMALE):");
                    String gender = sc.nextLine().toUpperCase();
                    System.out.println("ENTER BERTH YOU PREFER(L/U/M):");
                    String berth = sc.nextLine().toUpperCase();
                    TicketSystem.bookTicket(name, age, gender, berth);
                    break;
                }
                case 2: {
                    System.out.println("ENTER TICKET ID TO CANCEL");
                    String id = sc.nextLine();
                    TicketSystem.cancelTicket(id);
                    break;
                }
                case 3: {
                    TicketSystem.ticketsList();
                    break;
                }
                case 4: {
                    System.out.println("Thank you come again");
                    System.exit(0);
                    con=false;
                    break;
                }
                case 5:{
                    TicketSystem.availableTickets();
                    break;
                }
                default: {
                    System.out.println("Invalid option");
                }
            }
        }


    }
}



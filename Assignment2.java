import java.util.ArrayList;
import java.util.Scanner;

public class Assignment2 {
    private static final int SEAT_ROWS = 6;
    private static final int SEATS_PER_ROW = 9;
    // private static char[][] theaterSeats = new char[SEAT_ROWS][SEATS_PER_ROW];
    // use arraylist to store the seat info
    private static ArrayList<ArrayList<Character>> theaterSeats = new ArrayList<>();


    public static void main(String[] args) {
        // initialize the seats when the program starts
        initializeSeats();
        Scanner scanner = new Scanner(System.in);

        int menuOption = 0;
        // as long as the user doens't choose quiet, show the menu
        while (menuOption != 4) {
            System.out.println("\nMovie Theater System");
            System.out.println("1. View The Seating Chart");
            System.out.println("2. Reserve a Seat");
            System.out.println("3. Cancel Your Reservation");
            System.out.println("4. Quit");
            System.out.print("What would you like to do? ");

            menuOption = scanner.nextInt();
            scanner.nextLine();

            switch (menuOption) {
                case 1:
                    viewSeats();
                    break;
                case 2:
                    reserveSeat(scanner);
                    break;
                case 3:
                    cancelReservation(scanner);
                    break;
                case 4:
                    // quit the program
                    System.out.println("Bye!!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    // initialize the seats. set all of them to 0 for empty
    private static void initializeSeats() {
        theaterSeats.clear();
        
        for (int i = 0; i < SEAT_ROWS; i++) {
            ArrayList<Character> row = new ArrayList<>();
            for (int j = 0; j < SEATS_PER_ROW; j++) {
                row.add('0');
            }
            theaterSeats.add(row);
        }
    }

    // show the seating chart per user request
    private static void viewSeats() {
        System.out.println("\nMovie Theatre Seating Chart:");
        System.out.print("  ");
        for (int j = 0; j < SEATS_PER_ROW; j++) {
            System.out.print((j + 1) + " ");
        }
        System.out.println();

        for (int i = 0; i < theaterSeats.size(); i++) {
            System.out.print((i + 1) + " ");
            ArrayList<Character> row = theaterSeats.get(i);
            for (Character seat : row) {
                System.out.print(seat + " ");
            }
            System.out.println();
        }
    }

    // allow to reserve a seat
    private static void reserveSeat(Scanner scanner) {
        System.out.print("Enter the row number (1-" + SEAT_ROWS + "): ");
        int row = scanner.nextInt() - 1;
        System.out.print("Enter the seat number (1-" + SEATS_PER_ROW + "): ");
        int seat = scanner.nextInt() - 1;

        if (row < 0 || row >= theaterSeats.size() || seat < 0 || seat >= theaterSeats.get(0).size()) {
            System.out.println("The seat is invalid. Please try again.");
            return;
        }

        if (theaterSeats.get(row).get(seat) == 'X') {
            System.out.println("This seat is already reserved. Please choose a different one");
            // suggest another seat
            boolean found = false;
            for (int i = 0; i < theaterSeats.size(); i++) {
                ArrayList<Character> currentRow = theaterSeats.get(i);
                for (int j = 0; j < currentRow.size(); j++) {
                    if (currentRow.get(j) == '0') {
                        System.out.println("Would you like to try this seat? Row " + (i + 1) + " Seat " + (j + 1));
                        found = true;
                        break;
                    }
                }
                if (found) break;
            }
        } else {
            theaterSeats.get(row).set(seat, 'X');
            System.out.println("Seat reserved succesfully.");
        }
    }

    // cancel the reservation
    private static void cancelReservation(Scanner scanner) {
        System.out.print("Enter the row number (1-" + SEAT_ROWS + "): ");
        int row = scanner.nextInt() - 1;
        System.out.print("Enter the seat number (1-" + SEATS_PER_ROW + "): ");
        int seat = scanner.nextInt() - 1;

        if (row < 0 || row >= theaterSeats.size() || seat < 0 || seat >= theaterSeats.get(0).size()) {
            System.out.println("Invalid seat, Please try again.");
            return;
        }

        if (theaterSeats.get(row).get(seat) == 'X') {
            theaterSeats.get(row).set(seat, '0');
            System.out.println("Your seat reservation was canceled successfully!");
        } else {
            System.out.println("This seat isn't being reserved right now.");
        }
    }
}
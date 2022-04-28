package cinema;

import java.util.Scanner;

public class UserInterface {
    private final Scanner scanner;
    public final Cinema cinema;

    public UserInterface(Cinema cinema) {
        this.scanner = new Scanner(System.in);
        this.cinema = cinema;
    }

    public void start() {
        promptForNumberOfRows();
        promptForSeatsPerRow();
        cinema.setCinemaSeats();
        cinema.calculateTotalPossibleIncome();

        getUserInput();
    }

    public void getUserInput() {
        while (true) {
            System.out.println("\n1. Show the seats\n" +
                    "2. Buy a ticket\n" +
                    "3. Statistics\n" +
                    "0. Exit");
            System.out.print("> ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    cinema.showCinema();
                    break;
                case 2:
                    cinema.sellTicket();
                    break;
                case 3:
                    cinema.showStatistics();
                    break;
                default:
                    return;
            }
        }
    }

    public void promptForNumberOfRows() {
        System.out.println("Enter the number of rows:");
        cinema.setRows(getNumericInput());
    }

    public void promptForSeatsPerRow() {
        System.out.println("Enter the number of seats in each row:");
        cinema.setSeatsPerRow(getNumericInput());
    }

    public void promptForRowNumber() {
        System.out.println("\nEnter a row number:");
        cinema.setRowNumber(getNumericInput());
    }

    public void promptForSeatNumber() {
        System.out.println("Enter a seat number in that row:");
        cinema.setSeatNumber(getNumericInput());
    }

    public int getNumericInput() {
        while (true) {
            try {
                System.out.print("> ");
                String input = scanner.nextLine();
                return Integer.parseInt(input);
            } catch (NumberFormatException numberFormatException) {
                System.out.println("A numeric input is required!");
            }
        }
    }
}

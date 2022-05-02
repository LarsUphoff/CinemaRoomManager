package cinema;

import java.util.Scanner;

public class UserInterface {
    private final Scanner scanner = new Scanner(System.in);
    public final Cinema cinema;

    public UserInterface(Cinema cinema) {
        this.cinema = cinema;
    }

    public void start() {
        promptForNumberOfRows();
        promptForSeatsPerRow();
        cinema.setCinemaSeats();
        cinema.calculateTotalPossibleIncome();
        getUserInput();
    }

    private void promptForNumberOfRows() {
        System.out.println("Enter the number of rows:");
        cinema.setRows(getNumericInput());
    }

    public int getNumericInput() {
        while (true) {
            try {
                System.out.print("> ");
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException numberFormatException) {
                System.out.println("A numeric input is required!");
            }
        }
    }

    private void promptForSeatsPerRow() {
        System.out.println("Enter the number of seats in each row:");
        cinema.setSeatsPerRow(getNumericInput());
    }

    private void getUserInput() {
        while (true) {
            showCinemaOptions();
            int option = getNumericInput();
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

    private void showCinemaOptions() {
        System.out.println("\n1. Show the seats\n" +
                "2. Buy a ticket\n" +
                "3. Statistics\n" +
                "0. Exit");
        System.out.print("> ");
    }

    public void promptForRowNumber() {
        System.out.println("\nEnter a row number:");
        cinema.setRowNumber(getNumericInput());
    }

    public void promptForSeatNumber() {
        System.out.println("Enter a seat number in that row:");
        cinema.setSeatNumber(getNumericInput());
    }
}

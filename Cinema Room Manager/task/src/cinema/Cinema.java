package cinema;

public class Cinema {

    private int rows;
    private int seatsPerRow;
    private int rowNumber;
    private int seatNumber;
    private int numberOfTicketsSold;
    private int currentIncome;
    private int totalIncome;
    private char[][] cinema;
    private final UserInterface ui;

    public Cinema() {
        this.numberOfTicketsSold = 0;
        this.currentIncome = 0;
        ui = new UserInterface(this);
    }

    public void setCinemaSeats() {
        cinema = new char[rows][seatsPerRow];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < seatsPerRow; j++) {
                cinema[i][j] = 'S';
            }
        }
    }

    public void calculateTotalPossibleIncome() {
        if (rows * seatsPerRow <= 60) {
            totalIncome = (rows * seatsPerRow * 10);
        } else {
            totalIncome = (rows / 2) * seatsPerRow * 10 + (rows - rows / 2) * seatsPerRow * 8;
        }
    }

    public void showCinema() {
        System.out.println("\nCinema:");
        System.out.print("  ");
        for (int i = 1; i <= seatsPerRow; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        int i = 1;
        for (char[] row : cinema) {
            System.out.print(i + " ");
            for (char seat : row) {
                System.out.print(seat + " ");
            }
            i++;
            System.out.println();
        }
    }

    public void sellTicket() {
        while (true) {
            ui.promptForRowNumber();
            ui.promptForSeatNumber();
            if (seatNumber > seatsPerRow || rowNumber > rows) {
                System.out.println("\nWrong input!\n");
                continue;
            } else if (getSeatStatus() == 'B') {
                System.out.println("\nThat ticket has already been purchased!\n");
                continue;
            }
            updateCinemaSeats();
            calculateTicketPrice();
            increaseNumberOfTicketsSold();
            break;
        }
    }

    public void updateCinemaSeats() {
        cinema[rowNumber - 1][seatNumber - 1] = 'B';
    }

    public void calculateTicketPrice() {
        if (rows * seatsPerRow <= 60 || rowNumber <= rows / 2) {
            System.out.println("Ticket price: $10");
            increaseCurrentIncome(10);
        } else {
            System.out.println("Ticket price: $8");
            increaseCurrentIncome(8);
        }
    }

    public void increaseCurrentIncome(int amount) {
        currentIncome += amount;
    }

    public void increaseNumberOfTicketsSold() {
        numberOfTicketsSold++;
    }

    public void showStatistics() {
        System.out.println("\nNumber of purchased tickets: " + numberOfTicketsSold);
        System.out.printf("Percentage: %.2f%%%n", percentageOccupied());
        System.out.println("Current income: $" + currentIncome);
        System.out.println("Total income: $" + totalIncome);
    }

    public double percentageOccupied() {
        return (numberOfTicketsSold * 1.0) / (seatsPerRow * rows) * 100;
    }

    public char getSeatStatus() {
        return cinema[rowNumber - 1][seatNumber - 1];
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public void setSeatsPerRow(int seatsPerRow) {
        this.seatsPerRow = seatsPerRow;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }
}
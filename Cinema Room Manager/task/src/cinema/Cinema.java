package cinema;

public class Cinema {

    private int rows;
    private int seatsPerRow;
    private int rowNumber;
    private int seatNumber;
    private int numberOfTicketsSold = 0;
    private int currentIncome = 0;
    private int totalIncome = 0;
    private char[][] cinema;
    private final UserInterface ui;

    public Cinema() {
        ui = new UserInterface(this);
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public void setSeatsPerRow(int seatsPerRow) {
        this.seatsPerRow = seatsPerRow;
    }

    public void setCinemaSeatsToEmpty() {
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
        printNumberOfRows();
        printRowsAndSeats();
    }

    private void printNumberOfRows() {
        System.out.println("\nCinema:");
        System.out.print("  ");
        for (int i = 1; i <= seatsPerRow; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private void printRowsAndSeats() {
        for (int row = 0; row < cinema.length; row++) {
            System.out.print(row + 1 + " ");
            for (char seat : cinema[row]) {
                System.out.print(seat + " ");
            }
            System.out.println();
        }
    }

    public void sellTicket() {
        do {
            ui.promptForRowNumber();
            setRowNumber(ui.getNumericInput());
            ui.promptForSeatNumber();
            setSeatNumber(ui.getNumericInput());
        } while (ui.userSelectionIsInvalid());
        updateCinemaSeat();
        getTicketPrice();
        increaseNumberOfTicketsSold();
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public boolean selectedSeatIsOutOfRange() {
        return seatNumber > seatsPerRow || rowNumber > rows;
    }

    public char getSeatStatus() {
        return cinema[rowNumber - 1][seatNumber - 1];
    }

    public void updateCinemaSeat() {
        cinema[rowNumber - 1][seatNumber - 1] = 'B';
    }

    public void getTicketPrice() {
        if (cinemaHasMoreThan60Seats() || selectedRowIsInLowerHalf()) {
            ui.printHighTicketPrice();
            increaseCurrentIncome(10);
        } else {
            ui.printLowerTicketPrice();
            increaseCurrentIncome(8);
        }
    }

    private boolean cinemaHasMoreThan60Seats() {
        return rows * seatsPerRow <= 60;
    }

    private boolean selectedRowIsInLowerHalf() {
        return rowNumber <= rows / 2;
    }

    public void increaseCurrentIncome(int amount) {
        currentIncome += amount;
    }

    public void increaseNumberOfTicketsSold() {
        numberOfTicketsSold++;
    }

    public int getNumberOfTicketsSold() {
        return numberOfTicketsSold;
    }

    public double percentageOfOccupiedSeats() {
        return (numberOfTicketsSold * 1.0) / (seatsPerRow * rows) * 100;
    }

    public int getCurrentIncome() {
        return currentIncome;
    }

    public int getTotalIncome() {
        return totalIncome;
    }
}
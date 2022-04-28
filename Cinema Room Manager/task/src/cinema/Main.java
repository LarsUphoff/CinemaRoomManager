package cinema;

public class Main {
    public static void main(String[] args) {
        Cinema cinema = new Cinema();
        UserInterface ui = new UserInterface(cinema);
        ui.start();
    }
}

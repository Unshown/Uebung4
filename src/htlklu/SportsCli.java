package htlklu;

import java.util.ArrayList;
import java.util.Scanner;

public class SportsCli {
    public static void main(String[] args) {
        ArrayList<Sports> sportsList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        var cancelation = false;
        while (!cancelation) {
            System.out.print("> ");
            String command = scanner.nextLine();

            if (command.equals("exit")) cancelation = true;
            else if (command.equals("new")) {
                var sport = createSport(scanner);
                if (sport != null)
                    sportsList.add(sport);
            } else if (command.equals("list")) {
                for (Sports sport : sportsList) {
                    System.out.println(sport);
                }
            } else if (command.equals("delete")) {
                var sport = createSport(scanner);
                if (sportsList.remove(sport)) {
                    System.out.println("Deleted sport!");
                } else {
                    System.err.println("Sport not found!");
                }
            } else if (command.equals("record")) {
                System.out.print("> ");
                var record = scanner.nextLine();

                try {
                    var sport = new Sports(record);
                    sportsList.add(sport);
                } catch (IllegalArgumentException e) {
                    System.err.println(e.getMessage());
                }
            } else if (command.equals("print")) {
                System.out.println();
                printCSVList(sportsList);
                System.out.println();
            }
        }
    }

    public static Sports createSport(Scanner scanner) {
        System.out.print("ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("SportType: ");
        String sportType = scanner.nextLine();

        try {
            return new Sports(id, name, sportType);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    public static void printCSVList(ArrayList<Sports> sports) {
        for (var sport : sports) {
            System.out.println(sport.toCSV());
        }
    }
}

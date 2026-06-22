package MovieManagementSystem;

import java.util.Scanner;
import java.util.List;

public class Validation {
    
    public String addMovieValidation(Scanner scanner, List<String> watchList, List<String> watchedMovie) {
        String line = scanner.nextLine();
        if (line.isBlank()) {
            printError();
        } 

        if (watchList.contains(line)) {
            System.out.println("Movie already in queue");
        }

        if (watchedMovie.contains(line)) {
            System.out.println("The movie is already watched");
        } 

        if (line.equals("return")) {
        }

        return line;
    }

    public void printError() {
        System.out.println("""
        Invalid input:Please use a valid command
        Make sure you've type the correct to command to proceed
        """);
    }

}

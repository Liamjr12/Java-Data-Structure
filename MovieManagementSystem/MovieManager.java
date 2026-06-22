package MovieManagementSystem;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class MovieManager {

    List<String> watchList = new ArrayList<>();
    List<String> history = new LinkedList<>();

    public void addMovie(Scanner scanner) {
        System.out.print("\nAdd movie >> ");
        String line = scanner.nextLine().trim().toLowerCase();
        
        if (line.isBlank()) {
            printError();
            return;
        } 

        if (watchList.contains(line)) {
            System.out.println("Movie already in queue");
            return;
        }

        if (history.contains(line)) {
            System.out.println("The movie is already watched");
            return;
        } 

        if (line.equalsIgnoreCase("return")) {
            return;
        }

        watchList.add(line);
        System.out.println("A movie \'" + line + "\' has been added");

    }

    public void displayMovieWatchlist() {
        Iterator<String> it = watchList.iterator();
        int i = 1;

        if(watchList.isEmpty()){
            System.out.println("\nNo movies found.");
            return;
        }

        System.out.println("\n======= WATCHLIST SUMMARY =======");
        while (it.hasNext()) {
            System.out.println((i++) + ". " + it.next());
        }

    }

    public void markAsWatched(Scanner scanner) {
        System.out.print("\nWatch >> ");
        String line = scanner.nextLine().trim().toLowerCase();

        if (history.contains(line)) {
            System.out.println("The movie \'" + line + "\' is already watched");
            return;
        }

        if (!watchList.contains(line)) {
            System.out.println("This movie is not on the list");
            return;
        }

        if (line.equalsIgnoreCase("return")) {
            return;
        }

        if (watchList.contains(line)) {
            watchList.remove(line);
            history.add(line);
            System.out.println("The movie \"" + line + "\" has been marked as watched");
            return;
        } 

    }

    public void displayHistory() {
        Iterator<String> it = history.iterator();

        if(history.isEmpty()){
            System.out.println("No watched movies found.");
            return;
        }
        
        int i = 1;
        System.out.println("\n======= WATCHED MOVIES SUMMARY  =======");
        while (it.hasNext()) {
            System.out.println((i++) + ". " + it.next());
        }

    }

    public void findMovie(Scanner scanner) {
        System.out.print("\nSearch >> ");
        String line = scanner.nextLine().trim().toLowerCase();

        if (line.equalsIgnoreCase("return")) {
            return;
        }

        if (watchList.contains(line)) {
            System.out.println("The movie " + line + " is currently available");
        } else if (history.contains(line)) {
            System.out.println("The movie " + line + " has been marked as watched");
        }else {
            System.out.println("This movie is not on the list");
        }
        
    }

    public void printError() {
        System.out.println("""
        Invalid input: Please use a valid command
        Make sure you've type the correct to command to proceed
        """);
    }

}

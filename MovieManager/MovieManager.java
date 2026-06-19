import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class MovieManager {

    List<String> movieQueue = new ArrayList<>();
    List<String> watchedMovie = new LinkedList<>();

    public void addMovie(Scanner scanner) {
        System.out.print("Add movie >> ");
        String line = scanner.nextLine().toLowerCase();
        
        if (line.isBlank()) {
            pirntError();
            return;
        } 

        if (movieQueue.contains(line)) {
            System.out.println("Movie already in queue");
            pirntError();
            return;
        }

        movieQueue.add(line);
        System.out.println("A movie \"" + line + "\" has been added");
    }

    public void displayMovieWatchlist() {
        System.out.println("======= WATCHLIST SUMMARY =======");
        Iterator<String> it = movieQueue.iterator();
        int i = 1;

        if(movieQueue.isEmpty()){
            System.out.println("No movies found.");
            return;
        }

        while (it.hasNext()) {
            System.out.println((i++) + ". " + it.next());
        }
    }

    public void markAsWatched(Scanner scanner) {
        System.out.print("Watch >> ");
        String line = scanner.nextLine().toLowerCase();

        if (movieQueue.contains(line)) {
            movieQueue.remove(line);
            watchedMovie.add(line);
            System.out.println("The movie " + line + " is currently watching");
        } else {
            pirntError();
        }

    }

    public void displayHistory() {
        System.out.println("======= WATCHED MOVIES SUMMARY  =======");
        Iterator<String> it = watchedMovie.iterator();

        if(watchedMovie.isEmpty()){
            System.out.println("No watched movies found.");
            return;
        }
        
        int i = 1;
        while (it.hasNext()) {
            System.out.println((i++) + ". " + it.next());
        }
    }

    public void findMovie(Scanner scanner) {
        System.out.print("Search >> ");
        String line = scanner.nextLine().toLowerCase();

        if (movieQueue.contains(line)) {
            System.out.println("The movie " + line + " is currently available");
        } else if (watchedMovie.contains(line)) {
            System.out.println("The movie " + line + " is already watching/watched");
        }else {
           pirntError();
        }

    }

    public void pirntError() {
        System.out.println("""
        Invalid input: Please you a valid command to proceed
        Make sure you've type the correct to command to proceed
        """);
    }

}

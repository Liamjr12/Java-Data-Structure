package MovieManagementSystem;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class MovieManager {

    protected List<String> watchList = new ArrayList<>();
    protected List<String> history = new ArrayList<>();
    protected Validation validator;

    public MovieManager(Validation validator) {
        this.validator = new Validation(this);
    }

    public void addMovie(Scanner scanner) {

        System.out.print("\nAdd movie >> ");
        String line = getInput(scanner);

        if (!validator.addMovieValidation(line)) {
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
        String line = getInput(scanner);
        String movie = getMovie(line);

        if (!validator.markMovieValidation(line, movie)) {
            return;
        }

        watchList.remove(movie);
        history.add(movie);
        System.out.println("The movie \'" + line + "\' has been marked as watched");

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
        String line = getInput(scanner);

        validator.findMovieValidation(line);
        
    }

    private String getInput(Scanner scanner) {
        return scanner.nextLine().trim();
    }

    private String getMovie(String title) {

        for (String list : watchList) {
            if (list.equalsIgnoreCase(title)) {
                return list;
            }
        }

        return null;

    }

}

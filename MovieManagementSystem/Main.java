package MovieManagementSystem;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        MovieManager movies = new MovieManager();

        while (true) {
            try  {
                System.out.println("""
                \n======= MOVIE WATCH LIST =======
                1. Add movie
                2. View watchlist
                3. Watch movie
                4. View watched movies
                5. Search movie
                6. Exit        
                \n""");
                System.out.print("Choice >> ");
                int choice = scanner.nextInt();
                scanner.nextLine();
                
                switch(choice) {
                    case 1:
                        movies.addMovie(scanner);
                        break;
                    case 2:
                        movies.displayMovieWatchlist();
                        break;
                    case 3:
                        movies.markAsWatched(scanner);
                        break;
                    case 4:
                        movies.displayHistory();
                        break;
                    case 5:
                        movies.findMovie(scanner);
                        break;
                    case 6:
                        scanner.close();
                        return;
                    default:
                        movies.validator.printError();
                        break;
                }

            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number");
                scanner.nextLine();
            }

        }
        
    }
}

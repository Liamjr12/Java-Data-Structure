import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        MovieManager movies = new MovieManager();

        while (true) {
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
            String line = scanner.nextLine().toLowerCase();
            
            switch(line) {
                case "add -m":
                    movies.addMovie(scanner);
                    break;
                case "view -m":
                    movies.displayHistory();
                    break;
                case "watch -m":
                    movies.markAsWatched(scanner);
                    break;
                case "view -wm":
                    movies.displayHistory();
                    break;
                case "search -m":
                    movies.findMovie(scanner);
                    break;
                case "exit":
                    scanner.close();
                    return;
                default:
                    movies.pirntError();
                    break;
            }
        }
    }
}

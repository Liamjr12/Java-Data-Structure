package MovieManagementSystem;

public class Validation {

    private static final String BACK_COMMAND = "return";
    private MovieManager movieManager;

    public Validation (MovieManager movieManager) {
        this.movieManager = movieManager;
    }
    
    public boolean addMovieValidation(String line) {

        isBack(line);
        
        if (line.isBlank()) {
            movieManager.printError();
            return false;
        } 

        if (movieExists(line)) {
            System.out.println("Movie already in queue");
            return false;
        }

        if (isWatched(line)) {
            System.out.println("The movie is already watched");
            return false;
        } 

        return true;

    }

    public boolean markMovieValidation (String line, String movie) {

        isBack(line);

        if (isWatched(line)) {
            System.out.println("The movie \'" + line + "\' is already watched");
            return false;
        }

        if (movie == null) {
            System.out.println("This movie is not on the list");
            return false;
        }

        return true;

    }

    public boolean findMovieValidation(String line) {

        isBack(line);

        if (movieExists(line)) {
            System.out.println("The movie has been found");
            System.out.println("The movie \'" + line + "\' is currently available");
            return true;
        } else if (isWatched(line)) {
            System.out.println("The movie has been found");
            System.out.println("The movie \'" + line + "\' has been marked as watched");
            return true;
        } else {
            System.out.println("This movie is not on the list");
            return false;
        }

    }

    private boolean movieExists(String title) {

        for (String list : movieManager.watchList) {
            if (list.equalsIgnoreCase(title)) {
                return true;
            }
        }

        return false;

    }

    private boolean isWatched(String title) {

        for (String list : movieManager.history) {
            if (list.equalsIgnoreCase(title)) {
                return true;
            }
        }

        return false;

    }

    private boolean isBack(String line) {
        if (line.equalsIgnoreCase(BACK_COMMAND)) {
            return false;
        }
        return true;
    }

}

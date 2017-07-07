import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by jenny on 7/7/2017.
 */

//Application that stores a list of 10 movies and displays them by category
public class MovieCategories {

    //Validate user inputs:
    private static Validator Validator = new Validator();

    public static void main(String[] args) {

        ArrayList<Movie> movies = new ArrayList<>();
        ArrayList<Movie> categorized = new ArrayList<>();
        Scanner entry = new Scanner(System.in);

        System.out.print("Welcome to the Movie List Application!\n\n");

        System.out.println("There are 100 movies in this list.");

        String keepGoing = "y";
        String categorySelection = null;
        String titleSearch = null;
        String categoryPrompt = null;
        String titlePrompt = null;
        String continuePrompt = null;

        for (int i = 0; i < 100; i++) {
            movies.add(MovieIO.getMovie(i + 1));
        }

        while(keepGoing.equalsIgnoreCase("y")) {

            categoryPrompt = "What category are you interested in? (animated, drama, horror, or scifi): ";
            categorySelection = Validator.getString(entry, categoryPrompt);

            for (Movie movie : movies) {
                if (movie.getCategory().equalsIgnoreCase(categorySelection)) {
                    System.out.println(movie.getTitle());
                    categorized.add(movie);
                }
            }

            //FIXME PICK BY NUMBER INSTEAD OF CATEGORY NAME
            //FIXME ALPHABETICAL ORDER

            titlePrompt = "\nEnter a search word to narrow down to a title you are looking for: ";
            titleSearch = Validator.getString(entry, titlePrompt);

            for (Movie movie: categorized) {
                if (containsIgnoreCase(movie.getTitle(), titleSearch)) {
                    System.out.println(movie.getTitle());
                }
            }

            continuePrompt = "\nContinue? (y/n): ";
            keepGoing = Validator.getString(entry, continuePrompt);
        }
        System.out.println("\nGood-bye");
    }

    public static boolean containsIgnoreCase(String str, String searchStr)     {
        if(str == null || searchStr == null) return false;

        final int length = searchStr.length();
        if (length == 0)
            return true;

        for (int i = str.length() - length; i >= 0; i--) {
            if (str.regionMatches(true, i, searchStr, 0, length))
                return true;
        }
        return false;
    }
}

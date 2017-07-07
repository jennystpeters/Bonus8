import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by jenny on 7/7/2017.
 */

//Application that stores a list of 10 movies and displays them by category
public class MovieCategories {

    public static void main(String[] args) {

        ArrayList<Movie> movies = new ArrayList<>();
        Scanner entry = new Scanner(System.in);

        System.out.print("Welcome to the Movie List Application!\n\n");

        System.out.println("There are 100 movies in this list.");

        String keepGoing = "y";
        String categorySelection = null;
        String titleSearch = null;

        for (int i = 0; i < 100; i++) {
            movies.add(MovieIO.getMovie(i + 1));
        }

        while(keepGoing.equalsIgnoreCase("y")) {

            System.out.print("What category are you interested in? (animated, drama, horror, or scifi): ");
            categorySelection = entry.nextLine();

            for (Movie movie : movies) {
                if (movie.getCategory().equalsIgnoreCase(categorySelection)) {
                    System.out.println(movie.getTitle());
                }
            }

            System.out.print("\nEnter a word to search for in titles: ");
            titleSearch = entry.nextLine();

            for (Movie movie : movies) {
                if (containsIgnoreCase(movie.getTitle(), titleSearch)) {
                    System.out.println(movie.getTitle());
                }
            }

            System.out.print("\nContinue? (y/n): ");
            keepGoing = entry.nextLine();
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

import java.util.ArrayList;
import java.util.Collections;
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
        String categorySelection;
        String titleSearch;
        String titlePrompt = null;
        String continuePrompt = null;

        //Fill ArrayList movies:
        for (int i = 0; i < 100; i++) {
            movies.add(MovieIO.getMovie(i + 1));
        }

        //Continue as long as user enters "y" or "Y"
        while (keepGoing.equalsIgnoreCase("y")) {

            //Get category selection from user:
            categorySelection = getSelection(entry);

            //Fill ArrayList categorized with applicable movies:
            for (Movie movie : movies) {
                if (movie.getCategory().equalsIgnoreCase(categorySelection)) {
                    categorized.add(movie);
                }
            }

            //Sort ArrayList categorized in alphabetical order by title and print list to console:
            Collections.sort(categorized);
            for (Movie sortedMovie : categorized) {
                System.out.println(sortedMovie.getTitle());
            }

            titlePrompt = "\nEnter a search word to narrow down to a title you are looking for: ";

            //Find titles containing the entered search word and print list to console:
            titleSearch = Validator.getString(entry, titlePrompt);
            for (Movie movie : categorized) {
                if (containsIgnoreCase(movie.getTitle(), titleSearch)) {
                    System.out.println(movie.getTitle());
                }
            }

            continuePrompt = "\nContinue? (y/n): ";
            keepGoing = Validator.getString(entry, continuePrompt);

            categorized.clear();
        }
        System.out.println("\nGood-bye");
    }

    //Get movie category selection from user
    private static String getSelection(Scanner entry) {

        String categoryPrompt;
        String invalidCategoryPrompt;
        String categorySelection = null;
        int categoryNumber;

        categoryPrompt = "Please enter the number for the category you are interested in ... 1. animated 2. drama 3. horror 4. scifi: ";
        invalidCategoryPrompt = "Invalid entry. ";
        categoryNumber = Validator.getInt(entry, categoryPrompt, invalidCategoryPrompt, 1, 4);

        switch (categoryNumber) {
            case 1:
                categorySelection = "animated";
                break;
            case 2:
                categorySelection = "drama";
                break;
            case 3:
                categorySelection = "horror";
                break;
            case 4:
                categorySelection = "scifi";
                break;
            default:
                break;
        }
        return categorySelection;
    }

    public static boolean containsIgnoreCase(String str, String searchStr) {
        if (str == null || searchStr == null) return false;

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

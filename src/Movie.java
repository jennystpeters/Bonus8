/**
 * Created by jenny on 7/7/2017.
 */
public class Movie implements Comparable<Movie> {

    private String title;
    private String category;

    //Provide a constructor that accepts a title and category as parameters and initialize fields
    public Movie(String title, String category) {
        this.title = title;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    //Override to output ArrayList titles and categories rather than reference locations:
    @Override
    public String toString() {

        return String.format("%s %-45s %s %-45s", "Title: ", title, "Category: ", category);
    }

    //Override to allow sorting of an ArrayList containing elements of a user-defined class type:
    @Override
    public int compareTo(Movie otherMovie) {
        String title = ""; // title, this movie

        return this.getTitle().compareTo(otherMovie.getTitle());

    }
}

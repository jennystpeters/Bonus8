/**
 * Created by jenny on 7/7/2017.
 */
public class Movie {

    private String title;
    private String category;

    //Provide a constructor that accepts a title and category as parameters and use the values passed to it to initialize its fields
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

    //Annotation to tell Java this override will take the place instead of the Java library toString
    @Override
    public String toString() {

        return String.format("%s %-45s %s %-45s", "Title: ", title, "Category: ", category);
    }



}

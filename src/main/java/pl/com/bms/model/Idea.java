package pl.com.bms.model;

/**
 * Created by mateusz on 27.06.15.
 */
public class Idea {
    private String id;
    private String author;
    private String title;
    private String description;
    private boolean approved;

    public Idea(String id, String author, String title, String description) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.description = description;
        this.approved = false;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

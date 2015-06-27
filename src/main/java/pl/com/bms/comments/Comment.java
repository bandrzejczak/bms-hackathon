package pl.com.bms.comments;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by lk on 27.06.15.
 */
public class Comment {
    Author author;
    LocalDateTime datePosted;
    String message;

    public Comment(Author author, LocalDateTime datePosted, String message) {
        this.author = author;
        this.datePosted = datePosted;
        this.message = message;
    }

    public String getDatePosted() {
        return datePosted.format(DateTimeFormatter.ofPattern("YYYY-MM-dd, HH:mm"));
    }
}

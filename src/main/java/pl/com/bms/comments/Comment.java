package pl.com.bms.comments;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by lk on 27.06.15.
 */
public class Comment {
    LocalDateTime datePosted;
    String message;

    public Comment() {
        this.datePosted = LocalDateTime.now();
    }

    public Comment(String message) {
        this();
        this.message = message;
    }

    public String getDatePosted() {
        return datePosted.format(DateTimeFormatter.ofPattern("YYYY-MM-dd, HH:mm"));
    }

    public void setDatePosted(LocalDateTime datePosted) {
        this.datePosted = datePosted;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

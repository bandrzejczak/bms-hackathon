package pl.com.bms.comments;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by lk on 27.06.15.
 */
public class Comment {

    public void setDatePosted(LocalDateTime datePosted) {
        this.datePosted = datePosted;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    LocalDateTime datePosted;
    String message;

    Comment() {
    }

    public Comment(String message) {
        this.datePosted = LocalDateTime.now();
        this.message = message;
    }

    public String getDatePosted() {
        if(datePosted == null) {
            datePosted = LocalDateTime.now();
        }
        return datePosted.format(DateTimeFormatter.ofPattern("YYYY-MM-dd, HH:mm"));
    }
}

package pl.com.bms.comments;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
public class Comment {
    @Id
    @GeneratedValue
    private String id;
    private String ideaID;
    private LocalDateTime datePosted;
    private String message;

    public Comment(String id, String ideaID, LocalDateTime datePosted, String message) {
        this.id = id;
        this.ideaID = ideaID;
        this.datePosted = datePosted;
        this.message = message;
    }

    public Comment(String message) {
        this.message = message;
    }

    public Comment() {}

    public String getDatePosted() {
        return datePosted.format(DateTimeFormatter.ofPattern("YYYY-MM-dd, HH:mm"));
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdeaID() {
        return ideaID;
    }

    public void setIdeaID(String ideaID) {
        this.ideaID = ideaID;
    }

    public void setDatePosted(LocalDateTime datePosted) {
        this.datePosted = datePosted;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}

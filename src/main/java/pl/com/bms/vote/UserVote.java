package pl.com.bms.vote;

/**
 * Created by marcin.konarski on 2015-06-27.
 */
public class UserVote {

    private String userName;
    private Vote vote;

    public UserVote(String userName, Vote vote) {
        this.userName = userName;
        this.vote = vote;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Vote getVote() {
        return vote;
    }

    public void setVote(Vote vote) {
        this.vote = vote;
    }
}

package pl.com.bms.vote;

import java.util.*;

/**
 * Created by marcin.konarski on 2015-06-27.
 */
public class VotesRepository {

    private Map<Idea, HashSet<UserVote>> votes;

    public VotesRepository() {
        votes = new HashMap<>();
    }

    public double getAverageVoteForIdea(Idea idea) {
        double sum = 0;
        for (UserVote userVote : votes.get(idea)) {
            sum += userVote.getVote().getValue();
        }
        return sum/votes.get(idea).size();
    }

    public Optional<Vote> getUserVoteForIdea(Idea idea, String userName) {
        HashSet<UserVote> usersVote = votes.get(idea);
        Vote vote = null;
        for (UserVote userVote : usersVote) {
            if(userVote.getUserName().equals(userName)){
                vote = userVote.getVote();

            }
        }
        return Optional.of(vote);
    }
}

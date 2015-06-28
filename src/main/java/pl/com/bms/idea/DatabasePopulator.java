package pl.com.bms.idea;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import pl.com.bms.idea.Idea;
import pl.com.bms.idea.IdeaRepository;

import java.util.stream.IntStream;

@Component
public class DatabasePopulator implements ApplicationListener<ContextRefreshedEvent> {

    private IdeaRepository repo;
    private boolean populated = false;

    @Autowired
    public DatabasePopulator(IdeaRepository repo) {
        this.repo = repo;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if(!populated) {
            IntStream.range(0, 3).forEach(
                  i -> repo.save(
                        new Idea("Zenon",
                              "Hackathon nr " + i,
                              "description " + i))
            );
            populated = true;
        }
    }
}

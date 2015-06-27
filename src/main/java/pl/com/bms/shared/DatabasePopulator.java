package pl.com.bms.shared;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.stereotype.Component;

import java.util.UUID;
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
            IntStream.range(0, 10).forEach(
                  i -> repo.save(
                        new Idea("author_test",
                              "test_" + i,
                              "description_" + i))
            );
            populated = true;
        }
    }
}

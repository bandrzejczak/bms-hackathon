package pl.com.bms.idea;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.com.bms.idea.Idea;

@Repository
public interface IdeaRepository extends CrudRepository<Idea, String>{

}

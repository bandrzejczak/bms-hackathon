package pl.com.bms.chooseIdeas;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;

import org.springframework.stereotype.Repository;
import pl.com.bms.model.Idea;


@Repository
class ChooseIdeaRepository {
   
	public List<Idea> getIdeaList(){
		List<Idea> ideaList = new ArrayList<>();
		IntStream.range(0, 10).forEach(
			i -> ideaList.add(
				  new Idea(UUID.randomUUID().toString(),
						"author_test",
						"test_" + i,
						"description_" + i))
		);
		return ideaList;
	}
	
}

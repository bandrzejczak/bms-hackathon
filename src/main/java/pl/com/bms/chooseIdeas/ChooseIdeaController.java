package pl.com.bms.chooseIdeas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.com.bms.shared.Idea;
import pl.com.bms.shared.IdeaRepository;

import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;


@Controller
class ChooseIdeaController {

   @Autowired private IdeaRepository ideaRepository;
	
   @RequestMapping(value="/chooseIdea", method= GET)
   public String chooseIdea(Map<String, Object> model) {
	   model.put("ideaList", ideaRepository.findAll());
	   return "chooseIdeas";
   }
   
   
   @RequestMapping(value = "/chooseIdea/{ideaId}", method = GET)
   public String chooseTheBestIdea(@PathVariable String ideaId) {
	   Idea idea = ideaRepository.findOne(ideaId);
	   idea.approve();
	   ideaRepository.save(idea);
	   return "redirect:";
   }
   
}

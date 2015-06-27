package pl.com.bms.chooseIdeas;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.com.bms.shared.Idea;
import pl.com.bms.shared.IdeaRepository;


@Controller
@RequestMapping("/chooseIdea")
class ChooseIdeaController {

   @Autowired private IdeaRepository chooseIdeaRepo;
	
   @RequestMapping("/")
   public String chooseIdea(Map<String, Object> model) {
	   model.put("ideaList", chooseIdeaRepo.findAll());
	   return "chooseIdeas";
   }
   
   
   @RequestMapping(method = RequestMethod.GET, value = "/{id}")
   public String chooseTheBestIdea(@PathVariable String id) {
	   Idea idea = chooseIdeaRepo.findOne(id);
	   idea.setApproved(true);
	   chooseIdeaRepo.save(idea);
	   return "redirect:";
   }
   
}

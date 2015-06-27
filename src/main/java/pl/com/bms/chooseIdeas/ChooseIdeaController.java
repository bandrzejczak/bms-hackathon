package pl.com.bms.chooseIdeas;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/chooseIdea")
class ChooseIdeaController {

   @Autowired private ChooseIdeaRepository chooseIdeaRepo; 
	
   @RequestMapping("/")
   public String chooseIdea(Map<String, Object> model) {
	   model.put("ideaList", chooseIdeaRepo.getIdeaList());
	   return "chooseIdeas";
   }
   
   
   @RequestMapping(method = RequestMethod.GET, value = "/{id}")
   public void chooseTheBestIdea(@PathVariable Long id) {
	   System.out.println("ID: " + id);
   }
   
}

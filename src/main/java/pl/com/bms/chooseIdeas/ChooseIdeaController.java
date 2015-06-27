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
	
   @RequestMapping(value="/approvals", method= GET)
   public String approvalsPage(Map<String, Object> model) {
	   model.put("ideaList", ideaRepository.findAll());
	   return "ideasApprovalPage";
   }
   
   
   @RequestMapping(value = "/idea/{ideaId}/approve", method = GET)
   public String approveIdea(@PathVariable String ideaId) {
	   Idea idea = ideaRepository.findOne(ideaId);
	   idea.approve();
	   ideaRepository.save(idea);
	   return "redirect:/approvals";
   }
   
}

package pl.com.bms.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.com.bms.idea.IdeaService;

import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;


@Controller
class IdeaApprovalController {

    private final IdeaService ideas;

    @Autowired
    public IdeaApprovalController(IdeaService ideas) {
        this.ideas = ideas;
    }

    @RequestMapping(value = "/approvals", method = GET)
    public String approvalsPage(Map<String, Object> model) {
        model.put("ideaList", ideas.getAll());
        return "ideasApprovalPage";
    }

    @RequestMapping(value = "/idea/{ideaId}/approve", method = GET)
    public String approveIdea(@PathVariable String ideaId) {
        ideas.approveIdea(ideaId);
        return Redirection.toApprovals().asString();
    }
}

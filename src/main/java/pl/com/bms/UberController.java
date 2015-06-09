package pl.com.bms;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
class UberController {

   @RequestMapping("/")
   public String index() {
      return "index";
   }
}

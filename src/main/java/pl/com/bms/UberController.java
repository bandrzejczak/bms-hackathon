package pl.com.bms;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
class UberController {

   @RequestMapping("/")
   public String index(Map<String, String> model) {
      model.put("message", "hej BMS!!!");
      return "index";
   }
}

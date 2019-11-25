package wwl.lsf.hellspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

  @RequestMapping("/hello")
  @ResponseBody
  public String hello() {
    return "h中国拉 得我  我再改";
  }

}

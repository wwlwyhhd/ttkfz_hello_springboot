package wwl.lsf.hellospringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController12 {

  @RequestMapping("/helloq23/{b}")
  @ResponseBody
  public String hello(@PathVariable Integer b) {
    System.out.println(b);
    int a = 0 / 0;
    return "h中国拉 得我  我再改" + b;
  }

}

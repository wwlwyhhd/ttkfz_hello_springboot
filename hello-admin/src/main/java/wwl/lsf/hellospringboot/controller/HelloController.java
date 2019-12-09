package wwl.lsf.hellospringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import wwl.lsf.hellospringboot.service.helloService;

@Controller
public class HelloController {

  @Autowired
  private helloService hell;

  @RequestMapping("/hello/{b}")
  @ResponseBody
  public String hello(@PathVariable Integer b) {
    System.out.println(b);
    hell.add();
    int a = 0 / 0;
    return "h中国拉 得我  我再改" + b;
  }

}

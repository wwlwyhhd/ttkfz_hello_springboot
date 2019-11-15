package wwl.lsf.hellspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

  @RequestMapping("/hello")
  @ResponseBody
  public String hello() {

    int i = 0;
    return "hello  ttkfz ceshi rollout 生成新的拉 new 我再改";
  }

}

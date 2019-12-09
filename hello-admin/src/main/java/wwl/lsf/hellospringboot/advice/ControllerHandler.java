package wwl.lsf.hellospringboot.advice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ControllerHandler {

  @ExceptionHandler(Exception.class)
  @ResponseBody
  public String internalServerError(Exception ex) {

    if (ex instanceof Exception) {
      ex.printStackTrace();
      System.out.println(ex);
    }
    return "adfa";
  }

}

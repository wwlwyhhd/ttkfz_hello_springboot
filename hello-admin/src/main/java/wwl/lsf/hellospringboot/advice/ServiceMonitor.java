package wwl.lsf.hellospringboot.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author fanfever
 * @email fanfeveryahoo@gmail.com
 * @url https://github.com/fanfever
 * @date 2016年7月19日
 */
@Aspect
@Component
public class ServiceMonitor {


/*  @Before("execution(* wwl.lsf.hellospringboot.controller..*.*(..))")
  public void countServiceInvoke(JoinPoint joinPoint) {
//    counterService.increment(joinPoint.getSignature() + "");
  }*/

  @Around("execution(* wwl.lsf.hellospringboot.controller..*.*(..))")
  public Object latencyService(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
    long start = System.currentTimeMillis();
    Object retVal = proceedingJoinPoint.proceed();
    long diff = System.currentTimeMillis() - start;
//    gaugeService.submit(proceedingJoinPoint.getSignature().toString(), diff);
    return retVal;
  }
}

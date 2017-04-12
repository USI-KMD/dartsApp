package zzjp.springboot.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TracingAspect {

    private Logger logger = LoggerFactory.getLogger(getClass());

//    @Before("zzjp.springboot.aspect.DartappPointcuts.anyControllerMethod()")
    @Before("zzjp.springboot.aspect.DartappPointcuts.anyControllerBean()")
    public void trace(JoinPoint joinPoint) {

        System.out.println("called method: " + joinPoint.getSignature());

        System.out.println();
    }

}


package zzjp.springboot.aspect;

import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by lukasz on 4/12/17.
 */
public class DartappPointcuts {

    @Pointcut("execution(* *..controller..*(..))")
    public void anyControllerMethod() {}

    @Pointcut("bean(*Controller)")
    public void anyControllerBean() {}

    @Pointcut("@annotation(Monitored)")
    public void monitored() {}

}

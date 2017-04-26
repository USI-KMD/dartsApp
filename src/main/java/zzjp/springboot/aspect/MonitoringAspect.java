package zzjp.springboot.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import zzjp.springboot.model.Player;

import javax.persistence.Column;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by lukasz on 4/12/17.
 */
@Aspect
@Component
public class MonitoringAspect {


    @Value("${isMonitoringEnabled:false}")
    private boolean isEnabled;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Around("zzjp.springboot.aspect.DartappPointcuts.monitored()")
    public Object monitor(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        if (!isEnabled) {
            return proceedingJoinPoint.proceed();
        }

        logger.debug("monitoring: " + proceedingJoinPoint.getSignature());

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Object result = proceedingJoinPoint.proceed();
        stopWatch.stop();
        System.out.println("methid took: " + stopWatch.getTotalTimeMillis());

        return result;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }
}

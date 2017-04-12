package zzjp.springboot.aspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * Created by lukasz on 4/12/17.
 */
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface Monitored {
}

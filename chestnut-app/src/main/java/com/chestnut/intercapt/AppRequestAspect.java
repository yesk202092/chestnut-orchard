
package com.chestnut.intercapt;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author yesk
 */
@Component
@Aspect
public class AppRequestAspect {
    //拦截除了后端以外的接口
    @Pointcut("execution(* com.chestnut.*Controller.*(..))")
    public void getMethod() {
    }
}

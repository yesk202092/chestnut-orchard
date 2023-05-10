package com.chestnut.framework.aspectj;


import com.chestnut.common.annotation.ApiLog;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * 自定义请求、响应日志记录处理
 *
 * @Author zhang kun
 * @Date 2022/8/9 14:45
 * @Version 1.0
 */
@Aspect
@Component
@Slf4j
public class ApiLogAspect {


    @Pointcut("@annotation(com.chestnut.common.annotation.ApiLog)")
    private void apiLog() {
    }

    /**
     * 在切点之前打印
     */
    @Before("apiLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        // 开始打印请求日志
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = null;
        if (attributes != null) {
            request = attributes.getRequest();
        }
        // 获取 @apiLog 注解的描述信息
        String methodDescription = getAspectLogDescription(joinPoint);
        // 打印请求相关参数
        log.info("【方法名】:{},url:{},【请求参数】:{}"
                // 方法描述信息
                , methodDescription
                // 请求url
                , request.getRequestURL().toString()
                // 请求参数
                , new Gson().toJson(joinPoint.getArgs()));
    }

    /**
     * 环绕
     *
     * @param proceedingJoinPoint
     * @return Object
     * @throws Throwable
     */
    @Around("apiLog()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        // 开始打印请求日志
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = null;
        if (attributes != null) {
            request = attributes.getRequest();
        }
        // 获取 @apiLog 注解的描述信息
        String methodDescription = getAspectLogDescription(proceedingJoinPoint);
        // 响应信息
        Object result = proceedingJoinPoint.proceed();

        log.info("【方法名】:{},url:{},【请求参数】:{},【响应参数】:{},【耗时】:{} ms"
                // 方法描述信息
                , methodDescription
                // 请求url
                , request.getRequestURL().toString()
                // 请求参数
                , new Gson().toJson(proceedingJoinPoint.getArgs())
                // 响应参数
                , new Gson().toJson(result)
                // 耗时
                , System.currentTimeMillis() - startTime);
        return result;
    }

    /**
     * 获取切面注解的描述
     *
     * @param joinPoint 切点
     * @return 描述信息
     * @throws Exception
     */
    public String getAspectLogDescription(JoinPoint joinPoint)
            throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        StringBuilder description = new StringBuilder();
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazz = method.getParameterTypes();
                if (clazz.length == arguments.length) {
                    description.append(method.getAnnotation(ApiLog.class).name());
                    break;
                }
            }
        }
        return description.toString();
    }

}

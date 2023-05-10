package com.chestnut.framework.aspectj;


import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.chestnut.framework.cache.RedisOperator;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 防重复点击
 *
 * @Author zhang kun
 * @Date 2022/8/9 14:45
 * @Version 1.0
 */
@Aspect
@Component
@Slf4j
public class RepeatedClicksAspect {
    @Autowired
    RedisOperator redis;

    @Pointcut("@annotation(com.chestnut.common.annotation.ApiClickLock)")
    private void apiClick() {
    }

    /**
     * 环绕
     *
     * @param proceedingJoinPoint
     * @return Object
     * @throws Throwable
     */
    @Around("apiClick()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        // 根据 用户唯一编码防重复点击
        String methodName = proceedingJoinPoint.getSignature().getName();
        // 响应信息
        String jsonString = JSON.toJSONString(proceedingJoinPoint.getArgs());
        JSONObject jsonObject = JSON.parseArray(jsonString).getJSONObject(0);
        String requestId = jsonObject.getString("requestId");
        //同一个接口一秒内仅仅允许请求一次
        Boolean lockState = redis.lock(methodName + requestId,1);
        if (!lockState) {
            throw new RuntimeException("请勿重复点击");
        }
        Object result = proceedingJoinPoint.proceed();
        return result;
    }


}

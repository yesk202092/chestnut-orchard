package com.chestnut.common.annotation;

import java.lang.annotation.*;

/**
 * 自定义请求、响应日志记录注解
 *
 * @Author zhangkun
 * @Date 2022/8/9 14:38
 * @Version 1.0
 */
@Target({ ElementType.PARAMETER, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ApiLog {

    /**
     * 所属模块方法名
     */
    String name() default "";
}

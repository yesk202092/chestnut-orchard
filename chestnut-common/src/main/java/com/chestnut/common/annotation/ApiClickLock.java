package com.chestnut.common.annotation;

import java.lang.annotation.*;

/**
 * 自定义请求、防重复提交
 *
 * @author yesk
 * @Version 1.0
 */
@Target({ ElementType.PARAMETER, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ApiClickLock {

}

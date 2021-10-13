package com.test.aop;

import java.lang.annotation.*;

/**
 * @author lu.feng
 * 自定义参数校验注解
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface NeedCheck {

}

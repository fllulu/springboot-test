package com.test.aop;

import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

/**
 * @author lu.feng
 * 参数校验切面
 */
@Component
@Order(-9899)
@Aspect
public class InputCheckAspect {
    private static final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

    @Before("@annotation(nc)")
    public void doInputCheckBefore(JoinPoint joinPoint, NeedCheck nc) throws Throwable {
        Object[] args = joinPoint.getArgs();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Object>> constraintViolations;
        StringBuilder outStr = new StringBuilder("");
        for (Object arg : args) {
            constraintViolations = validator.validate(arg);
            if (!constraintViolations.isEmpty()) {
                for (ConstraintViolation<Object> constraintViolation : constraintViolations) {
                    outStr.append(constraintViolation.getPropertyPath()).append(":").append(constraintViolation.getMessage()).append(",");
                }
            }
        }
        if (StringUtils.isNotEmpty(outStr.toString())) {
//            throw new CheckException(joinPoint.getSignature().getName() + " check error:" + outStr);
            throw new CheckException(outStr.toString());
        }
    }
}

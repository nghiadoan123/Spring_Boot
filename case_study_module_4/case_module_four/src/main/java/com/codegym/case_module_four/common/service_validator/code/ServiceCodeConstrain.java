package com.codegym.case_module_four.common.service_validator.code;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ServiceCodeValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ServiceCodeConstrain {

    String message() default "invalid service code is duplicate";
    Class<?>[] groups() default {};
    Class<?extends Payload> [] payload() default {};

}

package com.codegym.case_module_four.common.customer_validator.code;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CustomerCodeValidator.class)
//Tạo annotation cho thuộc tính -> Field
//Tạo annotation cho class -> type
//Tạo annotation cho phương thức -> method
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomerCodeConstraint {

    String message() default "invalid customer code is duplicate";
    Class<?>[] groups() default {};
    Class<?extends Payload> [] payload() default {};
}

package com.codegym.case_module_four.common.customer_validator.id_card;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CustomerIdValidator.class)
//Tạo annotation cho thuộc tính -> Field
//Tạo annotation cho class -> type
//Tạo annotation cho phương thức -> method
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomerIdConstraint {

    String message() default "invalid customer id card is duplicate";
    Class<?>[] groups() default {};
    Class<?extends Payload> [] payload() default {};

}

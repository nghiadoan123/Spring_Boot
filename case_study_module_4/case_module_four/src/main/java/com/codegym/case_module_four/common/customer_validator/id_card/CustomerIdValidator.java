package com.codegym.case_module_four.common.customer_validator.id_card;

import com.codegym.case_module_four.model.customer.Customer;
import com.codegym.case_module_four.repository.customer.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;


public class CustomerIdValidator implements ConstraintValidator<CustomerIdConstraint,String> {
    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Override
    public void initialize(CustomerIdConstraint constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        List<Customer> customerList = iCustomerRepository.findAll();
        for (Customer customer: customerList) {
            if (customer.getIdCard().equals(value)){
               return false;
            }
        }
        return value.matches("(^\\d{9}$)||(^\\d{12}$)");
    }
}

package com.codegym.case_module_four.common.customer_validator.code;

import com.codegym.case_module_four.model.customer.Customer;
import com.codegym.case_module_four.repository.customer.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;


public class CustomerCodeValidator implements ConstraintValidator<CustomerCodeConstraint,String> {

    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Override
    public void initialize(CustomerCodeConstraint constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        List<Customer> customerList = iCustomerRepository.findAll();
        Customer customer1 = new Customer();
        for (Customer customer: customerList) {
            if (customer.getCodeNumber().equals(value)){
//                customer1 = customer;
                return false;
            }
        }

//        for (Customer customer2: customerList) {
//            if (customer2.getId() == customer1.getId() && customer2.getCodeNumber().equals(customer1.getCodeNumber())){
//                return true;
//            }else {
//                return false;
//            }
//        }
        return value.matches("^[K][H]-\\d{4}$");
    }
}

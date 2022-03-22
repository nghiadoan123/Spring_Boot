package com.codegym.case_module_four.common.service_validator.code;

import com.codegym.case_module_four.model.service.Services;
import com.codegym.case_module_four.repository.service.IServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class ServiceCodeValidator implements ConstraintValidator<ServiceCodeConstrain,String> {
    @Autowired
    private IServiceRepository iServiceRepository;
    @Override
    public void initialize(ServiceCodeConstrain constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        List<Services> servicesList = iServiceRepository.findAll();
        for (Services services: servicesList) {
            if (services.getCodeService().equals(value)){
                return false;
            }
        }
        return value.matches("^DV-\\d{4,}$");
    }
}

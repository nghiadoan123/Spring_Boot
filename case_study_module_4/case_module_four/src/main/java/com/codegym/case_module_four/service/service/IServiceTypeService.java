package com.codegym.case_module_four.service.service;

import com.codegym.case_module_four.model.service.RentalType;
import com.codegym.case_module_four.model.service.ServiceType;

import java.util.List;

public interface IServiceTypeService {

    List<ServiceType> getAll();

    ServiceType findById(Integer id);

    void save(ServiceType serviceType);

    List<ServiceType> findByName(String name);

    void remove(Integer id);
}

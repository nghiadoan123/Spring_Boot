package com.codegym.case_module_four.service.service.impl;

import com.codegym.case_module_four.model.service.ServiceType;
import com.codegym.case_module_four.repository.service.IServiceTypeRepository;
import com.codegym.case_module_four.service.service.IServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceTypeService implements IServiceTypeService {

    @Autowired
    private IServiceTypeRepository iServiceTypeRepository;

    @Override
    public List<ServiceType> getAll() {
        return iServiceTypeRepository.findAll();
    }

    @Override
    public ServiceType findById(Integer id) {
        return iServiceTypeRepository.findById(id).orElse(null);
    }

    @Override
    public void save(ServiceType serviceType) {
        iServiceTypeRepository.save(serviceType);
    }

    @Override
    public List<ServiceType> findByName(String name) {
        return null;
    }

    @Override
    public void remove(Integer id) {
        iServiceTypeRepository.deleteById(id);
    }
}

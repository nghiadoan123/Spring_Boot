package com.codegym.case_module_four.service.service.impl;

import com.codegym.case_module_four.model.service.Services;
import com.codegym.case_module_four.repository.service.IServiceRepository;
import com.codegym.case_module_four.service.service.IServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceService implements IServiceService {

    @Autowired
    private IServiceRepository iServiceRepository;


    @Override
    public List<Services> getAll() {
        return iServiceRepository.findAll();
    }

    @Override
    public Services findById(Integer id) {
        return iServiceRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Services services) {
        iServiceRepository.save(services);
    }

    @Override
    public List<Services> findByName(String name) {
        return null;
    }

    @Override
    public void remove(Integer id) {
        iServiceRepository.deleteById(id);
    }

    @Override
    public Page<Services> findAll(PageRequest of) {
        return iServiceRepository.findAll(of);
    }
}

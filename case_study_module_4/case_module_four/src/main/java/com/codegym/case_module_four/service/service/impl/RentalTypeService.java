package com.codegym.case_module_four.service.service.impl;

import com.codegym.case_module_four.model.service.RentalType;
import com.codegym.case_module_four.repository.service.IRentalTypeRepository;
import com.codegym.case_module_four.service.service.IRentalTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentalTypeService implements IRentalTypeService {

    @Autowired
    private IRentalTypeRepository iRentalTypeRepository;

    @Override
    public List<RentalType> getAll() {
        return iRentalTypeRepository.findAll();
    }

    @Override
    public RentalType findById(Integer id) {
        return iRentalTypeRepository.findById(id).orElse(null);
    }

    @Override
    public void save(RentalType rentalType) {
        iRentalTypeRepository.save(rentalType);
    }

    @Override
    public List<RentalType> findByName(String name) {
        return null;
    }

    @Override
    public void remove(Integer id) {
        iRentalTypeRepository.deleteById(id);
    }
}

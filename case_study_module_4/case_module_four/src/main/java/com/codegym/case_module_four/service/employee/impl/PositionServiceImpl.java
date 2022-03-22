package com.codegym.case_module_four.service.employee.impl;

import com.codegym.case_module_four.model.employee.Position;
import com.codegym.case_module_four.repository.employee.IPositionRepository;
import com.codegym.case_module_four.service.employee.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionServiceImpl implements IPositionService {

    @Autowired
    private IPositionRepository iPositionRepository;

    @Override
    public List<Position> getAll() {
        return iPositionRepository.findAll();
    }

    @Override
    public Position findById(Integer id) {
        return iPositionRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Position position) {
        iPositionRepository.save(position);
    }

    @Override
    public List<Position> findByName(String name) {
        return null;
    }

    @Override
    public void remove(Integer id) {
        iPositionRepository.deleteById(id);
    }
}

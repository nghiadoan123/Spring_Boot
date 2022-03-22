package com.codegym.case_module_four.service.employee;

import com.codegym.case_module_four.model.employee.EducationDegree;
import com.codegym.case_module_four.model.employee.Position;

import java.util.List;

public interface IPositionService {



    List<Position> getAll();

    Position findById(Integer id);

    void save(Position position);

    List<Position> findByName(String name);

    void remove(Integer id);
}

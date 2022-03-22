package com.codegym.case_module_four.service.employee;

import com.codegym.case_module_four.model.employee.Division;
import com.codegym.case_module_four.model.employee.EducationDegree;

import java.util.List;

public interface IEducationDegreeService {

    List<EducationDegree> getAll();

    EducationDegree findById(Integer id);

    void save(EducationDegree educationDegree);

    List<EducationDegree> findByName(String name);

    void remove(Integer id);
}

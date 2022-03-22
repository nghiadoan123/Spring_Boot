package com.codegym.case_module_four.repository.employee;

import com.codegym.case_module_four.model.customer.Customer;
import com.codegym.case_module_four.model.employee.EducationDegree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEducationDegreeRepository  extends JpaRepository<EducationDegree,Integer> {
}

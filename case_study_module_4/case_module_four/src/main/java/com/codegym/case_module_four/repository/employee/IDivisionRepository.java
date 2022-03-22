package com.codegym.case_module_four.repository.employee;

import com.codegym.case_module_four.model.customer.Customer;
import com.codegym.case_module_four.model.employee.Division;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDivisionRepository  extends JpaRepository<Division,Integer> {
}

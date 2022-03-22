package com.codegym.case_module_four.repository.service;

import com.codegym.case_module_four.model.employee.Division;
import com.codegym.case_module_four.model.service.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IServiceTypeRepository extends JpaRepository<ServiceType,Integer> {
}

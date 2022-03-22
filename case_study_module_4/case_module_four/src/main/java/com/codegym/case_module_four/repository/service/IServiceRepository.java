package com.codegym.case_module_four.repository.service;

import com.codegym.case_module_four.model.service.Services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IServiceRepository extends JpaRepository<Services,Integer> {
}

package com.codegym.case_module_four.service.contract;

import com.codegym.case_module_four.model.contract.Contract;
import com.codegym.case_module_four.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface IContractService {

    List<Contract> getAll();

    Contract findById(Integer id);

    void save(Contract contract);

    List<Contract> findByName(String name);

    void remove(Integer id);

    Page<Contract> findAll(PageRequest of);
}

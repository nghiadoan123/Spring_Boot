package com.codegym.case_module_four.service.contract.impl;

import com.codegym.case_module_four.model.contract.Contract;
import com.codegym.case_module_four.repository.contract.IContractRepository;
import com.codegym.case_module_four.service.contract.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractServiceImpl implements IContractService {

    @Autowired
    private IContractRepository iContractRepository;

    @Override
    public List<Contract> getAll() {
        return iContractRepository.findAll();
    }

    @Override
    public Contract findById(Integer id) {
        return iContractRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Contract contract) {
        iContractRepository.save(contract);
    }

    @Override
    public List<Contract> findByName(String name) {
        return null;
    }

    @Override
    public void remove(Integer id) {
        iContractRepository.deleteById(id);
    }

    @Override
    public Page<Contract> findAll(PageRequest of) {
        return iContractRepository.findAll(of);
    }
}

package com.codegym.case_module_four.service.contract.impl;

import com.codegym.case_module_four.model.contract.ContractDetail;
import com.codegym.case_module_four.repository.contract.IContractDetailRepository;
import com.codegym.case_module_four.service.contract.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractDetailServiceImpl implements IContractDetailService {


    @Autowired
    private IContractDetailRepository iContractDetailRepository;

    @Override
    public List<ContractDetail> getAll() {
        return iContractDetailRepository.findAll();
    }

    @Override
    public ContractDetail findById(Integer id) {
        return iContractDetailRepository.findById(id).orElse(null);
    }

    @Override
    public void save(ContractDetail contractDetail) {
        iContractDetailRepository.save(contractDetail);
    }

    @Override
    public List<ContractDetail> findByName(String name) {
        return null;
    }

    @Override
    public void remove(Integer id) {
        iContractDetailRepository.deleteById(id);
    }
}

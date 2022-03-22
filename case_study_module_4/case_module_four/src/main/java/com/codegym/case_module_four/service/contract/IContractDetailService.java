package com.codegym.case_module_four.service.contract;

import com.codegym.case_module_four.model.contract.Contract;
import com.codegym.case_module_four.model.contract.ContractDetail;

import java.util.List;

public interface IContractDetailService {

    List<ContractDetail> getAll();

    ContractDetail findById(Integer id);

    void save(ContractDetail contractDetail);

    List<ContractDetail> findByName(String name);

    void remove(Integer id);
}

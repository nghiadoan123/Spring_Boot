package com.codegym.case_module_four.service.contract;

import com.codegym.case_module_four.model.contract.AttachService;
import com.codegym.case_module_four.model.contract.ContractDetail;

import java.util.List;

public interface IAttachServiceService {

    List<AttachService> getAll();

    AttachService findById(Integer id);

    void save(AttachService attachService);

    List<AttachService> findByName(String name);

    void remove(Integer id);
}

package com.codegym.case_module_four.service.contract.impl;

import com.codegym.case_module_four.model.contract.AttachService;
import com.codegym.case_module_four.repository.contract.IAttachServiceRepository;
import com.codegym.case_module_four.service.contract.IAttachServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachServiceServiceImpl implements IAttachServiceService {

    @Autowired
    private IAttachServiceRepository iAttachServiceRepository;

    @Override
    public List<AttachService> getAll() {
        return iAttachServiceRepository.findAll();
    }

    @Override
    public AttachService findById(Integer id) {
        return iAttachServiceRepository.findById(id).orElse(null);
    }

    @Override
    public void save(AttachService attachService) {
        iAttachServiceRepository.save(attachService);
    }

    @Override
    public List<AttachService> findByName(String name) {
        return null;
    }

    @Override
    public void remove(Integer id) {
        iAttachServiceRepository.deleteById(id);
    }
}

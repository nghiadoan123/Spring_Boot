package com.codegym.case_module_four.repository.contract;

import com.codegym.case_module_four.model.contract.ContractDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IContractDetailRepository  extends JpaRepository<ContractDetail,Integer> {
}

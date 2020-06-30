package com.infosys.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infosys.model.BankAccount;

public interface BankAccountRepository extends JpaRepository<BankAccount,String> {
	
	List<BankAccount> findByEmpId(String empId);
	
	boolean existsByEmpId(String empId);

}

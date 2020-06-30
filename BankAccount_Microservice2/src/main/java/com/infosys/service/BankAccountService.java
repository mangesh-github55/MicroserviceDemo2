package com.infosys.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.dto.BankAccountDTO;
import com.infosys.model.BankAccount;
import com.infosys.repository.BankAccountRepository;
@Service
public class BankAccountService {

	@Autowired
	private BankAccountRepository repository;

	public String addBankAccount(List<BankAccountDTO> bankAccountDTOs) {
		// TODO Auto-generated method stub
		List<BankAccount> bankAccounts = new ArrayList<>(); 
		bankAccountDTOs.forEach(bankAccountDTO -> bankAccounts.add(bankAccountDTO.getBankAccountEntity()));
		repository.saveAll(bankAccounts);
		return "Save Successfuly";
	}

	public List<BankAccountDTO> getBankAccountByEmpId(String empId) throws Exception {
		// TODO Auto-generated method stub
		List<BankAccountDTO> bankAccountDTOs= new ArrayList<>();
		if(repository.existsByEmpId(empId)) {
			List<BankAccount> bankAccounts= repository.findByEmpId(empId);
			bankAccounts.forEach(bankAccount -> bankAccountDTOs.add(BankAccountDTO.getBankAccountDTO(bankAccount)));
		}else {
			throw new Exception("Not Exists");
		}
		return bankAccountDTOs;
	}

	public List<BankAccountDTO> getAllBankAccount() {
		// TODO Auto-generated method stub
		List<BankAccountDTO> accountDTOs = new ArrayList<>();
		List<BankAccount> accounts = repository.findAll();
		for (BankAccount account : accounts) {
			accountDTOs.add(BankAccountDTO.getBankAccountDTO(account));
		}
		return accountDTOs;
	}
}

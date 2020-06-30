package com.infosys.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.dto.BankAccountDTO;
import com.infosys.service.BankAccountService;

@RestController
@RequestMapping(value="/")
public class BankAccountController {

	@Autowired
	private BankAccountService service;

	public String welcomeMessage() {
		return "Welocome to Spring MicroService";
	}

	@GetMapping("bankAccount")
	public List<BankAccountDTO> getAllBankAccount()  {
		System.out.println("(********");
		return service.getAllBankAccount();
	}

	@GetMapping("bankAccount/{empId}")
	public List<BankAccountDTO> getBankAccountByEmpId(@PathVariable String empId) throws Exception {
		System.out.println("=======fetching Data =====");
		return service.getBankAccountByEmpId(empId);
	}

	@PostMapping("bankAccount")
	public String addBankAccount(@Valid @RequestBody List<BankAccountDTO> bankAccountDTOs)throws MethodArgumentNotValidException {
		return 	service.addBankAccount(bankAccountDTOs);
	}
}

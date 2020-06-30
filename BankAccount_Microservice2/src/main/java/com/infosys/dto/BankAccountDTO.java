package com.infosys.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.infosys.model.BankAccount;

public class BankAccountDTO implements Serializable {

	@NotNull(message="Account No cannot be null")
	@NotBlank(message="Account No cannot be blank")
	@Size(min=5,max=20,message="Account No length must be between 5 to 20")
	private String accountNo;
	private String bankName;
	private String branch;
	private String ifscCode;
	private String empId;

	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getIfscCode() {
		return ifscCode;
	}
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	
	public static BankAccountDTO getBankAccountDTO(BankAccount bankAccount) {
		BankAccountDTO bankAccountDTO= new BankAccountDTO();
		bankAccountDTO.setAccountNo(bankAccount.getAccountNo());
		bankAccountDTO.setBankName(bankAccount.getBankName());
		bankAccountDTO.setBranch(bankAccount.getBranch());
		bankAccountDTO.setIfscCode(bankAccount.getIfscCode());
		bankAccountDTO.setEmpId(bankAccount.getEmpId());
		return bankAccountDTO;
	}

	@JsonIgnore
	public 	 BankAccount getBankAccountEntity() {
		BankAccount bankAccount= new BankAccount();
		bankAccount.setAccountNo(this.accountNo);
		bankAccount.setBankName(this.bankName);
		bankAccount.setBranch(this.branch);
		bankAccount.setIfscCode(this.ifscCode);
		bankAccount.setEmpId(this.empId);
		return bankAccount;
	}

}

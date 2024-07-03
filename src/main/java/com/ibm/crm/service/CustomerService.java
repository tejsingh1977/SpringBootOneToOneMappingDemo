package com.ibm.crm.service;


import com.ibm.crm.dto.AddressDTO;
import com.ibm.crm.dto.CustomerDTO;
import com.ibm.crm.exception.InfyBankException;

public interface CustomerService {
	
	public CustomerDTO getCustomer(Integer customerId) throws InfyBankException;
	public Integer addCustomer(CustomerDTO customerDTO);
	public void updateAddress(Integer customerId, AddressDTO addressDTO) throws InfyBankException;
	public void deleteCustomer(Integer customerId) throws InfyBankException;
	
}
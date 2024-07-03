package com.ibm.crm;

import com.ibm.crm.dto.AddressDTO;
import com.ibm.crm.dto.CustomerDTO;
import com.ibm.crm.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import java.time.LocalDate;

@SpringBootApplication
public class SpringBootOneToOneMappingDemoApplication implements CommandLineRunner {

	@Autowired
	CustomerService customerService;

	@Autowired
	Environment environment;
	public static void main(String[] args) {
		SpringApplication.run(SpringBootOneToOneMappingDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//getCustomer();
		//addCustomer();
		//updateAddress();
		 deleteCustomer();
	}

	public void getCustomer() {
		try {
			CustomerDTO customerDTO = customerService.getCustomer(1234);
			System.out.println(customerDTO);
			//LOGGER.info(customerDTO);
		} catch (Exception e) {
			String message = environment.getProperty(e.getMessage(), "Some exception occured. Please check log file for more details!!");
			System.out.println(message);
			///LOGGER.info(message);
		}
	}

	public void addCustomer() {
		try {
			CustomerDTO customerDTO = new CustomerDTO();
			customerDTO.setName("Amit");
			customerDTO.setEmailId("amit@infy.com");
			customerDTO.setDateOfBirth(LocalDate.of(1993, 03, 24));
			AddressDTO addressDTO = new AddressDTO();
			addressDTO.setAddressId(103L);
			addressDTO.setCity("Palwal");
			addressDTO.setStreet("93 Taylor Road");
			customerDTO.setAddress(addressDTO);
			Integer customerId = customerService.addCustomer(customerDTO);
			System.out.println("\n" + environment.getProperty("UserInterface.CUSTOMER_ADDED") + customerId);
		} catch (Exception e) {
			String message = environment.getProperty(e.getMessage(),"Some exception occurred. Please check log file for more details!!");
			System.out.println(message);
		}
	}

	public void updateAddress() {
		try {
			AddressDTO addressDTO = new AddressDTO();
			addressDTO.setCity("Delhi");
			addressDTO.setStreet("Bahra Ghamba Road Street");
			customerService.updateAddress(1234, addressDTO);
			System.out.println("\n" + environment.getProperty("UserInterface.CUSTOMER_UPDATED"));
		} catch (Exception e) {
			String message = environment.getProperty(e.getMessage(),"Some exception occured. Please check log file for more details!!");
			System.out.println(message);
		}
	}

	public void deleteCustomer() {
		try {
			customerService.deleteCustomer(1234);
			System.out.println("\n" + environment.getProperty("UserInterface.CUSTOMER_ADDRESS_DELETED"));
		} catch (Exception e) {
			String message = environment.getProperty(e.getMessage(), "Some exception occured. Please check log file for more details!!");
			System.out.println(message);
		}
	}

}

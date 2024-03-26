package com.bank_management_system.repository;

import com.bank_management_system.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer> {
	
	Customer findByEmailIdAndPassword(String emailId, String password);
	Customer findByEmailId(String emailId);



}

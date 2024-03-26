package com.bank_management_system.repository;


import com.bank_management_system.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountDao extends JpaRepository<Account, Integer> {
	
	Account findByCustomerId(int customerId);
	Account findByAccountNo(String accountNo);

}

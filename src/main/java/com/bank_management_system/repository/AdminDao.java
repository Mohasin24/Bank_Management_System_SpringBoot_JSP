package com.bank_management_system.repository;


import com.bank_management_system.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminDao extends JpaRepository<Admin, Integer> {
	
	Admin findByUserIdAndPassword(String userId, String password);

}

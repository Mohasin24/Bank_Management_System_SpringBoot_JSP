package com.bank_management_system.controller;


import com.bank_management_system.entity.Account;
import com.bank_management_system.entity.AccountTransaction;
import com.bank_management_system.entity.Customer;
import com.bank_management_system.repository.AccountDao;
import com.bank_management_system.repository.AccountTransactionDao;
import com.bank_management_system.utility.Constants;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.Optional;

@Controller
public class AccountTransactionController {
	
	@Autowired
	private AccountTransactionDao accountTransactionDao;
	
	@Autowired
	private AccountDao accountDao;
	
	@GetMapping("/withdraw")
	public String goToWithdraw() {
		return "withdraw";
	}

	@GetMapping("/deposit")
	public String goToDeposit() {
		return "deposit";
	}
	
	@PostMapping("/withdraw")
	public ModelAndView withdraw(@RequestParam("amount") double amount, @RequestParam("pin") int pin, HttpSession session) {
		
		ModelAndView mv = new ModelAndView();
		
		Customer customer = (Customer)session.getAttribute("active-user");
		Account account = null;
		Optional<Account> o = accountDao.findById(customer.getId());
		if(o.isPresent()) {
			account = o.get();
		}
		
		if(account.getStatus().equals(Constants.AccountStatus.LOCK.value())) {
			mv.addObject("status", "Account is Locked, Please contact Bank Administrator!!!");
			mv.setViewName("index");
			return mv;
		}
		
		if(pin != account.getPin()) {
			mv.addObject("status", "Wrong Pin!");
			mv.setViewName("index");
			return mv;
		}
		
		if(account.getBalance() < amount ) {
			mv.addObject("status", "Insufficient Balance!");
			mv.setViewName("index");
			return mv;
		}
		
		else {
			double balanceAmount = account.getBalance() - amount;
			account.setBalance(balanceAmount);
			accountDao.save(account);
			
			AccountTransaction transaction = new AccountTransaction();
			transaction.setAccountId(account.getId());
			transaction.setAmount(amount);
			transaction.setDate(LocalDate.now().toString());
			transaction.setType(Constants.TransactionType.WITHDRAW.value());
			
			accountTransactionDao.save(transaction);
			
			mv.addObject("status", "Amount withdrawn successfully!");
			mv.setViewName("index");
			return mv;
			
		}
	}
	
	@PostMapping("/deposit")
	public ModelAndView deposit(@RequestParam("amount") double amount, @RequestParam("pin") int pin, HttpSession session) {
		
		ModelAndView mv = new ModelAndView();
		
		Customer customer = (Customer)session.getAttribute("active-user");
		Account account = null;
		Optional<Account> o = accountDao.findById(customer.getId());
		if(o.isPresent()) {
			account = o.get();
		}
		
		if(account.getStatus().equals(Constants.AccountStatus.LOCK.value())) {
			mv.addObject("status", "Account is Locked, Please contact Bank Administrator!!!");
			mv.setViewName("index");
			return mv;
		}
		
		if(pin != account.getPin()) {
			mv.addObject("status", "Wrong Pin!");
			mv.setViewName("index");
			return mv;
		}
		
		else {
			double balanceAmount = account.getBalance() + amount;
			account.setBalance(balanceAmount);
			accountDao.save(account);
			
			AccountTransaction transaction = new AccountTransaction();
			transaction.setAccountId(account.getId());
			transaction.setAmount(amount);
			transaction.setDate(LocalDate.now().toString());
			transaction.setType(Constants.TransactionType.DEPOSIT.value());
			
			accountTransactionDao.save(transaction);
			
			mv.addObject("status", "Amount Deposit successfully!");
			mv.setViewName("index");
			return mv;
			
		}
	}

	
}

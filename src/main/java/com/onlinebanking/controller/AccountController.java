package com.onlinebanking.controller;

import java.time.LocalDate;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.onlinebanking.dao.AccountDao;

import com.onlinebanking.model.Account;

import com.onlinebanking.model.Customer;
import com.onlinebanking.utility.Constants.CheckbookStatus;

@Controller
public class AccountController {
	
	@Autowired
	private AccountDao accountDao;
	
	
	
	@PostMapping("/addaccount")
	public ModelAndView registerAdmin(@ModelAttribute Account account) {
		ModelAndView mv = new ModelAndView();
		
		accountDao.save(account);
		
		mv.addObject("status", "Account Added Successfully!");
		mv.setViewName("index");
		return mv;
	}
	
	@GetMapping("/changepin")
	public String goToCahnegPinPage() {
		return "changepin";
	}
	
	@PostMapping("/changepin")
	public ModelAndView changePin(@RequestParam("currentpin") int currentPin, @RequestParam("newpin") int newPin, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		
		Customer customer = (Customer)session.getAttribute("active-user");
		Account account = null;
		Optional<Account> o = accountDao.findById(customer.getId());
		if(o.isPresent()) {
			account = o.get();
		}
		
		account.setPin(newPin);
		accountDao.save(account);
		
		mv.addObject("status", "Pin changed Successfully!");
		mv.setViewName("index");
		return mv;
	}
	
	@GetMapping("/changeAccountStatus")
	public ModelAndView changeAccountStatus(@RequestParam("accountId") int accountId, @RequestParam("accountStatus") String accountStatus) {
		ModelAndView mv = new ModelAndView();
		
		Account account = accountDao.findById(accountId).get();
		account.setStatus(accountStatus);
		
		accountDao.save(account);
		
		mv.addObject("status", "Account Status Updated!");
		mv.setViewName("index");
		return mv;
	}

	
	

}

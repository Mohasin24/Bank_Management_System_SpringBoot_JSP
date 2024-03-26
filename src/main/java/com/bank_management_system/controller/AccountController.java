package com.bank_management_system.controller;

import com.bank_management_system.entity.Account;
import com.bank_management_system.repository.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


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

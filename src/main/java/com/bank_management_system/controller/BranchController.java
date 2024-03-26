package com.bank_management_system.controller;

import com.bank_management_system.entity.Branch;
import com.bank_management_system.repository.BranchDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class BranchController {
	
	@Autowired
	private BranchDao branchDao;
	
	@GetMapping("/addbranch")
	public String gotToLoginPage() {
		return "addbranch";
	}
	
	@PostMapping("/addbranch")
	public ModelAndView addBranch(@ModelAttribute Branch branch) {
      ModelAndView mv = new ModelAndView();
		
		branchDao.save(branch);
		
		mv.addObject("status", "Branch Added Successfully.");
		mv.setViewName("index");
		return mv;
	}

}

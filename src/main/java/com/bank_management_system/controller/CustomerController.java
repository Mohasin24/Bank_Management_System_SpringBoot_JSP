package com.bank_management_system.controller;


import com.bank_management_system.entity.Customer;
import com.bank_management_system.repository.AccountDao;
import com.bank_management_system.repository.CustomerDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {
	
	@Autowired
	private CustomerDao customerDao;

	@Autowired
	private AccountDao accountDao;
	
	@GetMapping("/")
	public String gotToIndexPage() {
		return "index";
	}
	
	@GetMapping("/home")
	public String gotToHomePage() {
		return "index";
	}
	
	@GetMapping("/customerlogin")
	public String gotToLoginPage() {
		return "login";
	}
	
	@GetMapping("/customerregister")
	public String goToRegisterPage() {
		return "registeruser";
	}
	
	@PostMapping("/registercustomer")
	public ModelAndView registerCustomer(@ModelAttribute Customer customer) {
		ModelAndView mv = new ModelAndView();
		
		Customer c = customerDao.save(customer);
		
		mv.addObject("status", "Customer Successfully Registered, Customer Id is "+c.getId());
		mv.setViewName("addaccount");
		return mv;
	}
	
	@PostMapping("/logincustomer")
	public ModelAndView loginCustomer(@RequestParam("emailId") String emailId, @RequestParam("password") String password, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		
		Customer c = customerDao.findByEmailIdAndPassword(emailId, password);
		
		if(c != null) {
			HttpSession session = request.getSession();
			session.setAttribute("active-user", c);
			session.setAttribute("user-login","customer");
			mv.addObject("status", "Customer Logged in Successfully.");
			mv.setViewName("index");
		}
		
		else {
			mv.addObject("status", "Customer is not registered");
			mv.setViewName("redirect:/customerregister");
		}
		
		
		return mv;
	}

	@RequestMapping(value = "/deleteUser", method = {RequestMethod.GET, RequestMethod.POST})
	public String deleteAccount(@RequestParam("customerId") int id, HttpServletRequest request) {
		customerDao.deleteById(id);
		accountDao.delete(accountDao.findByCustomerId(id));
		HttpSession session = request.getSession();
		session.setAttribute("user-login",null);
		return "redirect:/";
	}
	
}

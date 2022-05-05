package com.bagudu.fleetApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.bagudu.fleetApp.models.User;
import com.bagudu.fleetApp.services.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;

	/*@GetMapping("/users")
	public String getUsers() {
		return "user";
	}	*/
	
	@PostMapping(value="/users/addnew")
	public RedirectView addNew(User user, RedirectAttributes redir) { 
		
		userService.addUser(user);	
		RedirectView  redirectView= new RedirectView("/login",true);
	    redir.addFlashAttribute("message", "You successfully registered! You can now login"); 
	        
	    return redirectView;				
	}	
	
	//Get All Users
	@GetMapping("users")
	public String findAll(Model model){
		model.addAttribute("users", userService.findAll());
		return "user";
	}

	@RequestMapping("/users/findById")
	@ResponseBody
	public User findById(Integer id)
	{
		return userService.findById(id);
	}
	
}

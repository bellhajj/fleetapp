package com.bagudu.fleetApp.security.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bagudu.fleetApp.models.User;
import com.bagudu.fleetApp.security.models.Role;
import com.bagudu.fleetApp.security.services.RoleService;
import com.bagudu.fleetApp.services.UserService;

@Controller
public class RoleController {

	@Autowired
	private RoleService roleService;
	
	@Autowired 
	private UserService userService;
	
	@GetMapping("/security/user/edit/{id}")
	public String editUser(@PathVariable Integer id, Model model){
		
	    User user = userService.findById(id);
	    model.addAttribute("user", user);
	    model.addAttribute("userRoles", roleService.getUserRoles(user));
	    model.addAttribute("userNotRoles", roleService.getUserNotRoles(user));
	    return "/useredit";
	}
	
	
	@RequestMapping("/security/role/assign/{userId}/{roleId}")
	public String assignRole(@PathVariable Integer userId, @PathVariable Integer roleId){
		
	    roleService.assignUserRole(userId, roleId);
	    return "redirect:/security/user/edit/"+userId;
	}
	
	@RequestMapping("/security/role/unassign/{userId}/{roleId}")
	public String unassignRole(@PathVariable Integer userId, @PathVariable Integer roleId){
		
	    roleService.unassignUserRole(userId, roleId);
	    return "redirect:/security/user/edit/"+userId;
	}
	
	@GetMapping("/roles")
	public String getRoles(Model model) {
		
		List<Role> roleList = roleService.getRoles();
		model.addAttribute("roles", roleList);
				
		return "role";
	}
	
	@PostMapping("/roles/addnew")
	public String addRole(Role role) {
		
		roleService.addRole(role);
		return "redirect:/roles";
	}
	
	@RequestMapping("/roles/findbyid")
	@ResponseBody
	public Optional<Role> findById(int id){
		
		return roleService.findById(id);
	}
	
	@RequestMapping(value="/roles/update", method={RequestMethod.PUT, RequestMethod.GET})
	public String updateRole(Role role) {
		
		roleService.addRole(role);
		return "redirect:/roles";
	}
	
	@RequestMapping(value="/roles/delete", method={RequestMethod.DELETE, RequestMethod.GET})
	public String deleteRole(Integer id) {		
		roleService.delete(id);
		return "redirect:/roles";
	}
	
	
}

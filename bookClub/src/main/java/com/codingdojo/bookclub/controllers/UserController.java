package com.codingdojo.bookclub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.bookclub.models.LoginUser;
import com.codingdojo.bookclub.models.User;
import com.codingdojo.bookclub.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private HttpSession session;
	
	@GetMapping("/")
	public String loginReg(@ModelAttribute("registerUser") User registerUser,
			@ModelAttribute("loginUser") User loginUser) {
		return "loginReg.jsp";
	}
	
	@PostMapping("/register")
    public String register(@Valid @ModelAttribute("registerUser") User registerUser, 
            BindingResult result, Model model) {
        
		User registeredUserOrNull = userService.validateRegistration(registerUser, result);
		
		if (registeredUserOrNull == null) {
			model.addAttribute("loginUser", new LoginUser());
			return "loginReg.jsp";
		}
        
        // Save the Id of the new user in session
		session.setAttribute("userId", registeredUserOrNull.getId());
    
        return "redirect:/books";
    }
    
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("loginUser") LoginUser loginUser, 
            BindingResult result, Model model, HttpSession session) {
        
        User loggedUserOrNull = userService.validateLogin(loginUser, result);
        if (loggedUserOrNull == null) {
        	model.addAttribute("registerUser", new User());
        	return "loginReg.jsp";
        }
        
        // Save the Id of the new user in session
        session.setAttribute("userId", loggedUserOrNull.getId());
        
        return "redirect:/books";
    }
    
    @PostMapping("/logout")
    public String logout() {
    	session.invalidate(); // Clears session, removing logged in user
    	return "redirect:/";
    }
}

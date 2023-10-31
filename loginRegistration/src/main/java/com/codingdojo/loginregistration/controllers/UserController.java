package com.codingdojo.loginregistration.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.loginregistration.models.LoginUser;
import com.codingdojo.loginregistration.models.User;
import com.codingdojo.loginregistration.services.UserService;

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
	
	@GetMapping("/dashboard")
	public String dashboard(Model model) {
		Long userId = (Long) session.getAttribute("userId");
		if (userId == null) {
			return "redirect:/";
		}
		User user = userService.getUserById(userId);
		// check to see if user is logged in
		model.addAttribute("loggedUser", user);
		return "dashboard.jsp";
	}
	
	@PostMapping("/register")
    public String register(@Valid @ModelAttribute("registerUser") User registerUser, 
            BindingResult result, Model model) {
        
        // TO-DO Later -- call a register method in the service 
        // to do some extra validations and create a new user!
		User registeredUserOrNull = userService.validateRegistration(registerUser, result);
		
		if (registeredUserOrNull == null) {
			model.addAttribute("loginUser", new LoginUser());
			return "loginReg.jsp";
		}
        
        // Save the ID of the new user in session
		session.setAttribute("userId", registeredUserOrNull.getId());
    
        return "redirect:/dashboard";
    }
    
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
            BindingResult result, Model model, HttpSession session) {
        
        // Add once service is implemented:
        // User user = userServ.login(newLogin, result);
    
        if(result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "loginReg.jsp";
        }
    
        // No errors! 
        // TO-DO Later: Store their ID from the DB in session, 
        // in other words, log them in.
    
        return "redirect:/dashboard";
    }
    
    @PostMapping("/logout")
    public String logout() {
    	session.invalidate(); // Clears session, removing logged in user
    	return "redirect:/";
    }
}

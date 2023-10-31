package com.codingdojo.loginregistration.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.loginregistration.models.LoginUser;
import com.codingdojo.loginregistration.models.User;
import com.codingdojo.loginregistration.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	
	public User validateRegistration(User registerUser, BindingResult result) {
		// Checking passwords match
		if (!registerUser.getPassword().equals(registerUser.getConfirmedPassword())) {
			result.rejectValue("password", "passwordsDisagree.regiesterUser.password", "Passwords must match");
		}
		
		// Check if the email is taken
		Optional<User> possibleUser = userRepo.findByEmail(registerUser.getEmail());
		if (possibleUser.isPresent()) {
			result.rejectValue("email", "emailTaken.registerUser.email", "Email is already being used.");
		}
		
		// Check validations
		if (result.hasErrors()) {
			return null;
		}
		 // If validations are good:
		String hashedPassword = BCrypt.hashpw(registerUser.getPassword(), BCrypt.gensalt());
		registerUser.setPassword(hashedPassword);
		return userRepo.save(registerUser);
	}
	
	public User validateLogin(LoginUser loginUser, BindingResult result) {
		// attempt to find a user with given email
		Optional<User> possibleUser = userRepo.findByEmail(loginUser.getEmail());
		if (possibleUser.isEmpty()) {
			result.rejectValue("email", "invalidCredentials.loginUser.email", "Invalid login");
			return null;
		}
		
		// checking password
		User thisUser = possibleUser.get();
		if (!BCrypt.checkpw(loginUser.getPassword(), thisUser.getPassword())) {
			result.rejectValue("email", "invalidCredentials.loginUser.email", "Invalid login");
			return null;
		}
		
		// checking for errors
		if (result.hasErrors()) {
			return null;
		}
		return thisUser;
	}
	
	// Gets user by id
	public User getUserById(Long id) {
		Optional<User> possibleUser = userRepo.findById(id);
		return possibleUser.isPresent() ? possibleUser.get() : null;
	}
}

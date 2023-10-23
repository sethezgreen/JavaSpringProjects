package com.codingdojo.burgertracker.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.burgertracker.models.Burger;
import com.codingdojo.burgertracker.repositories.BurgerRepository;

@Service
public class BurgerService {

	private final BurgerRepository burgerRepository;
	
	public BurgerService(BurgerRepository burgerRepository) {
		this.burgerRepository = burgerRepository;
	}
	
	// returns all burgers
	public List<Burger> allBurgers() {
		return burgerRepository.findAll();
	}
	
	// creates a burger
	public Burger createBurger(Burger burger) {
		return burgerRepository.save(burger);
	}
	
	// finds one burger
	public Burger findBurgerById(Long id) {
		Optional<Burger> optionalBurger = burgerRepository.findById(id);
		return optionalBurger.isPresent() ? optionalBurger.get() : null;
	}
	
	// updates a burger
	public Burger updateBurger(Burger burger) {
		return burgerRepository.save(burger);
	}
}

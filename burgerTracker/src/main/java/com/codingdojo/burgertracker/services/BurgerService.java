package com.codingdojo.burgertracker.services;

import java.util.List;

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
}

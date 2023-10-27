package com.codingdojo.dojosninjas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.dojosninjas.models.Dojo;
import com.codingdojo.dojosninjas.repositories.DojoRepository;

@Service
public class DojoService {

	private final DojoRepository dojoRepo;
	
	public DojoService(DojoRepository dojoRepo) {
		this.dojoRepo = dojoRepo;
	}
	
	// returns all dojos
	public List<Dojo> allDojos() {
		return dojoRepo.findAll();
	}
	
	// creates a dojo
	public Dojo createDojo(Dojo dojo) {
		return dojoRepo.save(dojo);
	}
}

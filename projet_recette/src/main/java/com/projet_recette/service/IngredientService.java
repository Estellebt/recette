package com.projet_recette.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.projet_recette.entities.Ingredient;
import com.projet_recette.repository.IngredientRepository;


@Service
public class IngredientService {
	
	private final IngredientRepository ingredientRepository;
	
	public IngredientService(IngredientRepository ingredientRepository) {
		this.ingredientRepository = ingredientRepository;
	}
	
	
	//findAll
	public List<Ingredient> findAll() {
		return ingredientRepository.findAll();
	}
		
	//findById
	public Ingredient findById(int id) {
		return ingredientRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Ingredient non trouvé")); //renvoie un message personnalisé de l'erreur
	}
		
		
	//findByNom
	public List<Ingredient> findByNom(String nom) {
		return ingredientRepository.findByNom(nom);
	}
	
	//save = create
	public Ingredient save(Ingredient ingredient) {
		ingredientRepository.save(ingredient);
		return ingredient;
	}
		
	//deleteById
	public void deleteById(int id) {
		ingredientRepository.deleteById(id);
	}
	

	//update
	public void update(Ingredient ingredient) {
		deleteById(ingredient.getId());
		ingredientRepository.save(ingredient);
	}
	
	
	//find or insert ingredient
	public Ingredient findOrInsertIngredient(Ingredient ingredient) {
		return ingredientRepository.findById(ingredient.getId()).orElseGet(() -> ingredientRepository.save(ingredient));
	}
	
}
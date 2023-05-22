package com.projet_recette.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet_recette.entities.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Integer>{
	
	//recherche personnalisée par nom
	List<Ingredient> findByNom(String nom);
}

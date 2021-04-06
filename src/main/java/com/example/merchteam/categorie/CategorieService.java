package com.example.Merchandising.categorie;

import java.util.List;
import java.util.Objects;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class CategorieService {
	private final CategorieRepository categorieRepository;
	
	@Autowired
	public CategorieService(CategorieRepository categorieRepository) {
		this.categorieRepository = categorieRepository;
	}
	public List<Categorie> getCategorie() {
		return categorieRepository.findAll();
	}

	public void ajouterCategorie(Categorie categorie) {
		categorieRepository.save(categorie);
		
	}

	public void supprimerCategorie(Long categorieId) {
		boolean exists =categorieRepository.existsById(categorieId);
		if(!exists) {
			throw new IllegalStateException("category with id"+categorieId+"does not exist");
		}
		categorieRepository.deleteById(categorieId);
		
	}
	// @Transactional
	public Categorie updateCategorie(Long categorieId, Categorie cat) {
		/* Categorie categorie =categorieRepository.findById(categorieId).orElseThrow(()->new IllegalStateException("category with id"+categorieId+"does not exist"));
		if(cat.getNom()!=null && cat.getNom().length() > 0 && !Objects.equals(categorie.getNom(),cat.getNom())) {
			categorie.setNom(cat.getNom());
		} */
		return categorieRepository.findById(categorieId).map(categorie -> {
			if(cat.getNom()!=null && cat.getNom().length() > 0 && !Objects.equals(categorie.getNom(),cat.getNom())) {
				categorie.setNom(cat.getNom());
			}
			return categorieRepository.save(categorie);
		}).orElseThrow(()->new IllegalStateException("category with id"+categorieId+"does not exist"));
	}
	
	public Categorie getCategorieParId(Long categorieId) {
		return categorieRepository.findById(categorieId).orElseThrow(()->new IllegalStateException("category with id"+categorieId+"does not exist"));
	}

}

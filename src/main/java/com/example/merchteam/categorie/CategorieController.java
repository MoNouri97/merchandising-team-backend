package com.example.Merchandising.categorie;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "*" /*"http://localhost:3000"*/)
@RequestMapping(path="/categories")
public class CategorieController {
	private final CategorieService categorieService;
	@Autowired
	public CategorieController(CategorieService categorieService) {
		this.categorieService = categorieService;
	}
	@GetMapping
	public List<Categorie> getCategorie() {
		return  categorieService.getCategorie();
	}
	@GetMapping(path="{categorieId}")
	public Categorie getCategorieParId(@PathVariable("categorieId") Long categorieId) {
		return  categorieService.getCategorieParId(categorieId);
	}
	@PostMapping
	public void ajouterCategorie(@RequestBody Categorie categorie) {
		categorieService.ajouterCategorie(categorie);
	}
	@DeleteMapping(path="{categorieId}")
	public void supprimerCategorie(@PathVariable("categorieId") Long categorieId) {
		categorieService.supprimerCategorie(categorieId);
	}
	@PutMapping("{categorieId}")
	public void updateCategorie(@PathVariable("categorieId") Long categorieId,
							  @RequestBody Categorie categorie) {
		categorieService.updateCategorie(categorieId,categorie);	
	}
}

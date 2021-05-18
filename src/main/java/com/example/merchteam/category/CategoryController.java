package com.example.merchteam.category;

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
@RequestMapping(path = "api/v1/category")
public class CategoryController {
	private final CategoryService categoryService;

	@Autowired
	public CategoryController(CategoryService service) {
		this.categoryService = service;
	}

	@GetMapping
	public List<Category> getAllCategories() {
		return categoryService.getAll();
	}

	@GetMapping(path = "{categoryId}")
	public Category getCategoryParId(@PathVariable("categoryId") Long categoryId) {
		return categoryService.getCategoryParId(categoryId);
	}

	@PostMapping
	public void ajouterCategory(@RequestBody Category category) {
		categoryService.ajouterCategory(category);
	}

	@DeleteMapping(path = "{categoryId}")
	public void supprimerCategory(@PathVariable("categoryId") Long categoryId) {
		categoryService.supprimerCategory(categoryId);
	}

	@PutMapping("{categoryId}")
	public void updateCategory(
		@PathVariable("categoryId") Long categoryId,
		@RequestBody Category category
	) {
		categoryService.updateCategory(categoryId, category);
	}
}

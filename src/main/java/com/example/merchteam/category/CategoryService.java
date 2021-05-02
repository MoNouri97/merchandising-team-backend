package com.example.merchteam.category;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
	private final CategoryRepository categoryRepository;

	@Autowired
	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	public List<Category> getCategory() {
		return categoryRepository.findAll();
	}

	public void ajouterCategory(Category category) {
		categoryRepository.save(category);

	}

	public void supprimerCategory(Long categoryId) {
		boolean exists = categoryRepository.existsById(categoryId);
		if (!exists) {
			throw new IllegalStateException("category with id" + categoryId + "does not exist");
		}
		categoryRepository.deleteById(categoryId);

	}

	// @Transactional
	public Category updateCategory(Long categoryId, Category cat) {
		/*
		 * Category category
		 * =categoryRepository.findById(categoryId).orElseThrow(()->new
		 * IllegalStateException("category with id"+categoryId+"does not exist"));
		 * if(cat.getNom()!=null && cat.getNom().length() > 0 &&
		 * !Objects.equals(category.getNom(),cat.getNom())) {
		 * category.setNom(cat.getNom()); }
		 */
		return categoryRepository.findById(categoryId).map(category -> {
			if (
				cat.getNom() != null && cat.getNom().length() > 0
					&& !Objects.equals(category.getNom(), cat.getNom())
			) {
				category.setNom(cat.getNom());
			}
			return categoryRepository.save(category);
		})
			.orElseThrow(
				() -> new IllegalStateException("category with id" + categoryId + "does not exist")
			);
	}

	public Category getCategoryParId(Long categoryId) {
		return categoryRepository.findById(categoryId)
			.orElseThrow(
				() -> new IllegalStateException("category with id" + categoryId + "does not exist")
			);
	}

}

package com.example.merchteam.article;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;




@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/articles")
public class ArticleController {
	private final ArticleService articleService;
	@Autowired
	public ArticleController(ArticleService articleService) {
		this.articleService = articleService;
	}
	@GetMapping
	public List<Article> getArticle(
		@RequestParam Optional<Long> category,
		@RequestParam Optional<Long> gms
	) {
		if (category.isPresent()) {
			return articleService.getArticleByCategory(category.get());
		}
		if (gms.isPresent()) {
			return articleService.getArticleByGMS(gms.get());
		}
		return articleService.getArticle();
	}
	@GetMapping(path="{articleId}")
	public Article getArticleParId(@PathVariable("articleId") Long articleId) {
		return  articleService.getArticleParId(articleId);
	}
	@PostMapping
	public void addNewArticle(@RequestBody Article article) {
		articleService.addNewArticle(article);
	}
	@DeleteMapping(path="{articleId}")
	public void deleteArticle(@PathVariable("articleId") Long articleId) {
		articleService.deleteArticle(articleId);
	}
	@PutMapping(path="{articleId}")
	public void updateArticle(@PathVariable("articleId") Long articleId,
							  @RequestBody Article article) {
		articleService.updateArticle(articleId,article);
		
	}
}

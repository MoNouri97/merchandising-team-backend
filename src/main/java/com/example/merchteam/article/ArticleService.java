package com.example.merchteam.article;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {
	private final ArticleRepository articleRepository;
	
	@Autowired
	public ArticleService(ArticleRepository articleRepository) {
		this.articleRepository = articleRepository;
	}
	public List<Article> getArticle() {
		return articleRepository.findAll();
	}

	public void addNewArticle(Article article) {
	
		articleRepository.save(article);
		
	}

	public void deleteArticle(Long articleId) {
		boolean exists =articleRepository.existsById(articleId);
		if(!exists) {
			throw new IllegalStateException("article with id"+articleId+"does not exist");
		}
		articleRepository.deleteById(articleId);
		
	}
	//@Transactional
	public Article updateArticle(Long articleId, Article art) {
		//Article article =articleRepository.findById(articleId).orElseThrow(()->new IllegalStateException("article with id"+articleId+"does not exist"));
		//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MMM-yyyy");
		
		/*if(designation!=null && designation.length() > 0 && !Objects.equals(article.getDesignation(),designation)) {
			article.setDesignation(designation);
		}
		
		if(reference!=null && reference.length() > 0 && !Objects.equals(article.getReference(),reference)) {
			article.setReference(reference);
		}
		
		if(type!=null && type.length() > 0 && !Objects.equals(article.getType(),type)) {
			article.setType(type);
		}
		
		if(codeProduit!=null && codeProduit.length() > 0 && !Objects.equals(article.getCodeProduit(),codeProduit)) {
			article.setCodeProduit(codeProduit);
		}
		
		
		if(prix!=null && prix.length() > 0 && !Objects.equals(article.getPrix(),prix)) {
			article.setPrix(prix);
		}
		
		if(poid!=null && poid.length() > 0 && !Objects.equals(article.getPoid(),poid)) {
			article.setPoid(poid);
		}
		
		if(categorie!=null && categorie.length() > 0 && !Objects.equals(article.getCategorie(),categorie)) {
			article.setCategorie(categorie);
		}*/
		return articleRepository.findById(articleId).map(article -> {
			if(art.getDesignation()!=null && art.getDesignation().length() > 0 && !Objects.equals(article.getDesignation(),art.getDesignation())) {
				article.setDesignation(art.getDesignation());
			}
			if(art.getReference()!=null && art.getReference().length() > 0 && !Objects.equals(article.getReference(),art.getReference())) {
				article.setReference(art.getReference());
			}
			if(art.getType()!=null && art.getType().length() > 0 && !Objects.equals(article.getType(),art.getType())) {
				article.setType(art.getType());
			}
			if(art.getCodeProduit()!=null && art.getCodeProduit().length() > 0 && !Objects.equals(article.getCodeProduit(),art.getCodeProduit())) {
				article.setCodeProduit(art.getCodeProduit());
			}
			if(art.getPrix()!=null && art.getPrix().length() > 0 && !Objects.equals(article.getPrix(),art.getPrix())) {
				article.setPrix(art.getPrix());
			}
			if(art.getPoid()!=null && art.getPoid().length() > 0 && !Objects.equals(article.getPoid(),art.getPoid())) {
				article.setPoid(art.getPoid());
			}
			if(art.getCategorie()!=null && art.getCategorie().length() > 0 && !Objects.equals(article.getCategorie(),art.getCategorie())) {
				article.setCategorie(art.getCategorie());
			}
			return articleRepository.save(article);
		}).orElseThrow(()->new IllegalStateException("article with id"+articleId+"does not exist"));
	}
	public Article getArticleParId(Long articleId) {
		return articleRepository.findById(articleId).orElseThrow(()->new IllegalStateException("article with id"+articleId+"does not exist"));
	}

}

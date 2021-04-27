package com.example.merchteam.gms;

import java.util.List;
import java.util.Objects;

import com.example.merchteam.article.Article;
import com.example.merchteam.article.ArticleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GMSService {
	private final GMSRepository gmsRepository;
	private final ArticleRepository articleRepository;
	@Autowired
	public GMSService(GMSRepository gmsRepository, ArticleRepository articleRepository) {
		this.gmsRepository = gmsRepository;
		this.articleRepository = articleRepository;
	}
	public List<GMS> getGMS() {
		return gmsRepository.findAll();
	}

	public GMS getGMSParId(Long gmsId) {
		return gmsRepository.findById(gmsId).orElseThrow(()->new IllegalStateException("GMS with id"+gmsId+"does not exist"));
	}

	public void deleteGMS(Long gmsId) {
		boolean exists =gmsRepository.existsById(gmsId);
		if(!exists) {
			throw new IllegalStateException("GMS with id"+gmsId+"does not exist");
		}
		gmsRepository.deleteById(gmsId);
		
	}

	public GMS updateGMS(Long gmsId, GMS gms) {
		return gmsRepository.findById(gmsId).map(gms_var -> {
			
			if(gms.getName()!=null && gms.getName().length() > 0 && !Objects.equals(gms_var.getName(),gms.getName())) {
				gms_var.setName(gms.getName());
			}
			if(gms.getImage()!=null && gms.getImage().length() > 0 && !Objects.equals(gms_var.getImage(),gms.getImage())) {
				gms_var.setImage(gms.getImage());
			}
			if(gms.getEstimatedTime() > 0 && gms.getEstimatedTime()!=gms_var.getEstimatedTime()) {
				gms_var.setEstimatedTime(gms.getEstimatedTime());
			}
			if(gms.getLongitude()!=gms_var.getLongitude()) {
				gms_var.setLongitude(gms.getLongitude());
			}
			if(gms.getLatitude()!=gms_var.getLatitude()) {
				gms_var.setLatitude(gms.getLatitude());
			}
			
			
			return gmsRepository.save(gms_var);
		}).orElseThrow(()->new IllegalStateException("GMS with id"+gmsId+"does not exist"));
		
	}

	public void addGMS(GMS gms) {
		gmsRepository.save(gms);
		
	}

	public GMS addProductsToGms(Long id, Long[] products) {
		GMS gms = gmsRepository.findById(id).orElseThrow();
		List<Article> articles = articleRepository.findAllById(List.of(products));
		gms.getArticles().addAll(articles);
		return gmsRepository.save(gms);
		// return gms;
	}

}

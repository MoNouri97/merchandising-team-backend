package com.example.merchteam.article;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article,Long> {

	List<Article> findByCategoryId(Long categoryId);

	List<Article> findByGmsListId(Long gmsListId);
}

package com.example.merchteam.repository;

import java.util.Optional;

import com.example.merchteam.model.AppUser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface AppUserRepository<T extends AppUser> extends JpaRepository<T, Long> {
	Optional<T> findByEmail(String email);
}

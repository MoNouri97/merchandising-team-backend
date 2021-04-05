package com.example.merchteam.appUser.repository;

import java.util.Optional;

import com.example.merchteam.appUser.AppUser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository<T extends AppUser> extends JpaRepository<T, Long> {
	Optional<T> findByEmail(String email);
}

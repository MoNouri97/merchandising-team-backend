package com.example.merchteam.appUser;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.merchteam.planning.Planning;
import com.example.merchteam.security.ApplicationUserRole;

@Repository
public interface AppUserRepository<T extends AppUser> extends JpaRepository<T, Long> {
	Optional<T> findByEmail(String email);
	List<AppUser> findByRole(ApplicationUserRole role);
}

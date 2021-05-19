package com.example.merchteam.claimType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClaimTypeRepository extends JpaRepository<ClaimType, Long> {

}

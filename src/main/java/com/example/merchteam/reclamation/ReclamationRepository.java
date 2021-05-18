package com.example.merchteam.reclamation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ReclamationRepository extends JpaRepository<Reclamation, Long> {

}

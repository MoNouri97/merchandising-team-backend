package com.example.merchteam.planning;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


public interface PlanningRepository extends JpaRepository<Planning, Long> {
	Optional<Planning> findPlanningByMerchandiserId(Long id);
	void deletePlanningByMerchandiserId(Long id);
}

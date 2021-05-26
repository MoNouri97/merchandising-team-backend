package com.example.merchteam.report.event;

import java.util.Collection;

import com.example.merchteam.report.event.model.Event;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository<T extends Event> extends JpaRepository<T, Long> {

	@Modifying//for update and insert
	@Query(value = "UPDATE Event SET report_id = ?2 WHERE id IN ?1", nativeQuery = true)
	void updateEvents(Collection<Long> events, Long reportId);

}

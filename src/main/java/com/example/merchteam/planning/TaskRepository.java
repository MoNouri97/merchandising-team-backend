package com.example.merchteam.planning;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface TaskRepository extends JpaRepository<Task,Long>  {
	@Modifying//for update and insert
	@Query(value = "UPDATE task SET planning_id = ?2 WHERE id IN ?1", nativeQuery = true)
	void updateTasks(Collection<Long> tasks, Long planning_id);
	
	
}

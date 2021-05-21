package com.example.merchteam.report.event;

import com.example.merchteam.report.event.model.Event;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository<T extends Event> extends JpaRepository<T, Long> {

}

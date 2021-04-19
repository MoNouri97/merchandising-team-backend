package com.example.merchteam.concurrent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConcurrentRepository extends JpaRepository<Concurrent,Long> {

}

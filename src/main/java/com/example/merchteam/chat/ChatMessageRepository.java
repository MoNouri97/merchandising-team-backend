package com.example.merchteam.chat;

import java.util.Collection;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {

	Page<ChatMessage> findBySenderId(Long senderId, Pageable pageable);

	@Query(
		value = "SELECT m FROM ChatMessage m WHERE m.sender.id = ?1 OR m.receiver.id = ?1 ORDER BY m.id"
	)
	Page<ChatMessage> findByUser(Long userId, Pageable pageable);

	@Query(
		value = "SELECT m FROM ChatMessage m WHERE m.sender.id IN ?1 AND m.receiver.id IN ?1 ORDER BY m.id"
	)
	Page<ChatMessage> findConversation(Collection<Long> ids, Pageable pageable);

}

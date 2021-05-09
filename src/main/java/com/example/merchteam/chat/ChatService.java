package com.example.merchteam.chat;

import java.util.List;

import com.example.merchteam.appUser.AppUser;
import com.example.merchteam.appUser.AppUserRepository;
import com.example.merchteam.chat.ChatController.ChatMessagePayload;
import com.example.merchteam.util.JwtUtil.JwtUserInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class ChatService {
	@Autowired
	private ChatMessageRepository chatMessageRepository;
	@Autowired
	private AppUserRepository<AppUser> userRepository;

	public ChatMessage addChatMessage(ChatMessagePayload msg, Long to) {
		AppUser receiver = userRepository.findById(to)
			.orElseThrow(() -> new IllegalStateException("User with id " + to + " does not exist"));

		AppUser sender = userRepository.findById(msg.getSender())
			.orElseThrow(() -> new IllegalStateException("User with id " + to + " does not exist"));

		ChatMessage saved = chatMessageRepository.save(
			new ChatMessage(msg.getContent(), sender, receiver)
		);
		return saved;
	}

	public Slice<ChatMessage> getLatestMessages(int count, int offset) {
		checkCountOffset(count, offset);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		// FIXME : FOR TESTING ONLY REMOVE THIS
		String email = !(auth instanceof AnonymousAuthenticationToken) ? ((JwtUserInfo) auth
			.getPrincipal()).getUsername() : "merch@spring.co";
		System.out.println("email: " + email);
		// create pagination
		Pageable pageable = PageRequest.of(offset, count);
		// get a page and return a slice (page also includes the nbr of pages -> slower)
		Page<ChatMessage> messages = chatMessageRepository.findByReceiverEmail(email, pageable);

		return messages;

	}

	private void checkCountOffset(int count, int offset) {
		if (count <= 0) {
			throw new IllegalStateException("count must be greater than 0");
		}
		if (offset < 0) {
			throw new IllegalStateException("offset must be greater than or equal to 0");
		}
	}

	public Slice<ChatMessage> getLatestWithId(int count, int offset, Long fromId) {
		checkCountOffset(count, offset);
		JwtUserInfo userInfo = (JwtUserInfo) SecurityContextHolder.getContext()
			.getAuthentication()
			.getPrincipal();

		Pageable pageable = PageRequest.of(offset, count);
		Page<ChatMessage> messages = chatMessageRepository.findConversation(
			List.of(fromId, userInfo.getId()),
			pageable
		);
		return messages;
	}
}

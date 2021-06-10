package com.example.merchteam.chat;

import java.util.HashSet;
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

	public Slice<ChatMessage> getLatestMessages(int count, int page) {
		checkCountPage(count, page);
		JwtUserInfo userInfo = (JwtUserInfo) SecurityContextHolder.getContext()
			.getAuthentication()
			.getPrincipal();

		// FIXME : FOR TESTING ONLY REMOVE THIS
		// String email = !(auth instanceof AnonymousAuthenticationToken) ?
		// ((JwtUserInfo) auth
		// .getPrincipal()).getUsername() : "merch@spring.co";

		// create pagination
		Pageable pageable = PageRequest.of(page, count);
		// get a page and return a slice (page also includes the nbr of pages -> slower)
		Page<ChatMessage> messages = chatMessageRepository.findByUser(userInfo.getId(), pageable);

		return messages;

	}


	public Slice<ChatMessage> getLatestWithId(int count, int page, Long fromId) {
		checkCountPage(count, page);
		JwtUserInfo userInfo = (JwtUserInfo) SecurityContextHolder.getContext()
			.getAuthentication()
			.getPrincipal();

		Pageable pageable = PageRequest.of(page, count);
		HashSet<Long> conversationList = new HashSet<>();
		conversationList.add(fromId);
		if (fromId >= 0) {
			conversationList.add(userInfo.getId());
		}
		Page<ChatMessage> messages = chatMessageRepository.findConversation(
			conversationList,
			pageable
		);
		return messages;
	}

	private void checkCountPage(int count, int page) {
		if (count <= 0) {
			throw new IllegalStateException("count must be greater than 0");
		}
		if (page < 0) {
			throw new IllegalStateException("page must be greater than or equal to 0");
		}
	}
}

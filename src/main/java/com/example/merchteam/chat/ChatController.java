package com.example.merchteam.chat;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Slice;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
// import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Controller
public class ChatController {

	@Autowired
	private ChatService chatService;

	// from the frontend send message to 'app/chat/123'
	@MessageMapping("/chat/{to}")
	// the return statement will be sent to '/topic/messages/123'
	@SendTo("/topic/messages/{to}")
	public ChatMessage sendMessage(
		@DestinationVariable Long to,
		@Payload ChatMessagePayload chatMessage
	) {
		System.out.println("chatMessage: " + chatMessage);
		System.out.println("to: " + to);
		return chatService.addChatMessage(chatMessage, to);
	}

	/**
	 * ChatMessagePayload : the data sent from the front end
	 */
	@Data
	@NoArgsConstructor
	public static class ChatMessagePayload {
		private Long sender;
		private String content;
	}

	@ResponseBody
	@GetMapping(path = "/api/v1/chat")
	public MessageList getLatestMessages(@RequestParam int count, @RequestParam int offset) {
		Slice<ChatMessage> result = chatService.getLatestMessages(count, offset);
		return new MessageList(result.getContent(), !result.isLast());
	}

	@ResponseBody
	@GetMapping(path = "/api/v1/chat/{fromId}")
	public MessageList getLatestMessagesFromId(
		@RequestParam int count,
		@RequestParam int offset,
		@PathVariable Long fromId
	) {
		Slice<ChatMessage> result = chatService.getLatestWithId(count, offset, fromId);
		return new MessageList(result.getContent(), !result.isLast());
	}

	/**
	 * ChatMessagePayload : the data sent from the front end
	 */
	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	public static class MessageList {
		private List<ChatMessage> messages;
		private Boolean more;
	}

}

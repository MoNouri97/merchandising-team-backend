package com.example.merchteam.chat;

import java.sql.Timestamp;
import java.time.Instant;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.example.merchteam.appUser.AppUser;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class ChatMessage {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String content;

	// @JsonIgnoreProperties(value = { "email", "phone", "role", "dob" })
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "sender_id", referencedColumnName = "id")
	private AppUser sender;
	@Transient
	private Long senderId;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "receiver_id", referencedColumnName = "id")
	private AppUser receiver;
	private Timestamp date;

	private String document;

	public ChatMessage(String content, AppUser sender, AppUser receiver) {
		this.content = content;
		this.sender = sender;
		this.receiver = receiver;
		this.date = Timestamp.from(Instant.now());
	}

	public Long getSenderId() {
		return sender.getId();
	}
}

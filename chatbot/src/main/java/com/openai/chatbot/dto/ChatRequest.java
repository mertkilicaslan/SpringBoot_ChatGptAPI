package com.openai.chatbot.dto;

import java.util.ArrayList;
import java.util.List;

import com.openai.chatbot.data.Message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatRequest {
	private String model;
	private List<Message> messages;

	public ChatRequest(String model, String prompt) {
		this.model = model;
		this.messages = new ArrayList<>();
		this.messages.add(new Message("user", prompt));
	}

}
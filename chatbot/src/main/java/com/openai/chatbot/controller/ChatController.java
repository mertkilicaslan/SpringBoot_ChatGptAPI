package com.openai.chatbot.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.openai.chatbot.service.ChatService;

@RestController
@RequestMapping("/chat")
public class ChatController {

	private ChatService service;

	public ChatController(ChatService service) {
		this.service = service;
	}

	@PostMapping("/prompt")
	public String sendMessage(@RequestBody String prompt) {
		return service.sendMessage(prompt);
	}
}
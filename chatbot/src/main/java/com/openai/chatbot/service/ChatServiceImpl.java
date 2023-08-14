package com.openai.chatbot.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.openai.chatbot.dto.ChatRequest;
import com.openai.chatbot.dto.ChatResponse;

@Service
public class ChatServiceImpl implements ChatService {

	@Qualifier("openAiRestTemplate")
	private RestTemplate restTemplate;

	@Value("${openai.model}")
	private String model;

	@Value("${openai.api.url}")
	private String url;

	public ChatServiceImpl(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@Override
	public String sendMessage(String message) {
		ChatRequest chatRequest = new ChatRequest(model, message);
		ChatResponse chatResponse = restTemplate.postForObject(url, chatRequest, ChatResponse.class);

		if (chatResponse != null) {
			return chatResponse.getChoices().get(0).getMessage().getContent();
		} else {
			throw new NullPointerException("There is no message present...");
		}
	}
}
package com.openai.chatbot.dto;

import java.util.List;

import com.openai.chatbot.data.Message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatResponse {
	private List<Choice> choices;

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Choice {
		private int index;
		private Message message;
	}
}
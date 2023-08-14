package com.openai.chatbot.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class OpenAIRestTemplateConfig {

	@Value("${openai.api.key}")
	private String OPENAIAPIKEY;

//a
	@Bean
	@Qualifier("openAiRestTemplate")
	public RestTemplate openAiRestTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getInterceptors().add((request, body, execution) -> {
			request.getHeaders().add("Authorization", "Bearer " + OPENAIAPIKEY);
			return execution.execute(request, body);
		});
		return restTemplate;
	}
}
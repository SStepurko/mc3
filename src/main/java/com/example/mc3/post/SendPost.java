package com.example.mc3.post;

import com.example.mc3.kafka.Message;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * RestTemplate sends POST with the message to mc1
 */
@Component
public class SendPost {

	public static void sendMessage(Message message) {
		RestTemplate restTemplate = new RestTemplate();
		String resourceUrl = "http://172.17.0.1:10001/api";
		HttpEntity<Message> request = new HttpEntity<>(message);
		restTemplate.exchange(
				resourceUrl,
				HttpMethod.POST,
				request,
				Void.class
		);
	}
}

package com.example.mc3.post;

import com.example.mc3.kafka.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * RestTemplate sends POST with the message to mc1
 */
@Component
public class SendPost {

	@Value(value = "${mc1}")
	private static String mc1;

	public static void sendMessage(Message message) {
		RestTemplate restTemplate = new RestTemplate();
		String resourceUrl = mc1;
		HttpEntity<Message> request = new HttpEntity<>(message);
		restTemplate.exchange(
				resourceUrl,
				HttpMethod.POST,
				request,
				Void.class
		);
	}
}

package com.example.mc3.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

	@KafkaListener(topics = "MyTopic", groupId = "group_id")
	public void consume(String message) {
		System.out.println(message);
	}
}

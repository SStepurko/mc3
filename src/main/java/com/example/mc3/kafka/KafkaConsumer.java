package com.example.mc3.kafka;

import com.example.mc3.post.SendPost;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

	@KafkaListener(topics = "MyTopic", groupId = "group_id", containerFactory = "messageListener")
	public void consume(Message message) {
		Message mc3Message = MessageService.updateMessage(message);
		System.out.println(mc3Message);
//		send POST
		SendPost.sendMessage(message);


	}
}

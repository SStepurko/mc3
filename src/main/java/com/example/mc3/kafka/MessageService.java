package com.example.mc3.kafka;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MessageService {
	public static Message updateMessage(Message message) {
		message.setMc3Timestamp(new Date(System.currentTimeMillis()));
		return message;
	}
}

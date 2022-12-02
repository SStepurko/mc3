package com.example.mc3.kafka;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Update time stamp for mc3
 */
@Component
public class MessageService {
	public static Message updateMessage(Message message) {
		message.setMc3Timestamp(new Date(System.currentTimeMillis()));
		return message;
	}
}

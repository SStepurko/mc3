package com.example.mc3.kafka;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

//@EnableKafka
@Configuration
public class KafkaConfig {

	@Bean
	public ConsumerFactory<String, Message> consumerFactory() {
		Map<String, Object> config = new HashMap<>();
		config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		config.put(ConsumerConfig.GROUP_ID_CONFIG, "myGroup");
		config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
		config.put(JsonDeserializer.TYPE_MAPPINGS, "msg:com.example.mc3.kafka.Message");
//		config.put(JsonDeserializer.VALUE_CLASS_NAME_CONFIG, McMessage.class);
		config.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
		return new DefaultKafkaConsumerFactory<>(
				config,
				new StringDeserializer(),
				new JsonDeserializer<>(Message.class));
//		return new DefaultKafkaConsumerFactory<>(config);
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, Message> messageListener() {
		ConcurrentKafkaListenerContainerFactory<String, Message> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(consumerFactory());
		return factory;
	}
//	@Bean
//	public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, McMessage>> factory(ConsumerFactory<String, McMessage> consumerFactory) {
//		ConcurrentKafkaListenerContainerFactory<String, McMessage> factory = new ConcurrentKafkaListenerContainerFactory<>();
//		factory.setConsumerFactory(consumerFactory);
//		return factory;
//	}
}

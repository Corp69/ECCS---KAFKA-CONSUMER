package com.mx.kafka.cliente.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class StrConsumerListener {

	@KafkaListener(
			topicPartitions = @TopicPartition(topic = "str-topic", partitions = {"0"}),
			groupId = "group-1",
			containerFactory = "validMessageContainerFactory"
	)
	public void listener1(String message) {
		log.info("LISTENER 1 :::  Recibiendo un mensaje {} ", message);
	}
	
	@KafkaListener(
			topicPartitions = @TopicPartition(topic = "str-topic", partitions = {"1"}),
			groupId = "group-1",
			containerFactory = "validMessageContainerFactory"
	)
	public void listener2(String message) {
		log.info("LISTENER 2 :::  Recibiendo un mensaje {} ", message);
	}
	
	@KafkaListener(
			groupId = "group-2", 
			topics = "str-topic", 
			containerFactory = "validMessageContainerFactory"
	)
	public void listener3(String message) {
		log.info("LISTENER 3 :::  Recibiendo un mensaje {} ", message);
	}
	
}
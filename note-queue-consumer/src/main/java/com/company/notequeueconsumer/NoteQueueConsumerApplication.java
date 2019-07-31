package com.company.notequeueconsumer;

import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class NoteQueueConsumerApplication {

	public static final String TOPIC_EXCHANGE_NAME = "note-exchange";
	public static final String QUEUE_NAME = "note-list-add-queue";
	public static final String ROUTING_KEY = "note.list.add.#";

	@Bean
	org.springframework.amqp.core.Queue queue() {
		return new org.springframework.amqp.core.Queue(QUEUE_NAME, false);
	}

	@Bean
	TopicExchange exchange() {
		return new TopicExchange(TOPIC_EXCHANGE_NAME);
	}
	@Bean
	Binding binding(Queue queue, TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
	}
	@Bean
	public Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
		return new Jackson2JsonMessageConverter();
	}


	public static void main(String[] args) {
		SpringApplication.run(NoteQueueConsumerApplication.class, args);
	}

	}



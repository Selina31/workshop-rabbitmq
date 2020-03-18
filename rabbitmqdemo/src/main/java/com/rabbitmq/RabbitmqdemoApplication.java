package com.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RabbitmqdemoApplication implements CommandLineRunner {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	public static void main(String[] args) {
		SpringApplication.run(RabbitmqdemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		SimpleMessage simpleMessage = new SimpleMessage();
		simpleMessage.setName("FirstMessage");
		simpleMessage.setDescription("SimpleDescription");
//		rabbitTemplate.convertAndSend("Hello from our first message!");
//		rabbitTemplate.convertAndSend("TestExchange",
//				"testRouting", "Hello from code");
//		rabbitTemplate.convertAndSend("TestExchange",
//				"testRouting", simpleMessage
//		);
		rabbitTemplate.convertAndSend("MyTopicExchange",
				"topic", simpleMessage);

	}
}

package br.com.send.message.sqs.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.send.message.sqs.config.ServletInitializer;

@SpringBootApplication(scanBasePackageClasses = { ServletInitializer.class })
public class SendMessageApplication {

	public static void main(String[] args) {
		SpringApplication.run(SendMessageApplication.class, args);
	}
}

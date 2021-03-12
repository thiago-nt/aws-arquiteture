package br.com.receive.message.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.receive.message.config.ServletInitializer;

@SpringBootApplication(scanBasePackageClasses = { ServletInitializer.class })
public class ReceiverMessageApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(ReceiverMessageApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(ReceiverMessageApplication.class, args);
		LOGGER.info("Springboot with amazonsqs application started successfully.");
	}

}

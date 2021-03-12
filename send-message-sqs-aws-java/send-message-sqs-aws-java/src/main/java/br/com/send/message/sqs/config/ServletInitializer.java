package br.com.send.message.sqs.config;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import br.com.send.message.sqs.application.SendMessageApplication;

@Configuration
@ComponentScan(basePackages = {
		"br.com.send.message.sqs.controller",
		"br.com.send.message.sqs.service.impl",
		"br.com.send.message.sqs.config",
} )
public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SendMessageApplication.class);
	}

}

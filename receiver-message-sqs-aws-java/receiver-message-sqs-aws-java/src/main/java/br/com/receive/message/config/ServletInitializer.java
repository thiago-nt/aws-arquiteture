package br.com.receive.message.config;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import br.com.receive.message.application.ReceiverMessageApplication;

@Configuration
@ComponentScan(basePackages = {
		"br.com.receive.message.sqs",
		"br.com.receive.message.service.impl",
} )
public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ReceiverMessageApplication.class);
	}

}

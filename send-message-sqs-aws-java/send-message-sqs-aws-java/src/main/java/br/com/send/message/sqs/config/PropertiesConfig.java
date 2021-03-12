package br.com.send.message.sqs.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Component
@Configuration
@AllArgsConstructor
@RequiredArgsConstructor
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "send-properties")
public class PropertiesConfig {

	private String regionSqsAws;

	private String awsAccessKey;

	private String awsSecretKey;

	private String awsQueue;
}

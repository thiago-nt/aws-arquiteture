package br.com.send.message.sqs.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.services.sqs.AmazonSQSAsync;

import br.com.send.message.sqs.config.PropertiesConfig;
import br.com.send.message.sqs.service.SendMessageSQS;

@Service
public class SendMenssageSQSImpl implements SendMessageSQS {

	@Autowired
	private PropertiesConfig properties;
	public static final Logger LOGGER = LoggerFactory.getLogger(SendMenssageSQSImpl.class);
	    
	@Autowired
    private AmazonSQSAsync amazonSQSAsync;
	
	@Override
	public void sendMessageSqsAws(String body) throws Exception {
        LOGGER.info("Sending the message to the Amazon sqs.");
        amazonSQSAsync.sendMessage(properties.getAwsQueue(), body);
        LOGGER.info("Message sent successfully to the Amazon sqs.");
    }

}

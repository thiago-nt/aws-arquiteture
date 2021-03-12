package br.com.receive.message.config;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.amazon.sqs.javamessaging.ProviderConfiguration;
import com.amazon.sqs.javamessaging.SQSConnection;
import com.amazon.sqs.javamessaging.SQSConnectionFactory;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;

import br.com.receive.message.sqs.SqsReceiveMessage;

@Configuration
public class SqsConfig {

	@Autowired
	private PropertiesConfig properties;
	
	@Autowired
	SqsReceiveMessage receiveMessage;
	
	@Bean
	@Primary
	public AmazonSQSAsync amazonSQSAsync() {
		try {
			SQSConnectionFactory connectionFactory = new SQSConnectionFactory(
			        new ProviderConfiguration(),
			        AmazonSQSClientBuilder.standard().withRegion(properties.getRegionSqsAws()).withCredentials(
							new AWSStaticCredentialsProvider(new BasicAWSCredentials(properties.getAwsAccessKey(), properties.getAwsSecretKey()))).build()
			        );
			 
			SQSConnection connection = connectionFactory.createConnection();
			
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			Queue queue = session.createQueue(properties.getAwsQueue());
			MessageConsumer consumer = session.createConsumer(queue);
			
			consumer.setMessageListener(new MyListener());
			connection.start();
			
			Thread.sleep(1000);
		} catch (JMSException e) {
			e.printStackTrace();
		} catch (InterruptedException i) {
			i.printStackTrace();
		}
		return null;
	}
	
	class MyListener implements MessageListener {
	    @Override
	    public void onMessage(Message message) {
	        try {
	            System.out.println("Received: " + ((TextMessage) message).getText());
	            receiveMessage.getMessageFromSqs(((TextMessage) message).getText());
	        } catch (JMSException e) {
	            e.printStackTrace();
	        }
	    }
	}
}

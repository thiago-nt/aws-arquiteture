package br.com.receive.message.sqs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import br.com.receive.message.model.ObjectModel;
import br.com.receive.message.service.impl.ProcessoRestServiceImpl;

@Service
public class SqsReceiveMessage {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(SqsReceiveMessage.class);
	
	@Autowired
	private ProcessoRestServiceImpl processoRestServiceImpl;

	public void getMessageFromSqs(String mensage) {
		try {
			LOGGER.info("getMessageFromSqs message= {} with messageId= {}", mensage);
			Gson gson = new Gson();
			ObjectModel objectModel = gson.fromJson(mensage , ObjectModel.class);
			ResponseEntity<ObjectModel> response = processoRestServiceImpl.processRest(objectModel);
			ObjectModel responseType = response.getBody();
			System.out.println(responseType);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

package br.com.receive.message.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.receive.message.config.PropertiesConfig;
import br.com.receive.message.model.ObjectModel;
import br.com.receive.message.service.ProcessoRestService;

@Service
public class ProcessoRestServiceImpl implements ProcessoRestService {

	@Autowired
	private PropertiesConfig properties;
	
	@Override
	public ResponseEntity<ObjectModel> processRest(ObjectModel objectModel) throws Exception {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<ObjectModel> request = new HttpEntity<>(objectModel, headers);
		ResponseEntity<ObjectModel> response = restTemplate.postForEntity(properties.getUrlRest(), request, ObjectModel.class);
		return response;
	}

}

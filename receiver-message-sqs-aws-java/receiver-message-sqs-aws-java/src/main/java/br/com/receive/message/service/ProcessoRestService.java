package br.com.receive.message.service;

import org.springframework.http.ResponseEntity;

import br.com.receive.message.model.ObjectModel;

public interface ProcessoRestService {

	ResponseEntity<ObjectModel> processRest(ObjectModel objectModel) throws Exception;

}

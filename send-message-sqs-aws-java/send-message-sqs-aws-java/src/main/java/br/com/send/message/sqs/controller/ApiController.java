package br.com.send.message.sqs.controller;

import java.util.Date;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.google.gson.Gson;

import br.com.send.message.sqs.model.Create;
import br.com.send.message.sqs.model.CreateResponse;
import br.com.send.message.sqs.service.SendMessageSQS;

public class ApiController implements SendSqsApi {

	
	@Autowired
	private SendMessageSQS sendMenssageSQS;
	
	@Override
	public CompletableFuture<ResponseEntity<CreateResponse>>
			create(Create body) {
		try {
			Gson gson = new Gson();
			System.out.println("LOG criar: " + new Date() + " [" + gson.toJson(body) + " ]");
			CreateResponse criarResponse = new CreateResponse();
			if (Objects.isNull(body)) {
				criarResponse.codigo("2");
				criarResponse.descricao("Parâmetros inválidos.");
				return CompletableFuture.completedFuture(new ResponseEntity<>(criarResponse, HttpStatus.BAD_REQUEST));
			}
			String bodyJson = gson.toJson(body);
			sendMenssageSQS.sendMessageSqsAws(bodyJson);
			
			if (criarResponse != null && criarResponse.getCodigo().equals("2")) {
				criarResponse.codigo(criarResponse.getCodigo());
				criarResponse.descricao(criarResponse.getDescricao());
				return CompletableFuture.completedFuture(new ResponseEntity<>(criarResponse, HttpStatus.BAD_REQUEST));
			} else if (criarResponse != null && criarResponse.getCodigo() != "0") {
				criarResponse.codigo(criarResponse.getCodigo());
				criarResponse.descricao(criarResponse.getDescricao());
				return CompletableFuture.completedFuture(new ResponseEntity<>(criarResponse, HttpStatus.INTERNAL_SERVER_ERROR));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return CompletableFuture.completedFuture(new ResponseEntity<>(null, HttpStatus.OK));
	}
}

package br.com.receive.message.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ObjectModel {
	
	@JsonProperty("codigo")
	private String codigo = null;

	@JsonProperty("descricao")
	private String descricao = null;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}

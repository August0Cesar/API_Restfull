package br.com.augusto.api_teste.model;

import java.util.Date;

public class Vehicle {
	private Long id;
	private String nome;
	private String estado;
	private String cor;
	private Date dataFabricacao;
	private String type;

	public Vehicle() {
	}

	public Vehicle(Long id, String nome, String estado, String cor, Date dataFabricacao, String type) {
		this.id = id;
		this.nome = nome;
		this.estado = estado;
		this.cor = cor;
		this.dataFabricacao = dataFabricacao;
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public Date getDataFabricacao() {
		return dataFabricacao;
	}

	public void setDataFabricacao(Date dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}

}

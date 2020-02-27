package br.com.augusto.api_teste.model;

import java.util.Date;

import br.com.augusto.api_teste.model.request.CarRequest;

public class CarSedan extends Vehicle {
	private Boolean automatic;

	public CarSedan() {
		super();
	}

	public CarSedan(Long id, String nome, String estado, String cor, Date dataFabricacao, String type,Boolean automatic) {
		super(id, nome, estado, cor, dataFabricacao, type);
		this.automatic = automatic;
	}

	public CarSedan(CarRequest carRequest) {
		super(null, carRequest.getNome(), carRequest.getEstado(), carRequest.getCor(), carRequest.getDataFabricacao(),
				carRequest.getType());
		this.automatic = carRequest.getAutomatic();
	}

	public Boolean getAutomatic() {
		return automatic;
	}

	public void setAutomatic(Boolean automatic) {
		this.automatic = automatic;
	}

}
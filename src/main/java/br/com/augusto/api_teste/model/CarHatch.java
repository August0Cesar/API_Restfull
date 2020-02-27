package br.com.augusto.api_teste.model;

import java.util.Date;

import br.com.augusto.api_teste.model.request.CarRequest;

public class CarHatch extends Vehicle {

	public CarHatch() {
		super();
	}

	public CarHatch(Long id, String nome, String estado, String cor, Date dataFabricacao, String type) {
		super(id, nome, estado, cor, dataFabricacao, type);
	}

	public CarHatch(CarRequest carRequest) {
		super(null, carRequest.getNome(), carRequest.getEstado(), 
				carRequest.getCor(), carRequest.getDataFabricacao(),
				carRequest.getType());
	}

}
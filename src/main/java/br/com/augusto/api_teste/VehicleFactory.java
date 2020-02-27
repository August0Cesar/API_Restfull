package br.com.augusto.api_teste;

import br.com.augusto.api_teste.model.CarHatch;
import br.com.augusto.api_teste.model.CarSedan;
import br.com.augusto.api_teste.model.Vehicle;
import br.com.augusto.api_teste.model.request.CarRequest;

public final class VehicleFactory {
	private VehicleFactory() {}
	
	public static Vehicle createVehicle(CarRequest carRequest) {
		Vehicle vehicle = null;
		
		if("Hatch".equals(carRequest.getType())) {
			vehicle =  new CarHatch(carRequest);
		}else if("Sedan".equals(carRequest.getType())){
			vehicle = new CarSedan(carRequest);
		}else {
			return null;
		}
		return vehicle;
	}

}

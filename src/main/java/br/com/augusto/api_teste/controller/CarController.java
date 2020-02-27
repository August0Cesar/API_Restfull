package br.com.augusto.api_teste.controller;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.augusto.api_teste.VehicleFactory;
import br.com.augusto.api_teste.exceptions.CarNotFoundException;
import br.com.augusto.api_teste.model.CarHatch;
import br.com.augusto.api_teste.model.CarSedan;
import br.com.augusto.api_teste.model.Vehicle;
import br.com.augusto.api_teste.model.request.CarRequest;
import br.com.augusto.api_teste.model.response.CarResponse;

@RestController
@RequestMapping("/api/v1/carros")
public class CarController {
	private static final Logger LOGGER = LogManager.getLogger(CarController.class);
	
	private static List<Vehicle> carros = Arrays.asList(new CarHatch(1L, "Jeep Renagate", "SP", "Branco", new Date(),"Hatch"),
			new CarHatch(10L, "Renault Sandero", "SP", "Preto", new Date(),"Hatch"),
			new CarSedan(188L, "Arrizo 5", "US", "Blue", Calendar.getInstance().getTime(), "Sedan",false),
			new CarHatch(2L, "Fiat Punto", "MG", "Cinza", new Date(),"Hatch"),
			new CarHatch(3L, "Fiat Toro", "AM", "Vermelho", new Date(),"Hatch"),
			new CarSedan(188L, "Sedã grande Honda Accord", "AM", "Cinza", Calendar.getInstance().getTime(), "Sedan",true));

	@GetMapping
	public ResponseEntity<List<CarResponse>> getAllCar() {
		
		LOGGER.info("Buscando carros ...");
		return new ResponseEntity<List<CarResponse>>(CarResponse.getCars(carros), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CarResponse> getCarById(@PathVariable(value = "id") Long carId) throws CarNotFoundException {
		LOGGER.info("Buscando carro pelo id => " + carId);
		CarResponse response = CarResponse.getCarById(carros,carId);
		if(response != null) {
			return new ResponseEntity<CarResponse>(response, HttpStatus.OK);
		}
		
		throw new CarNotFoundException("Vehicle not found.");
	}

	@PostMapping
	public ResponseEntity<CarResponse> createCar(@RequestBody CarRequest carRequest) throws CarNotFoundException {
		
		Vehicle vehicle = VehicleFactory.createVehicle(carRequest);
		if(vehicle == null) {
			throw new CarNotFoundException("Not find type of vehicle for " + carRequest.getType() + ".");
		}
		
		CarResponse response = new CarResponse(vehicle);
		response.setId(1111L);
		
		return new ResponseEntity<CarResponse>(response, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<CarHatch> updateCar(@PathVariable(value = "id") Long carId, @Valid @RequestBody CarHatch cardetalhes) {
		
		return new ResponseEntity<CarHatch>(cardetalhes, HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<CarHatch> deleteCar(@PathVariable(value = "id") Long carId) {
		return ResponseEntity.ok().build();
	}

}

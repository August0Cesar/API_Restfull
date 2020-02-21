package br.com.augusto.api_teste.controller;

import java.util.Arrays;
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

import br.com.augusto.api_teste.model.Car;
import br.com.augusto.api_teste.model.response.CarResponse;

@RestController
@RequestMapping("/api/v1/carros")
public class CarController {
	private static final Logger LOGGER = LogManager.getLogger(CarController.class);
	
	private static List<Car> carros = Arrays.asList(new Car(1L, "Jeep Renagate", "SP", "Branco", new Date()),
			new Car(10L, "Renault Sandero", "SP", "Preto", new Date()),
			new Car(2L, "Fiat Punto", "MG", "Cinza", new Date()),
			new Car(3L, "Fiat Toro", "AM", "Vermelho", new Date()));

	@GetMapping
	public ResponseEntity<List<CarResponse>> getAllCar() {
		
		LOGGER.info("Buscando carros ...");
		return new ResponseEntity<List<CarResponse>>(CarResponse.getCars(carros), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CarResponse> getCarById(@PathVariable(value = "id") Long carId) {
		LOGGER.info("Buscando carro pelo id => " + carId);
		return new ResponseEntity<CarResponse>(CarResponse.getCarById(carros,carId), HttpStatus.OK);
	}

	@PostMapping
	public Car createCar(@RequestBody Car car) {

		return null;
	}

	@PutMapping("/{id}")
	public ResponseEntity<Car> updateCar(@PathVariable(value = "id") Long carId, @Valid @RequestBody Car cardetalhes) {
		
		return new ResponseEntity<Car>(cardetalhes, HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Car> deleteCar(@PathVariable(value = "id") Long carId) {
		return ResponseEntity.ok().build();
	}

}

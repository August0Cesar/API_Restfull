package br.com.augusto.api_teste.model.response;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import br.com.augusto.api_teste.model.Car;

public class CarResponse {
	private Long id;
	private String nome;
	private String estado;
	private String cor;
	private String dataFabricacao;

	public CarResponse(Car car) {
		this.id = car.getId();
		this.cor = car.getCor();
		this.nome = car.getNome();
		this.estado = car.getEstado();
		this.dataFabricacao = formataDate(car.getDataFabricacao());
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

	public String getDataFabricacao() {
		return dataFabricacao;
	}

	public void setDataFabricacao(String dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}

	public static List<CarResponse> getCars(List<Car> carros) {
		List<CarResponse> carrosResponse = new ArrayList<>();

		carros.forEach(car -> carrosResponse.add(new CarResponse(car)));
		return carrosResponse;
	}

	static public String formataDate(Date data) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(data);
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		return format.format(calendar.getTime()).replaceAll("/", "-");
	}

	public static CarResponse getCarById(List<Car> carros, Long carId) {
		Optional<Car> optional = carros.stream().filter(c -> c.getId() == carId).findFirst();
		if (!optional.isPresent()) {
			return null;
		}
		return new CarResponse(optional.get());
	}
}

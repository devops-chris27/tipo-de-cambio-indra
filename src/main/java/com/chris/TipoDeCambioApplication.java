package com.chris;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.chris.entidad.TipoDeCambio;

@SpringBootApplication
public class TipoDeCambioApplication {

	public static void main(String[] args) {
		SpringApplication.run(TipoDeCambioApplication.class, args);
		
		TipoDeCambio tipoDeCambio= new TipoDeCambio();
		
		tipoDeCambio.setMonedaDestino("Dolares");
		tipoDeCambio.setMonedaOrigen("Soles");
		tipoDeCambio.setMonto(100.0);
		tipoDeCambio.setMontoTipoDeCambio(400.0);
		tipoDeCambio.setTipoDeCambio(4.0);
		
		System.out.println("objeto: " + tipoDeCambio);
		
		
	}

}

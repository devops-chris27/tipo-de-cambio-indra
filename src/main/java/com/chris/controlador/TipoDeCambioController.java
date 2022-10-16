package com.chris.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chris.dao.ITipoDeCambioDao;
import com.chris.entidad.TipoDeCambio;

@RestController
@RequestMapping("/api")
public class TipoDeCambioController {
	
	@Autowired
	ITipoDeCambioDao iTipoDeCambioDao; 
	
	//1.- Listar la data el H2 del objeto TipoDeCambio
	
	@GetMapping("/tipodecambios")
	public List<TipoDeCambio> getTipoDeCambios(){
		
		return iTipoDeCambioDao.findAll();
	}
	
	//2.- ingresar los valores de monedaOrigen, monedaDestino y monto.
	//como ejemplo puse 3 monedas: dolar euro y yen.
	
	@PostMapping("/tipodecambios")
	public TipoDeCambio TipoDeCambio(@RequestBody TipoDeCambio tipoDeCambio) {
		
		TipoDeCambio miTipoDeCambio = new TipoDeCambio();
		
		switch(tipoDeCambio.getMonedaDestino()) {
			
		case "dolar":
			if(tipoDeCambio.getMonedaOrigen().equals("soles")  ) {
				tipoDeCambio.setTipoDeCambio(4.00);
				Double conversionDolar = (4.00 *tipoDeCambio.getMonto()); 
				tipoDeCambio.setMontoTipoDeCambio(conversionDolar);				
				
				System.out.println("La convesion es: " + conversionDolar);
				return iTipoDeCambioDao.save(tipoDeCambio);
				
			}else if(tipoDeCambio.getMonedaOrigen().equals("euro")) {
				tipoDeCambio.setTipoDeCambio(0.97);
				Double conversionEuro = (0.97 *tipoDeCambio.getMonto()); 
				tipoDeCambio.setMontoTipoDeCambio(conversionEuro);
				return iTipoDeCambioDao.save(tipoDeCambio);
				
			}else if(tipoDeCambio.getMonedaOrigen().equals("yen")) {
				tipoDeCambio.setTipoDeCambio(0.0067);
				Double conversionYen = (0.0067 *tipoDeCambio.getMonto()); 
				tipoDeCambio.setMontoTipoDeCambio(conversionYen);
				return iTipoDeCambioDao.save(tipoDeCambio);
				
			}else {
				return null;
				
			}
			
			
			
		case "euro":
			
			if(tipoDeCambio.getMonedaOrigen().equals("soles")  ) {
				tipoDeCambio.setTipoDeCambio(3.85);
				Double conversionSoles = (3.85 *tipoDeCambio.getMonto()); 
				tipoDeCambio.setMontoTipoDeCambio(conversionSoles);				
				
				System.out.println("La convesion es: " + conversionSoles);
				return iTipoDeCambioDao.save(tipoDeCambio);
				
			}else if(tipoDeCambio.getMonedaOrigen().equals("dolar")) {				
				tipoDeCambio.setTipoDeCambio(0.97);
				Double conversionEuro = (0.97 *tipoDeCambio.getMonto()); 
				tipoDeCambio.setMontoTipoDeCambio(conversionEuro);
				return iTipoDeCambioDao.save(tipoDeCambio);
				
			}else if(tipoDeCambio.getMonedaOrigen().equals("yen")) {
				tipoDeCambio.setTipoDeCambio(142.52);
				Double conversionYen = (142.52 *tipoDeCambio.getMonto()); 
				tipoDeCambio.setMontoTipoDeCambio(conversionYen);
				return iTipoDeCambioDao.save(tipoDeCambio);
				
			}else {
				return null;
				
			}
			
			
	
	case "yen":
			
			if(tipoDeCambio.getMonedaOrigen().equals("soles")  ) {
				tipoDeCambio.setTipoDeCambio(37.57);
				Double conversionSoles = (37.57 *tipoDeCambio.getMonto()); 
				tipoDeCambio.setMontoTipoDeCambio(conversionSoles);				
				
				System.out.println("La convesion es: " + conversionSoles);
				return iTipoDeCambioDao.save(tipoDeCambio);
			}else if(tipoDeCambio.getMonedaOrigen().equals("dolar")) {
				tipoDeCambio.setTipoDeCambio(0.97);
				Double conversionDolar = (0.97 *tipoDeCambio.getMonto()); 
				tipoDeCambio.setMontoTipoDeCambio(conversionDolar);
				return iTipoDeCambioDao.save(tipoDeCambio);
				
			}else if(tipoDeCambio.getMonedaOrigen().equals("euro")) {
				tipoDeCambio.setTipoDeCambio(142.52);
				Double conversionYen = (142.52 *tipoDeCambio.getMonto()); 
				tipoDeCambio.setMontoTipoDeCambio(conversionYen);
				return iTipoDeCambioDao.save(tipoDeCambio);
				
			}else {
				return null;
				
			}			
			
			
			
		default:
			System.out.println("Seleccione un tipo de moneda valido");
			break;
		
		}	
		
		System.out.println("Objeto tipoDeCambio: " + tipoDeCambio);
		
		return null;
		
	}
	
	
	
	//acualizar el tipo de cambio.
	
	//tomar le id del un objeto de tipodeCambio
	
	@GetMapping("/tipodecambios/{id}")
	public TipoDeCambio tipoDeCambioXID(@PathVariable(name="id") Long id) {
		
		TipoDeCambio tipoDeCambioXID = new TipoDeCambio();
		
		tipoDeCambioXID = iTipoDeCambioDao.findById(id).get();
		
		
		System.out.println("Objeto tipoDeCambio Seleccionado" + tipoDeCambioXID);
		return tipoDeCambioXID;
	}
	
	//actualizar el valor de tipo de cambio.
	@PutMapping("/tipodecambios/{id}")
	public TipoDeCambio actualizarTipoDeCambio(@PathVariable(name = "id") Long id, @RequestBody TipoDeCambio tipoDeCambio ) {
		
		TipoDeCambio tipoDeCambioSeleccionado = new TipoDeCambio();	
		
		
		tipoDeCambioSeleccionado = iTipoDeCambioDao.findById(id).get();
		
		tipoDeCambioSeleccionado.setTipoDeCambio(tipoDeCambio.getTipoDeCambio());
		
		return iTipoDeCambioDao.save(tipoDeCambioSeleccionado);
	}
	
	//eliminar un objeto de tipo de cambio.
	
	@DeleteMapping("/tipodecambios/{id}")
	public void eliminarTipoDeCambio(@PathVariable(name = "id") Long id) {
		
		iTipoDeCambioDao.deleteById(id);
	}
	
	
	
	
	
	
	
	
	
	
	

}

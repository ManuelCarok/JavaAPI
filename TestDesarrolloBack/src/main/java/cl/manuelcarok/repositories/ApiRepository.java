package cl.manuelcarok.repositories;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import cl.manuelcarok.model.Poemas;

public class ApiRepository {
	
	public String getNombreApellido(String nombre) {
		String result = "";
		String[] nombreArray = nombre.split(" ");
		if(nombreArray.length > 0) {
			String primerNombre = nombreArray[0];
			String primerApellido = nombreArray[nombreArray.length -2];
			result = primerNombre + " " + primerApellido;
		} 
		return result;
	}
	
	public String getEdad(String fecha) {
		LocalDate hoy = LocalDate.now();
		LocalDate nacimiento = LocalDate.parse(fecha, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		Period edad = Period.between(nacimiento, hoy);
		return String.valueOf(edad.getYears());
	}
	
	public String getDias(String fecha) {
		
		String resul = "";
		
		LocalDate hoy = LocalDate.now();
		LocalDate nacimiento = LocalDate.parse(fecha, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		LocalDate proximoDia = nacimiento.withYear(hoy.getYear());
		
		if (proximoDia.isBefore(hoy) || proximoDia.isEqual(hoy)) {
			proximoDia = proximoDia.plusYears(1);
        }
		
        long totalDias = ChronoUnit.DAYS.between(hoy, proximoDia);

        if ((hoy.getYear() % 4 == 0) && ((hoy.getYear() % 100 != 0) || (hoy.getYear() % 400 == 0)))
        {
        	if (totalDias == 366) {
           		resul = "Felicidades!! un poema por tu cumpleaños: " + getPoema();
        	} else {
            	resul = String.valueOf(totalDias);
        	}
        } else {
        	if (totalDias == 365) {
          		resul = "Felicidades!! un poema por tu cumpleaños: " + getPoema();
        	} else {
        		resul = String.valueOf(totalDias);
            }
        }
		return resul;
	}
	
	private String getPoema() {
		RestTemplate rest = new RestTemplate();
  		UriComponents uri = UriComponentsBuilder.newInstance()
  			.scheme("https")
  			.host("www.poemist.com").
  			path("api/v1/randompoems")
				.build();
  		
  		ResponseEntity<Poemas[]> restPoemas = rest.getForEntity(uri.toUriString(), Poemas[].class);
  		
  		return restPoemas.getBody()[0].getContent();
	}
}

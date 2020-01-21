package cl.manuelcarok.rest;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import cl.manuelcarok.model.Persona;
import cl.manuelcarok.model.Poemas;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class ApiRestController {
	
	@GetMapping
	public String Init() {
		return "Bienvenidos a la API";
	}
	
	@PostMapping
	public Map<String, String> getPersona(@RequestBody Persona person) {
		
		HashMap<String, String> map = new HashMap<>();  
	  
		String[] nombreArray = person.getNombre().split(" ");
		if(nombreArray.length > 0) {
			String primerNombre = nombreArray[0];
			String primerApellido = nombreArray[nombreArray.length -2];
			map.put("nombre", primerNombre + " " + primerApellido);
		} else {
			map.put("nombre", "");
		}
		
		LocalDate hoy = LocalDate.now();
		LocalDate cumple = LocalDate.parse(person.getFecha(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		LocalDate proximoDia = cumple.withYear(hoy.getYear());
		
		Period edad = Period.between(cumple, hoy);
		map.put("edad", String.valueOf(edad.getYears()));
		
		if (proximoDia.isBefore(hoy) || proximoDia.isEqual(hoy)) {
			proximoDia = proximoDia.plusYears(1);
        }
		 
        long totalDias = ChronoUnit.DAYS.between(hoy, proximoDia);

        if ((hoy.getYear() % 4 == 0) && ((hoy.getYear() % 100 != 0) || (hoy.getYear() % 400 == 0)))
        	 if (totalDias == 366) {
              	RestTemplate rest = new RestTemplate();
           		UriComponents uri = UriComponentsBuilder.newInstance()
           			.scheme("https")
           			.host("www.poemist.com").
           			path("api/v1/randompoems")
         				.build();
           		
           		ResponseEntity<Poemas[]> restPoemas = rest.getForEntity(uri.toUriString(), Poemas[].class);
           		
           		map.put("dias", "Felicidades!! un poema: " + restPoemas.getBody()[0].getContent());
               } else {
              	 map.put("dias", String.valueOf(totalDias));
               }
        else {
        	 if (totalDias == 365) {
             	RestTemplate rest = new RestTemplate();
          		UriComponents uri = UriComponentsBuilder.newInstance()
          			.scheme("https")
          			.host("www.poemist.com").
          			path("api/v1/randompoems")
        				.build();
          		
          		ResponseEntity<Poemas[]> restPoemas = rest.getForEntity(uri.toUriString(), Poemas[].class);
          		
          		map.put("dias", "Felicidades!! un poema: " + restPoemas.getBody()[0].getContent());
              } else {
             	 map.put("dias", String.valueOf(totalDias));
              }
        }
       
		
		return map;
	}
}

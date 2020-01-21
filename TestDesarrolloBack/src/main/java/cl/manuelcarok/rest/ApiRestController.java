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
import cl.manuelcarok.repositories.ApiRepository;

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
		
		ApiRepository repository = new ApiRepository();
		HashMap<String, String> map = new HashMap<>();  
		map.put("nombre", repository.getNombreApellido(person.getNombre()));
		map.put("edad", repository.getEdad(person.getFecha()));
		map.put("dias", repository.getDias(person.getFecha()));
		
		return map;
	}
}

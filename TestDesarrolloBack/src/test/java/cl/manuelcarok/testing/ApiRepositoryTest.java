package cl.manuelcarok.testing;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Test;

import cl.manuelcarok.repositories.ApiRepository;

public class ApiRepositoryTest {

	@Test
	public void testGetNombre() {
		ApiRepository repository = new ApiRepository();
		String nombre = repository.getNombreApellido("Manuel Caroca Gonzalez");
		String esperado = "Manuel Caroca";
		
		assertEquals(esperado, nombre);
	}

	@Test
	public void testGetEdad() {
		ApiRepository repository = new ApiRepository();
		LocalDate hoy = LocalDate.now();
		
		String edad = repository.getEdad(hoy.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
		String esperado = "0";
		
		assertEquals(esperado, edad);
	}
	
	@Test
	public void testGetDias() {
		ApiRepository repository = new ApiRepository();
		LocalDate hoy = LocalDate.now();
		
		String dias = repository.getDias(hoy.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
		String esperado = "Felicidades!!";
		
		assertEquals(esperado, dias.split(" ")[0]);
	}
}

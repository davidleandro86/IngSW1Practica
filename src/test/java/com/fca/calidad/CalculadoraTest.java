package com.fca.calidad;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CalculadoraTest {
	private Calculadora miCalculadora ;
	
	@Before
	public void setup(){
		 miCalculadora = new Calculadora();
	}
	

	@Test
	public void sumaPositivosTest() {
		//Llamar al codigo
		float resultadoEsperado = 6;
		float resultadoEjecucion = miCalculadora.suma(2, 4);
		//Verificar
		assertThat(resultadoEsperado, equalTo(resultadoEjecucion));
	}
	
	@Test
	public void sumaConCeroTest() {
		//Llamar al codigo
		float resultadoEsperado = 4;
		float resultadoEjecucion = miCalculadora.suma(0,4);
	
		//Verificar
		assertThat(resultadoEsperado,equalTo(resultadoEjecucion));
	}
	
	@Test
	public void multiplicacionTest() {
		//Llamar al codigo 
		float resultadoEsperado = 12;
		float resultadoEjecucion = miCalculadora.multiplica(4,3);
		
		//Verificar
		assertThat(resultadoEsperado,equalTo(resultadoEjecucion));
	}
	
	@Test
	public void multiplicacionigualesTest() {
		//Llamar al codigo 
		float resultadoEsperado = 9;
		float resultadoEjecucion = miCalculadora.multiplica(3,3);
		
		//Verificar
		assertThat(resultadoEsperado,equalTo(resultadoEjecucion));
	}
	
	@Test (expected = ArithmeticException.class)
	public void dividirEntreCero() {
		//Llamar al codigo 
		float resultadoEsperado = 0;
		float resultadoEjecucion = miCalculadora.divide(10,0);
		
		//Verificar
		assertThat(resultadoEsperado,equalTo(resultadoEjecucion));
	}
	
	@Test
	public void divicionmismonumeroTest() {
		//Llamar al codigo 
		float resultadoEsperado = 1;
		float resultadoEjecucion = miCalculadora.divide(10,10);
		
		//Verificar
		assertThat(resultadoEsperado,equalTo(resultadoEjecucion));
	}
	@After
	public void tearDown(){
		System.out.println("Prueba terminada!");
	}

}

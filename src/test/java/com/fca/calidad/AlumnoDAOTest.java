package com.fca.calidad;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class AlumnoDAOTest {
	private AlumnoDAO alumnoDAO;

	 @Before
	public void setup()
	{
	alumnoDAO = new AlumnoDAOHashMap();
	alumnoDAO.getAllAlumno().clear(); //Limpiar nuestra BD
	}

	 @After
	public void tearDown()
	{

	}

	 @Test
	public void insertarDatoNuevoTest() {
	Alumno alumno = new Alumno("001","nombre", "apellido", 20, 8.0f);
	 //Insertar
	alumnoDAO.addAlumno(alumno);
	 //Consulta
	 String resultadoEsperado = "nombre apellido";
	String resultadoEjecucion = alumnoDAO.getAlumnoName("001");
	 //Verificar que sean iguales
	 assertThat(resultadoEsperado, equalTo(resultadoEjecucion));

	 }
	 @Test
	 public void borrarElementoTest(){
	  //Agregar alumno
	 Alumno alumno = new Alumno("001","nombre", "apellido", 20, 8.0f);
	  //Insertar
	 alumnoDAO.addAlumno(alumno);
	  //Eliminar dato --> Ejercicio del código
	 alumnoDAO.removeAlumno(alumno);
	  //Buscar dato que borramos
	  String resultadoEsperado = "";
	 String resultadoEjecucion = alumnoDAO.getAlumnoName("001");
	  //Verificar esperado igual a vacio
	  assertThat(resultadoEsperado, equalTo(resultadoEjecucion));

	 }
	 @Test
	 public void ActualizarPromedioTest(){
		 //Agregar alumno
		 Float prom = 9.1f;
		 Alumno alumno = new Alumno("001","nombre", "apellido", 20, 8.0f);
		//Insertar
		 alumnoDAO.addAlumno(alumno);
		//ejecutar el metodo actualizar
		 alumnoDAO.updateAlumnoPromedio(alumno, 5.0f);
		 //comparar
		 Float resultadoEsperado = 5.0f;
		 Float resultadoEjecucion = alumno.getAverage();
		  //Verificar esperado
		  assertThat(resultadoEsperado, equalTo(resultadoEjecucion));
		  
		  
		  
		 
	
	 }
}
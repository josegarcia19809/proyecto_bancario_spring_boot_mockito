package com.jgarcia.proyecto_bancario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProyectoBancarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoBancarioApplication.class, args);
		System.out.println("Ejecutando en puerto 8080...");
	}

}

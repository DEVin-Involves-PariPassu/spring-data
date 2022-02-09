package com.senai.devinhouse.springdata;

import com.senai.devinhouse.springdata.model.Estudante;
import com.senai.devinhouse.springdata.repository.EstudanteRepository;
import com.senai.devinhouse.springdata.service.EstudanteService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;
import java.util.Scanner;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

	private final EstudanteService estudanteService;
	private boolean system = true;

	public SpringDataApplication(EstudanteService estudanteService) {
		this.estudanteService = estudanteService;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);

		while(system) {
			System.out.println("Qual a função que você deseja acessar");
			System.out.println("0 - Sair");
			System.out.println("1 - Estudante");

			Integer function = scanner.nextInt();

			switch (function) {
				case 1:
					estudanteService.inicial(scanner);
					break;
				default:
					System.out.println("Finalizando");
					system = false;
					break;
			}
		}
	}
}

// flyway e liquibase

package com.senai.devinhouse.springdata.service;

import com.senai.devinhouse.springdata.model.Estudante;
import com.senai.devinhouse.springdata.model.Genero;
import com.senai.devinhouse.springdata.repository.EstudanteRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Scanner;

@Service
public class EstudanteService {

    private boolean system = true;
    private EstudanteRepository estudanteRepository;

    public EstudanteService(EstudanteRepository estudanteRepository) {
        this.estudanteRepository = estudanteRepository;
    }

    public void inicial(Scanner scanner) {
        while(system) {
            System.out.println("Qual ação do estudante deseja executar");
            System.out.println("0 - Voltar");
            System.out.println("1 - Salvar");
            System.out.println("2 - Visualizar");

            int action = scanner.nextInt();

            switch (action) {
                case 1:
                    salvar(scanner);
                    break;
                case 2:
                    visualizar();
                    break;
                default:
                    system = false;
                    break;
            }
        }
    }

    private void salvar(Scanner scanner) {
        Estudante estudante = new Estudante();
        System.out.println("Informe o primeiro nome");
        estudante.setNome(scanner.next());

        System.out.println("Informe o último nome");
        estudante.setUltimoNome(scanner.next());

        System.out.println("Informe a sua idade");
        estudante.setIdade(scanner.nextInt());
        estudante.setDataNascimento(LocalDate.now());
        estudante.setGenero(Genero.MASCULINO);
        estudante.setAtivo(false);
        estudanteRepository.save(estudante);
    }

    private void visualizar() {
        Iterable<Estudante> estudantes = estudanteRepository.findAll();
        estudantes.forEach(System.out::println);
    }
}

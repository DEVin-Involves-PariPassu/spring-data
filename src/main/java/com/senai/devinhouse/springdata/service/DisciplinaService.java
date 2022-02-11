package com.senai.devinhouse.springdata.service;

import com.senai.devinhouse.springdata.model.Disciplina;
import com.senai.devinhouse.springdata.model.Professor;
import com.senai.devinhouse.springdata.repository.DisciplinaRepository;
import com.senai.devinhouse.springdata.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Scanner;

@Service
public class DisciplinaService {

    private boolean system = true;

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    public void inicial(Scanner scanner) {
        while(system) {
            System.out.println("Qual ação em disciplina deseja executar");
            System.out.println("0 - Voltar");
            System.out.println("1 - Salvar");
            System.out.println("2 - Deletar");
            System.out.println("3 - Visualizar");

            int action = scanner.nextInt();

            switch (action) {
                case 1 :
                    salvar(scanner);
                    break;
                case 2 :
                    deletar(scanner);
                    break;
                case 3:
                    visualizar();
                    break;
                default:
                    system = false;
                    break;
            }
        }
    }

    private void deletar(Scanner scanner) {
        System.out.println("Informe o id da disciplina para deletar");
        Long id = scanner.nextLong();

        disciplinaRepository.deleteById(id);
    }

    private void visualizar() {
        Iterable<Disciplina> disciplinas = disciplinaRepository.findAll();
        disciplinas.forEach(System.out::println);
    }

    private void salvar(Scanner scanner) {
        System.out.println("Informe a descrição da disciplina");
        String descricao = scanner.next();

        System.out.println("Infome o Nome do professor");
        String nome = scanner.next();

        System.out.println("Informe o sobrenome do professor");
        String sobreNome = scanner.next();

        Disciplina disciplina = new Disciplina();
        disciplina.setDescricao(descricao);

        Professor professor = new Professor();
        professor.setNome(nome);
        professor.setSobreNome(sobreNome);

        disciplina.setProfessor(professor);

        disciplinaRepository.save(disciplina);
    }

    public void update() {
        Optional<Disciplina> disciplina1 = disciplinaRepository.findById(5L);
        disciplina1.get().setDescricao();
        Disciplina disciplina = new Disciplina();
        disciplina.setId(5L);
        disciplina.setProfessor();

        disciplinaRepository.save(disciplina);
    }
}

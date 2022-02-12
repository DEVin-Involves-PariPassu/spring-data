package com.senai.devinhouse.springdata.repository;

import com.senai.devinhouse.springdata.model.Estudante;
import org.springframework.data.jpa.domain.Specification;

public class SpecificationsEstudante {

    public static Specification<Estudante> nome(String nome) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.like(root.get("nome"), "%" + nome + "%");
    }

    public static Specification<Estudante> idadeMaiorQue(Integer idade) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.gt(root.get("idade"), idade);
    }
}

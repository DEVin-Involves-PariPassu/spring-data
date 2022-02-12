package com.senai.devinhouse.springdata.repository;

import com.senai.devinhouse.springdata.model.Disciplina;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DisciplinaRepository extends CrudRepository<Disciplina, Long> {
}

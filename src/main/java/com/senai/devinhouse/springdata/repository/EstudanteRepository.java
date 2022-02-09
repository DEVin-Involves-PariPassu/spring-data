package com.senai.devinhouse.springdata.repository;

import com.senai.devinhouse.springdata.model.Estudante;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudanteRepository extends CrudRepository<Estudante, Long> {
}

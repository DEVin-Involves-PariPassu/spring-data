package com.senai.devinhouse.springdata.model;

//id int
//descricao varchar(255)
//id_professor integer fk

import javax.persistence.*;

@Entity
public class Disciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gerador_seq_disciplina")
    @SequenceGenerator(name = "gerador_seq_disciplina", sequenceName = "disciplina_seq")
    private Long id;

    private String descricao;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "id_professor", referencedColumnName = "id")
    private Professor professor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    @Override
    public String toString() {
        return "Disciplina{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", professor=" + professor +
                '}';
    }
}

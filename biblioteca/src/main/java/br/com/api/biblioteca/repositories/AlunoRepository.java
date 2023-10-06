package br.com.api.biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.biblioteca.entities.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Integer>{

}

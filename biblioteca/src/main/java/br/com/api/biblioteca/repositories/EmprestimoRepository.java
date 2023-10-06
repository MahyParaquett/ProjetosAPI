package br.com.api.biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.biblioteca.entities.Emprestimo;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Integer> {

}

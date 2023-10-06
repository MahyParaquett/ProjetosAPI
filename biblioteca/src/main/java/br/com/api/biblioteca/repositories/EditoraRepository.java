package br.com.api.biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.biblioteca.entities.Editora;


public interface EditoraRepository extends JpaRepository<Editora, Integer> {
	
}

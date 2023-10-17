package br.com.api.biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.biblioteca.entities.Autor;

public interface AutorRepository extends JpaRepository<Autor, Integer>{

}

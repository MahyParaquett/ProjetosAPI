package br.com.api.biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.biblioteca.entities.Livro;

public interface LivroRepository extends JpaRepository<Livro, Integer>  {

}

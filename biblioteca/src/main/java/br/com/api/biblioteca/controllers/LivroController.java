package br.com.api.biblioteca.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.biblioteca.entities.Livro;
import br.com.api.biblioteca.services.LivroService;

@RestController
@RequestMapping("/livros")
public class LivroController {

	@Autowired
	LivroService livroService;

	// listar todos
	@GetMapping
	public ResponseEntity<List<Livro>> listarLivros() {
		return new ResponseEntity<>(livroService.listarLivros(), HttpStatus.OK);
	}

	// buscar por id
	@GetMapping("/{id}")
	public ResponseEntity<Livro> buscarLivroPorId(@PathVariable Integer id) {
		return new ResponseEntity<>(livroService.buscarLivroPorId(id), HttpStatus.OK);
	}

	// salvar um novo objeto
	@PostMapping
	public ResponseEntity<Livro> salvarLivro(@RequestBody Livro livro) {
		return new ResponseEntity<>(livroService.salvarLivro(livro), HttpStatus.CREATED);
	}

	// atualizar um objeto
	@PutMapping
	public ResponseEntity<Livro> atualizarLivro(@RequestBody Livro livro) {
		return new ResponseEntity<>(livroService.atualizarLivro(livro), HttpStatus.OK);
	}

	// deletar um objeto
	@DeleteMapping
	public ResponseEntity<String> deletarLivro(@RequestBody Livro livro) {
		livroService.deletarLivro(livro);
		return new ResponseEntity<>("Deletado com sucesso", HttpStatus.OK);
	}

}

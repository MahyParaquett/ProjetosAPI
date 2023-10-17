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

import br.com.api.biblioteca.entities.Autor;
import br.com.api.biblioteca.services.AutorService;

@RestController
@RequestMapping("/autores")
public class AutorController {

	@Autowired
	AutorService autorService;

	// listar todos
	@GetMapping
	public ResponseEntity<List<Autor>> listarAutors() {
		return new ResponseEntity<>(autorService.listarAutors(), HttpStatus.OK);
	}

	// buscar por id
	@GetMapping("/{id}")
	public ResponseEntity<Autor> buscarAutorPorId(@PathVariable Integer id) {
		Autor autor = autorService.buscarAutorPorId(id);
		if (autor == null)
			return new
					ResponseEntity<>(autor, HttpStatus.NOT_FOUND);
		else
			return new
					ResponseEntity<>(autor, HttpStatus.OK);
	}

	// salvar um novo objeto
	@PostMapping
	public ResponseEntity<Autor> salvarAutor(@RequestBody Autor autor) {
		return new ResponseEntity<>(autorService.salvarAutor(autor), HttpStatus.CREATED);
	}

	// atualizar um objeto
	@PutMapping
	public ResponseEntity<Autor> atualizarAutor(@RequestBody Autor autor) {
		return new ResponseEntity<>(autorService.atualizarAutor(autor), HttpStatus.OK);
	}

	// deletar um objeto
	@DeleteMapping
	public ResponseEntity<String> deletarAutor(@RequestBody Autor autor) {
		if(autorService.deletarAutor(autor))
			return new 
					ResponseEntity<>("Deletado com sucesso", HttpStatus.OK);
else
	return new
			ResponseEntity<>("Não foi possivel deletar", HttpStatus.BAD_REQUEST);
	}

}



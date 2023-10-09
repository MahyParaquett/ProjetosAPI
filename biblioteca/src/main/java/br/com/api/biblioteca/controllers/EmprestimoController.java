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

import br.com.api.biblioteca.entities.Emprestimo;
import br.com.api.biblioteca.services.EmprestimoService;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {

	@Autowired
	EmprestimoService emprestimoService;

	// listar todos
	@GetMapping
	public ResponseEntity<List<Emprestimo>> listarEmprestimos() {
		return new ResponseEntity<>(emprestimoService.listarEmprestimos(), HttpStatus.OK);
	}

	// buscar por id
	@GetMapping("/{id}")
	public ResponseEntity<Emprestimo> buscarEmprestimoPorId(@PathVariable Integer id) {
		return new ResponseEntity<>(emprestimoService.buscarEmprestimoPorId(id), HttpStatus.OK);
	}

	// salvar um novo objeto
	@PostMapping
	public ResponseEntity<Emprestimo> salvarEmprestimo(@RequestBody Emprestimo emprestimo) {
		return new ResponseEntity<>(emprestimoService.salvarEmprestimo(emprestimo), HttpStatus.CREATED);
	}

	// atualizar um objeto
	@PutMapping
	public ResponseEntity<Emprestimo> atualizarEmprestimo(@RequestBody Emprestimo emprestimo) {
		return new ResponseEntity<>(emprestimoService.atualizarEmprestimo(emprestimo), HttpStatus.OK);
	}

	// deletar um objeto
	@DeleteMapping
	public ResponseEntity<String> deletarEmprestimo(@RequestBody Emprestimo emprestimo) {
		emprestimoService.deletarEmprestimo(emprestimo);
		return new ResponseEntity<>("Deletado com sucesso", HttpStatus.OK);
	}

}

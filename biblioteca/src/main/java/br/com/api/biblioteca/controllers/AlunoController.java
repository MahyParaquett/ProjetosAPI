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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.biblioteca.dto.AlunoResumidoDTO;
import br.com.api.biblioteca.entities.Aluno;
import br.com.api.biblioteca.services.AlunoService;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

	@Autowired
	AlunoService alunoService;

	// listar todos
	@GetMapping
	public ResponseEntity<List<Aluno>> listarAlunos() {
		return new ResponseEntity<>(alunoService.listarAlunos(), HttpStatus.OK);
	}
	
	//Listar todos DTO
	@GetMapping("/resumido")
	public ResponseEntity<List<AlunoResumidoDTO>> listarAlunosResumido() {
		return new ResponseEntity<>(alunoService.listarAlunosResumidos(), HttpStatus.OK);
	}
	
	

	// buscar por id recebendo por path
	@GetMapping("/{id}")
	public ResponseEntity<Aluno> buscarAlunoPorId(@PathVariable Integer id) {
		
		Aluno aluno = alunoService.buscarAlunoPorId(id);
		if (aluno == null)
			return new
					ResponseEntity<>(aluno, HttpStatus.NOT_FOUND);
		else
			return new
					ResponseEntity<>(aluno, HttpStatus.OK);
	}
	// buscar por id recebendo por query
	///alunos/porid?id=2
	
	//Usando dto
	@GetMapping("/resumido/{id}")
		public ResponseEntity<AlunoResumidoDTO> getAlunoResulmidoPorId
		(@PathVariable Integer id) {
			AlunoResumidoDTO alunoResDTO = alunoService.getAlunoResumidoPorId(id);
			
			if (alunoResDTO == null)
				return new
						ResponseEntity<>(alunoResDTO, HttpStatus.NOT_FOUND);
			else
				return new
						ResponseEntity<>(alunoResDTO, HttpStatus.OK);
		}
	
	@GetMapping("/porid")
	public ResponseEntity<Aluno> buscarPorId(@RequestParam Integer id) {
		return new ResponseEntity<>(alunoService.buscarAlunoPorId(id), HttpStatus.OK);
	}
	
	
	
	// salvar um novo objeto
	@PostMapping
	public ResponseEntity<Aluno> salvarAluno(@RequestBody Aluno aluno) {
		return new ResponseEntity<>(alunoService.salvarAluno(aluno), HttpStatus.CREATED);
	}

	// atualizar um objeto
	@PutMapping
	public ResponseEntity<Aluno> atualizarAluno(@RequestBody Aluno aluno) {
		return new ResponseEntity<>(alunoService.atualizarAluno(aluno), HttpStatus.OK);
	}

	// deletar um objeto
	@DeleteMapping
	public ResponseEntity<String> deletarAluno(@RequestBody Aluno aluno) {
		if(alunoService.deletarAluno(aluno)) {
					return new 
							ResponseEntity<>("Deletado com sucesso", HttpStatus.OK);
		}else {
			return new
					ResponseEntity<>("Não foi possivel deletar", HttpStatus.BAD_REQUEST);
		}
	}

}

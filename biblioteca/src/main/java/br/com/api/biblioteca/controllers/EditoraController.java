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
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import br.com.api.biblioteca.dto.EditoraDTO;
import br.com.api.biblioteca.dto.ReceitaWsDTO;
import br.com.api.biblioteca.entities.Editora;
import br.com.api.biblioteca.services.EditoraService;

@RestController
@RequestMapping("/editoras")
public class EditoraController {

	@Autowired
	EditoraService editoraService;

	// listar todos
	@GetMapping
	public ResponseEntity<List<Editora>> listarEditoras() {
		return new ResponseEntity<>(editoraService.listarEditoras(), HttpStatus.OK);
	}

	// buscar por id
	@GetMapping("/{id}")
	public ResponseEntity<Editora> buscarEditoraPorId(@PathVariable Integer id) {
		Editora editora = editoraService.buscarEditoraPorId(id);
		if (editora == null)
			return new ResponseEntity<>(editora, HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<>(editora, HttpStatus.OK);
	}

	// salvar um novo objeto
	@PostMapping
	public ResponseEntity<Editora> salvarEditora(@RequestBody Editora editora) {
		return new ResponseEntity<>(editoraService.salvarEditora(editora), HttpStatus.CREATED);
	}
	
	// salvar um novo objeto DTO
		@PostMapping("/saveDto")
		public ResponseEntity<EditoraDTO> salvarEditoraDTO(@RequestBody EditoraDTO editoraDTO) {
			return new ResponseEntity<>(editoraService.salvarEditoraDto(editoraDTO), 
					HttpStatus.CREATED);
		}

	// atualizar um objeto
	@PutMapping
	public ResponseEntity<Editora> atualizarEditora(@RequestBody Editora editora) {
		return new ResponseEntity<>(editoraService.atualizarEditora(editora), HttpStatus.OK);
	}

	// deletar um objeto
	@DeleteMapping
	public ResponseEntity<String> deletarEditora(@RequestBody Editora editora) {
		if(editoraService.deletarEditora(editora))
			return new 
					ResponseEntity<>("Deletado com sucesso", HttpStatus.OK);
else
	return new
			ResponseEntity<>("Não foi possivel deletar", HttpStatus.BAD_REQUEST);
	}

	//Consultar cnpj
	@GetMapping("/consulta-cnpj/{cnpj}")
	public ResponseEntity<ReceitaWsDTO> consultaCnpj(@PathVariable String cnpj) {
		return new 
				ResponseEntity<>(editoraService.consultaCnpj(cnpj), HttpStatus.OK);
	}
	
	//img no banco
	@PostMapping ("/comfoto")
	public ResponseEntity<Editora> salvarComFoto(@RequestPart("edt")String strEditora,
			@RequestPart("img")MultipartFile arqImg) throws JsonMappingException, JsonProcessingException {
		return new ResponseEntity<>(editoraService.salvarEditoraComFoto(strEditora, arqImg), HttpStatus.CREATED);
	}
	
}

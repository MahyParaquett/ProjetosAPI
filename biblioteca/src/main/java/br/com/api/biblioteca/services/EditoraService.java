package br.com.api.biblioteca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.biblioteca.entities.Editora;
import br.com.api.biblioteca.repositories.EditoraRepository;

@Service
public class EditoraService {
//CRUD
	// recuperar todos as editoras

	@Autowired
	EditoraRepository editoraRep;

	public List<Editora> listarEditoras() {
		return editoraRep.findAll();
	}

	// recuperar um editora pela chave primária
	public Editora buscarEditoraPorId(Integer id) {
		return editoraRep.findById(id).orElse(null);
	}

	// salvar um novo editora
	public Editora salvarEditora(Editora editora) {
		return editoraRep.save(editora);
	}

	// atualizar um determinado editora
	public Editora atualizarEditora(Editora editora) {
		return editoraRep.save(editora);
	}

	// deletar um deteminado editora
	public void deletarEditora(Editora editora) {
		editoraRep.delete(editora);
		/*Editora confere = buscarEditoraPorId(editora.getNumeroMatriculaEditora());
		If(confere==null){ editora deletado}
		Else{editora continua existindo}
		*/

	}

}

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
	public Boolean deletarEditora(Editora editora) {
		// Confere se o editora passado tem dados
		if (editora == null) {
			return false;
		}
		// Confere já que tem dados, vê se ta no Banco
		Editora editoraExistente = buscarEditoraPorId(editora.getCodigoEditora());

		// Se ele não tá no banco volta editora
		if (editoraExistente == null) {
			return false;
		}

		// Ele existe no banco e tem dados, então deleta.
		editoraRep.delete(editora);

		// CONFERENCIA SE FOI DELETADO
		Editora editoraContinuaExistindo = buscarEditoraPorId(editora.getCodigoEditora());

		if (editoraContinuaExistindo == null) {
			return true;
		}
		// Se não caiu em nenhuma das anteriores ele retorna falso (não apagou)
		return false;

	}

}

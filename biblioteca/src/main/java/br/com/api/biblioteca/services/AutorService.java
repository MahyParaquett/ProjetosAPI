package br.com.api.biblioteca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.biblioteca.entities.Autor;
import br.com.api.biblioteca.repositories.AutorRepository;

@Service
public class AutorService{ 
//CRUD
// recuperar todos os autors

@Autowired
AutorRepository autorRep;

public List<Autor> listarAutors() {
	return autorRep.findAll();
}

// recuperar um autor pela chave primária
public Autor buscarAutorPorId(Integer id) {
	return autorRep.findById(id).orElse(null);
}

// salvar um novo autor
public Autor salvarAutor(Autor autor) {
	return autorRep.save(autor);
}

// atualizar um determinado autor
public Autor atualizarAutor(Autor autor) {
	return autorRep.save(autor);
}

// deletar um deteminado autor
public Boolean deletarAutor(Autor autor) {
		// Confere se o autor passado tem dados
		if (autor == null) {
			return false;
		}
		// Confere já que tem dados, vê se ta no Banco
		Autor autorExistente = buscarAutorPorId(autor.getCodigoAutor());

		// Se ele não tá no banco volta autor
		if (autorExistente == null) {
			return false;
		}

		// Ele existe no banco e tem dados, então deleta.
		autorRep.delete(autor);

		// CONFERENCIA SE FOI DELETADO
		Autor autorContinuaExistindo = buscarAutorPorId(autor.getCodigoAutor());

		if (autorContinuaExistindo == null) {
			return true;
		}
		// Se não caiu em nenhuma das anteriores ele retorna falso (não apagou)
		return false;

	}

	

}

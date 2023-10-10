package br.com.api.biblioteca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.biblioteca.entities.Livro;
import br.com.api.biblioteca.repositories.LivroRepository;

@Service
public class LivroService {
//CRUD
	// recuperar todos os livros

	@Autowired
	LivroRepository livroRep;

	public List<Livro> listarLivros() {
		return livroRep.findAll();
	}

	// recuperar um livro pela chave primária
	public Livro buscarLivroPorId(Integer id) {
		return livroRep.findById(id).orElse(null);
	}

	// salvar um novo livro
	public Livro salvarLivro(Livro livro) {
		return livroRep.save(livro);
	}

	// atualizar um determinado livro
	public Livro atualizarLivro(Livro livro) {
		return livroRep.save(livro);
	}

	// deletar um deteminado livro
	public void deletarLivro(Livro livro) {
		livroRep.delete(livro);
		/*Livro confere = buscarLivroPorId(livro.getNumeroMatriculaLivro());
		If(confere==null){ livro deletado}
		Else{livro continua existindo}
		*/

	}

}

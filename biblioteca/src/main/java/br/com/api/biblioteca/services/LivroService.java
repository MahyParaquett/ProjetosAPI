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
	public Boolean deletarLivro(Livro livro) {
			// Confere se o livro passado tem dados
			if (livro == null) {
				return false;
			}
			// Confere já que tem dados, vê se ta no Banco
			Livro livroExistente = buscarLivroPorId(livro.getCodigoLivro());

			// Se ele não tá no banco volta livro
			if (livroExistente == null) {
				return false;
			}

			// Ele existe no banco e tem dados, então deleta.
			livroRep.delete(livro);

			// CONFERENCIA SE FOI DELETADO
			Livro livroContinuaExistindo = buscarLivroPorId(livro.getCodigoLivro());

			if (livroContinuaExistindo == null) {
				return true;
			}
			// Se não caiu em nenhuma das anteriores ele retorna falso (não apagou)
			return false;

		}

		

}

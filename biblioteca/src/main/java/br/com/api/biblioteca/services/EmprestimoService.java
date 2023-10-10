package br.com.api.biblioteca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.biblioteca.entities.Emprestimo;
import br.com.api.biblioteca.repositories.EmprestimoRepository;

@Service
public class EmprestimoService {
//CRUD
	// recuperar todos os emprestimos

	@Autowired
	EmprestimoRepository emprestimoRep;

	public List<Emprestimo> listarEmprestimos() {
		return emprestimoRep.findAll();
	}

	// recuperar um emprestimo pela chave primária
	public Emprestimo buscarEmprestimoPorId(Integer id) {
		return emprestimoRep.findById(id).orElse(null);
	}

	// salvar um novo emprestimo
	public Emprestimo salvarEmprestimo(Emprestimo emprestimo) {
		return emprestimoRep.save(emprestimo);
	}

	// atualizar um determinado emprestimo
	public Emprestimo atualizarEmprestimo(Emprestimo emprestimo) {
		return emprestimoRep.save(emprestimo);
	}

	// deletar um deteminado emprestimo
	public void deletarEmprestimo(Emprestimo emprestimo) {
		emprestimoRep.delete(emprestimo);
		/*Emprestimo confere = buscarEmprestimoPorId(emprestimo.getNumeroMatriculaEmprestimo());
		If(confere==null){ emprestimo deletado}
		Else{emprestimo continua existindo}
		*/

	}

}

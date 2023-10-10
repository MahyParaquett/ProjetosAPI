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
	public Boolean deletarEmprestimo(Emprestimo emprestimo) {
			// Confere se o emprestimo passado tem dados
			if (emprestimo == null) {
				return false;
			}
			// Confere já que tem dados, vê se ta no Banco
			Emprestimo emprestimoExistente = buscarEmprestimoPorId(emprestimo.getCodigoEmprestimo());

			// Se ele não tá no banco volta emprestimo
			if (emprestimoExistente == null) {
				return false;
			}

			// Ele existe no banco e tem dados, então deleta.
			emprestimoRep.delete(emprestimo);

			// CONFERENCIA SE FOI DELETADO
			Emprestimo emprestimoContinuaExistindo = buscarEmprestimoPorId(emprestimo.getCodigoEmprestimo());

			if (emprestimoContinuaExistindo == null) {
				return true;
			}
			// Se não caiu em nenhuma das anteriores ele retorna falso (não apagou)
			return false;

		}


}

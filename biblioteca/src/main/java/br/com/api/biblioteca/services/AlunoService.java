package br.com.api.biblioteca.services;

import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.biblioteca.entities.Aluno;
import br.com.api.biblioteca.repositories.AlunoRepository;

@Service
public class AlunoService {
//CRUD
	// recuperar todos os alunos

	@Autowired
	AlunoRepository alunoRep;

	public List<Aluno> listarAlunos() {
		return alunoRep.findAll();
	}

	// recuperar um aluno pela chave primária
	public Aluno buscarAlunoPorId(Integer id) {
		
		//OPÇÃO 1
		/*Optional<Aluno>alunoBanco = alunoRep.findById(id);
		if(alunoBanco.isPresent())
		return alunoBanco.get();
		else
		return null;*/

		//OPÇÃO 2
		return alunoRep.findById(id).orElse(null);
	}

	// salvar um novo aluno
	public Aluno salvarAluno(Aluno aluno) {
		return alunoRep.save(aluno);
	}

	// atualizar um determinado aluno
	public Aluno atualizarAluno(Aluno aluno) {
		return alunoRep.save(aluno);
	}

	// deletar um deteminado aluno
	public void deletarAluno(Aluno aluno) {
		alunoRep.delete(aluno);
		/*Aluno confere = buscarAlunoPorId(aluno.getNumeroMatriculaAluno());
		If(confere==null){ aluno deletado}
		Else{aluno continua existindo}
		*/

	}

}

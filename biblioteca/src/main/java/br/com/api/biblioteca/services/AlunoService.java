package br.com.api.biblioteca.services;

import java.util.ArrayList;
import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.biblioteca.dto.AlunoResumidoDTO;
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

	// recuperar uma lista de aluno resumido
	public List<AlunoResumidoDTO> listarAlunosResumidos() {
		List<Aluno> alunos = alunoRep.findAll();
		List<AlunoResumidoDTO> alunosDTO = new ArrayList<>();

		/* A cada interação o aluno vai receber o conteudo do 
		 alunos(lista) na posição x
		 */
		for (Aluno aluno : alunos) {
			AlunoResumidoDTO alunoResDTO = new AlunoResumidoDTO();
			alunoResDTO.setNumeroMatriculaAluno(aluno.getNumeroMatriculaAluno());
			alunoResDTO.setNome(aluno.getNome());
			alunoResDTO.setCpf(aluno.getCpf());
			
			alunosDTO.add(alunoResDTO);
		}
		return alunosDTO;
	}

	// recuperar um aluno pela chave primária
	public Aluno buscarAlunoPorId(Integer id) {

		// OPÇÃO 1
		/*
		 * Optional<Aluno>alunoBanco = alunoRep.findById(id); if(alunoBanco.isPresent())
		 * return alunoBanco.get(); else return null;
		 */

		// OPÇÃO 2
		return alunoRep.findById(id).orElse(null);
	}

	// recuperar aluno resumido pelo id
	public AlunoResumidoDTO getAlunoResumidoPorId(Integer id) {
		Aluno aluno = alunoRep.findById(id).orElse(null);
		
		if (aluno != null) {
			AlunoResumidoDTO alunoResDTO = new AlunoResumidoDTO(
					aluno.getNumeroMatriculaAluno(),
					aluno.getNome(),
					aluno.getCpf()
			);
			return alunoResDTO;
		}
		return null;
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
	public Boolean deletarAluno(Aluno aluno) {
		// Confere se o aluno passado tem dados
		if (aluno == null) {
			return false;
		}
		// Confere já que tem dados, vê se ta no Banco
		Aluno alunoExistente = buscarAlunoPorId(aluno.getNumeroMatriculaAluno());

		// Se ele não tá no banco volta aluno
		if (alunoExistente == null) {
			return false;
		}

		// Ele existe no banco e tem dados, então deleta.
		alunoRep.delete(aluno);

		// CONFERENCIA SE FOI DELETADO
		Aluno alunoContinuaExistindo = buscarAlunoPorId(aluno.getNumeroMatriculaAluno());

		if (alunoContinuaExistindo == null) {
			return true;
		}
		// Se não caiu em nenhuma das anteriores ele retorna falso (não apagou)
		return false;

	}

}

package br.com.api.biblioteca.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.api.biblioteca.dto.EditoraDTO;
import br.com.api.biblioteca.dto.ReceitaWsDTO;
import br.com.api.biblioteca.entities.Editora;
import br.com.api.biblioteca.repositories.EditoraRepository;
import io.jsonwebtoken.io.IOException;

@Service
public class EditoraService {
//CRUD
	// recuperar todos as editoras

	@Autowired
	EditoraRepository editoraRep;

	private ModelMapper modelMapper = new ModelMapper();
	
	public List<Editora> listarEditoras() {
		return editoraRep.findAll();
	}

	// recuperar um editora pela chave primária
	public Editora buscarEditoraPorId(Integer id) {
		return editoraRep.findById(id).orElse(null);
	}

	// salvar uma nova editora
	public Editora salvarEditora(Editora editora) {
		return editoraRep.save(editora);
	}
	// salvar uma nova editoraDTO
	public EditoraDTO salvarEditoraDto(EditoraDTO editoraDto) {
		Editora editora = convertToEntity(editoraDto);
		return convertToDto(editoraRep.save(editora));
	}
	
	//convertendo para dto
		private EditoraDTO convertToDto(Editora editora) {
			EditoraDTO editoraDto = modelMapper.map(editora, EditoraDTO.class);
			return editoraDto;
		}
		//dto para entidade
		private Editora convertToEntity(EditoraDTO editoraDto){
		    Editora editora = modelMapper.map(editoraDto, Editora.class);
		    return editora;
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
	
	//Consultar cnpj
	public ReceitaWsDTO consultaCnpj(String cnpj) {
		RestTemplate restTemplate = new RestTemplate();
		String uri = "https://receitaws.com.br/v1/cnpj/{cnpj}";
		Map<String,String>params = new HashMap<String,String>();
		params.put("cnpj", cnpj);
		
		ReceitaWsDTO receitaDto = restTemplate.getForObject
				(uri, ReceitaWsDTO.class, params);
		
		return receitaDto;
	}

	//Salvar a foto
	public Editora salvarEditoraComFoto(String strEditora, MultipartFile arqImg) throws JsonMappingException, JsonProcessingException {
		Editora editora = new Editora();
		try {
			ObjectMapper objMp = new ObjectMapper()
					.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			editora = objMp.readValue(strEditora,Editora.class);
		}catch(IOException e) {
			System.out.println("Erro ao converter a string Editora: " + e.toString());
		} 
		
		return editoraRep.save(editora);
	}
	
}

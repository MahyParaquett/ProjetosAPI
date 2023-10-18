package br.com.api.biblioteca.dto;

import java.util.Date;

public class LivroResumidoDTO {
private Integer codigoLivro;
private String nomeLivro;
private Date dataLancamento;
private String nomeEditora;
public Integer getCodigoLivro() {
	return codigoLivro;
}
public void setCodigoLivro(Integer codigoLivro) {
	this.codigoLivro = codigoLivro;
}
public String getNomeLivro() {
	return nomeLivro;
}
public void setNomeLivro(String nomeLivro) {
	this.nomeLivro = nomeLivro;
}
public Date getDataLancamento() {
	return dataLancamento;
}
public void setDataLancamento(Date dataLancamento) {
	this.dataLancamento = dataLancamento;
}
public String getNomeEditora() {
	return nomeEditora;
}
public void setNomeEditora(String nomeEditora) {
	this.nomeEditora = nomeEditora;
}


}

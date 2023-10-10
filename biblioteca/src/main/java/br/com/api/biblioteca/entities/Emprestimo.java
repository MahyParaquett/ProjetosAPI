package br.com.api.biblioteca.entities;

import java.math.BigDecimal;
import java.util.Date;

//import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "codigoEmprestimo"
)
@Entity
@Table(name = "emprestimo")
public class Emprestimo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigoemprestimo")
	private Integer codigoEmprestimo;
	
	//OPÇÃO 1
	//@JsonBackReference(value = "aluno-mng-ref")
	@ManyToOne
	@JoinColumn(name= "numeromatriculaaluno", 
	referencedColumnName = "numeromatriculaaluno")
	private Aluno aluno;
	
	//OPÇÃO 1
	//@JsonBackReference(value = "livro-emprestimo-ref")
	@ManyToOne
	@JoinColumn(name= "codigolivro", 
	referencedColumnName = "codigolivro")
	private Livro livro;
	
	@Column(name = "dataemprestimo")
	private Date dataEmprestimo;
	
	@Column(name = "dataentrega")
	private Date dataEntrega;
	
	@Column(name = "valoremprestimo")
	private BigDecimal valorEmprestimo;

	public Integer getCodigoEmprestimo() {
		return codigoEmprestimo;
	}

	public void setCodigoEmprestimo(Integer codigoEmprestimo) {
		this.codigoEmprestimo = codigoEmprestimo;
	}
		
	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public Date getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(Date dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	public Date getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public BigDecimal getValorEmprestimo() {
		return valorEmprestimo;
	}

	public void setValorEmprestimo(BigDecimal valorEmprestimo) {
		this.valorEmprestimo = valorEmprestimo;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
	
}

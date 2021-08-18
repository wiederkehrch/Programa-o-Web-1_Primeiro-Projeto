package br.com.senac.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//Especificando que Aluno é uma tabela
@Entity
public class Aluno implements Serializable {
	
	//Especificando que o objeto é único
	private static final long serialVersionUID = -9188148431809422228L;

	
	
	//Declarações de atributos
	
	
	//Chave primária
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	
	@Column (name = "nomeAluno") //Para alterar o nome da coluna (não deixar com o nome do atributo)
	private String nome;


	
	//Getters & Setters
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	} 
	
	
}

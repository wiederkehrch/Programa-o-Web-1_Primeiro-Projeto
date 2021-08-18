package br.com.senac.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Professor implements Serializable {

	private static final long serialVersionUID = -1802821701243022043L;
	
	
	//Declarações de atributos
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id;

		
		@Column (name = "nomeProfessor")
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

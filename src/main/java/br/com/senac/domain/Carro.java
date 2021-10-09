package br.com.senac.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Carro implements Serializable {

	private static final long serialVersionUID = -411976641432368451L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String modelo;
	
	
	//Incluir Chave no Carro (cada carro possui uma única chave)
	@OneToOne
	@JoinColumn(name = "id_chave")
	private Chave chave;
	
	
	//Incluir Documento no Carro (cada carro possui um único documento)
	@OneToOne
	@JoinColumn(name = "id_documento")
	private Documento documento;
	
	
	//Incluir Fabricante no Carro (vários carros podem ser de um mesmo fabricante)
	@ManyToOne
	@JoinColumn(name = "id_fabricante")
	private Fabricante fabricante;

			
	
	//Getters and Setters
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Chave getChave() {
		return chave;
	}

	public void setChave(Chave chave) {
		this.chave = chave;
	}

	public Documento getDocumento() {
		return documento;
	}

	public void setDocumento(Documento documento) {
		this.documento = documento;
	}

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}
	

}

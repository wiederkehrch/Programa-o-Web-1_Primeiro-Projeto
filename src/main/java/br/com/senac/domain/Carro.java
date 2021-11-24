package br.com.senac.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
	
	
	/*Um carro pode ter vários acessórios. Por isso precisa de uma lista para os acessórios.
	 * E um acessório pode estar em vários carros. */
	@ManyToMany
	@JoinTable(
			name = "carro_acessorio",
			joinColumns = {@JoinColumn(name = "id_carro")},
			inverseJoinColumns = {@JoinColumn(name = "id_acessorio")})
	private List<Acessorio> acessorios;

			
	
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

	public List<Acessorio> getAcessorios() {
		return acessorios;
	}

	public void setAcessorios(List<Acessorio> acessorios) {
		this.acessorios = acessorios;
	}
	

	
}

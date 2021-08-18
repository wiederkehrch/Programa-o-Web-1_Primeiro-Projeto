package br.com.senac.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.domain.Aluno;
import br.com.senac.repository.AlunoRepositorio;


//Especificando que é uma camada de serviço.
//Ela media a comunicação entre um controlador e uma camada de repositório. 
//A camada de serviço contém a lógica de negócios.
@Service
public class AlunoService {
	
	//Injeção de dependência.Instancia sempre que necessário.
	@Autowired
	AlunoRepositorio repo;
	
	public Aluno salvar (Aluno aluno) {
		
		return repo.save(aluno);
	}

}

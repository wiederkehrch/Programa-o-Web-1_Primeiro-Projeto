package br.com.senac.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.domain.Aluno;
import br.com.senac.repository.AlunoRepositorio;
import javassist.tools.rmi.ObjectNotFoundException;


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
	
	
	public List<Aluno> buscarTodosAlunos () {
		
		return repo.findAll();
	}
	
	
	public Aluno buscaPorId (Integer id) throws ObjectNotFoundException {
		
		Optional<Aluno> aluno = repo.findById(id);
		return aluno.orElseThrow(() -> new ObjectNotFoundException ("Aluno não encontrado" + id));
	}
	
	
	public Aluno salvarAlteracao (Aluno alunoAlterado) throws ObjectNotFoundException {
		
		Aluno alunoAtual = buscaPorId(alunoAlterado.getId());
		alunoAtual.setId(alunoAlterado.getId());
		alunoAtual.setNome(alunoAlterado.getNome());
		return salvar(alunoAtual);
	}
	
	
	public void excluir (Integer idAluno) {
		
		repo.deleteById(idAluno);
	}

}

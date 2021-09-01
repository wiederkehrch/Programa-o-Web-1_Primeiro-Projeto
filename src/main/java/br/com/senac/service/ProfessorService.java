package br.com.senac.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.domain.Professor;
import br.com.senac.repository.ProfessorRepositorio;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class ProfessorService {

	@Autowired
	ProfessorRepositorio repo;
	
	public Professor salvar (Professor prof) {
		
		return repo.save(prof);
	}
	
	
public List<Professor> buscarTodosProfessores () {
		
		return repo.findAll();
	}

	
public Professor buscaPorId (Integer id) throws ObjectNotFoundException {
	
	Optional<Professor> professor = repo.findById(id);
	return professor.orElseThrow(() -> new ObjectNotFoundException ("Professor não encontrado" + id));
}


public Professor salvarAlteracao (Professor professorAlterado) throws ObjectNotFoundException {
	
	Professor professorAtual = buscaPorId(professorAlterado.getId());
	professorAtual.setId(professorAlterado.getId());
	professorAtual.setNome(professorAlterado.getNome());
	return salvar(professorAtual);
}


public void excluir (Integer idProfessor) {
	
	repo.deleteById(idProfessor);
}



}

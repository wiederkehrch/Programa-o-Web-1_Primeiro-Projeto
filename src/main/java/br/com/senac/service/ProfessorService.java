package br.com.senac.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.domain.Professor;
import br.com.senac.repository.ProfessorRepositorio;

@Service
public class ProfessorService {

	@Autowired
	ProfessorRepositorio repo;
	
	public Professor salvar (Professor prof) {
		
		return repo.save(prof);
	}
}

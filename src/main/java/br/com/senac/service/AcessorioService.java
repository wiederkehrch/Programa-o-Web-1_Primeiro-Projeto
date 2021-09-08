package br.com.senac.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.domain.Acessorio;
import br.com.senac.repository.AcessorioRepositorio;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class AcessorioService {
	
	@Autowired
	AcessorioRepositorio repo;
	
	
	public Acessorio search(Integer id) throws ObjectNotFoundException{
		
		Optional<Acessorio> acessorio = repo.findById(id);
		return acessorio.orElseThrow(() -> new ObjectNotFoundException ("Não encontrado. Id: " + id + ", Tipo!" + Acessorio.class.getName()));
	}
	
	
	public List<Acessorio> searchAll () {
		
		return repo.findAll();
	}
	
	
	public Acessorio save (Acessorio acessorio) {
		
		return repo.save(acessorio);
	}
	
	
	public List<Acessorio> saveAll (List<Acessorio> acessorios) {
		
		return repo.saveAll(acessorios);
	}
	
	
	public Acessorio edit (Acessorio acessorio) throws ObjectNotFoundException {
		
		Acessorio acessorioAntigo = search(acessorio.getId());
		acessorioAntigo.setNome(acessorio.getNome());
		return save(acessorioAntigo);
	}
	
	
	public void delete (Integer id) {
		
		repo.deleteById(id);
	}


}

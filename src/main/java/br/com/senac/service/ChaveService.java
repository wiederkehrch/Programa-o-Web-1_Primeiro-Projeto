package br.com.senac.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.domain.Chave;
import br.com.senac.repository.ChaveRepositorio;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class ChaveService {
	
	@Autowired
	ChaveRepositorio repo;
	
	
	public Chave search(Integer id) throws ObjectNotFoundException{
		
		Optional<Chave> chave = repo.findById(id);
		return chave.orElseThrow(() -> new ObjectNotFoundException ("Não encontrado. Id: " + id + ", Tipo!" + Chave.class.getName()));
	}
	
	
	public List<Chave> searchAll () {
		
		return repo.findAll();
	}
	
	
	public Chave save (Chave chave) {
		
		return repo.save(chave);
	}
	
	
	public List<Chave> saveAll (List<Chave> chaves) {
		
		return repo.saveAll(chaves);
	}
	
	
	public Chave edit (Chave chave) throws ObjectNotFoundException {
		
		Chave chaveAntiga = search(chave.getId());
		chaveAntiga.setCodigo(chave.getCodigo());
		return save(chaveAntiga);
	}
	
	
	public void delete (Integer id) {
		
		repo.deleteById(id);
	}

}

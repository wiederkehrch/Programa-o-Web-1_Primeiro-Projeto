package br.com.senac.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.domain.Fabricante;
import br.com.senac.repository.FabricanteRepositorio;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class FabricanteService {
	
	@Autowired
	FabricanteRepositorio repo;
	
	
	public Fabricante search(Integer id) throws ObjectNotFoundException{
		
		Optional<Fabricante> fabricante = repo.findById(id);
		return fabricante.orElseThrow(() -> new ObjectNotFoundException ("Não encontrado. Id: " + id + ", Tipo!" + Fabricante.class.getName()));
	}
	
	
	public List<Fabricante> searchAll () {
		
		return repo.findAll();
	}
	
	
	public Fabricante save (Fabricante fabricante) {
		
		return repo.save(fabricante);
	}
	
	
	public List<Fabricante> saveAll (List<Fabricante> fabricantes) {
		
		return repo.saveAll(fabricantes);
	}
	
	
	public Fabricante edit (Fabricante fabricante) throws ObjectNotFoundException {
		
		Fabricante fabricanteAntiga = search(fabricante.getId());
		fabricanteAntiga.setNome(fabricante.getNome());
		return save(fabricanteAntiga);
	}
	
	
	public void delete (Integer id) {
		
		repo.deleteById(id);
	}

}

package br.com.senac.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.domain.Carro;
import br.com.senac.repository.CarroRepositorio;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class CarroService {
	
	@Autowired
	CarroRepositorio repo;
	
	
	public Carro search(Integer id) throws ObjectNotFoundException{
		
		Optional<Carro> carro = repo.findById(id);
		return carro.orElseThrow(() -> new ObjectNotFoundException ("Não encontrado. Id: " + id + ", Tipo!" + Carro.class.getName()));
	}
	
	
	public List<Carro> searchAll () {
		
		return repo.findAll();
	}
	
	
	public Carro save (Carro carro) {
		
		return repo.save(carro);
	}
	
	
	public List<Carro> saveAll (List<Carro> carros) {
		
		return repo.saveAll(carros);
	}
	
	
	public Carro edit (Carro carro) throws ObjectNotFoundException {
		
		Carro carroAntigo = search(carro.getId());
		carroAntigo.setModelo(carro.getModelo());
		return save(carroAntigo);
	}
	
	
	public void delete (Integer id) {
		
		repo.deleteById(id);
	}


}

package br.com.senac.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.domain.Documento;
import br.com.senac.repository.DocumentoRepositorio;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class DocumentoService {
	
	
	@Autowired
	DocumentoRepositorio repo;
	
	
	public Documento search(Integer id) throws ObjectNotFoundException{
		
		Optional<Documento> documento = repo.findById(id);
		return documento.orElseThrow(() -> new ObjectNotFoundException ("Não encontrado. Id: " + id + ", Tipo!" + Documento.class.getName()));
	}
	
	
	public List<Documento> searchAll () {
		
		return repo.findAll();
	}
	
	
	public Documento save (Documento documento) {
		
		return repo.save(documento);
	}
	
	
	public List<Documento> saveAll (List<Documento> documentos) {
		
		return repo.saveAll(documentos);
	}
	
	
	public Documento edit (Documento documento) throws ObjectNotFoundException {
		
		Documento documentoAntigo = search(documento.getId());
		documentoAntigo.setNome(documento.getNome());
		documentoAntigo.setCodigo(documento.getCodigo());
		return save(documentoAntigo);
	}
	
	
	public void delete (Integer id) {
		
		repo.deleteById(id);
	}

}

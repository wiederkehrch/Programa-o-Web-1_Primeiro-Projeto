package br.com.senac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.domain.Chave;
import br.com.senac.domain.Documento;
import br.com.senac.service.ChaveService;
import br.com.senac.service.DocumentoService;
import javassist.tools.rmi.ObjectNotFoundException;

@Controller                          
@RequestMapping("/documento") 
public class DocumentoController {

	
	@Autowired
	private DocumentoService documentoService;
	
	
	@GetMapping ("/listar")
	public ModelAndView listarDocumentos() {
		
		ModelAndView mv = new ModelAndView("documento/listaDocumento");
		mv.addObject("documentos", documentoService.searchAll());
		return mv;
	}
	
	
	
	@GetMapping ("/cadastrar")
	public ModelAndView cadastrarDocumento() {
			
		ModelAndView mv = new ModelAndView("documento/cadastraDocumento");
		mv.addObject("documento", new Documento());
		return mv;
		}
	
	
	@PostMapping ("/salvar")
	public ModelAndView salvarDocumento( Documento documento) {
			
		documentoService.save(documento);
		return listarDocumentos();
	}
	
	
	@GetMapping ("/deletar/{id}")
	public ModelAndView deletarDocumento(@PathVariable("id") Integer id) {
				
		documentoService.delete(id);
		return listarDocumentos();
	}
	
	
	@GetMapping ("/alterar/{id}")
	public ModelAndView alterarDocumento(@PathVariable("id") Integer id) throws ObjectNotFoundException {
				
		ModelAndView mv = new ModelAndView("documento/alteraDocumento");
		mv.addObject("documento", documentoService.search(id));
		return mv;
	}
	
	
	@PostMapping ("/alterar")
	public ModelAndView alterar(Documento documento) throws ObjectNotFoundException {
			
		documentoService.edit(documento);
		return listarDocumentos();
	}
}

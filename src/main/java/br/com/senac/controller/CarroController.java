package br.com.senac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.domain.Carro;
import br.com.senac.service.CarroService;
import br.com.senac.service.ChaveService;
import br.com.senac.service.DocumentoService;
import br.com.senac.service.FabricanteService;
import javassist.tools.rmi.ObjectNotFoundException;

@Controller                          
@RequestMapping("/carro") 
public class CarroController {
	
	@Autowired
	private CarroService carroService;
	
	
	@Autowired
	private ChaveService chaveService;
	
	
	@Autowired
	private DocumentoService documentoService;
	
	
	@Autowired
	private FabricanteService fabricanteService;
	
	
	@GetMapping ("/listar")
	public ModelAndView listarCarros() {
		
		ModelAndView mv = new ModelAndView("carro/listaCarro");
		mv.addObject("carros", carroService.searchAll());
		return mv;
	}
	
	
	
	@GetMapping ("/cadastrar")
	public ModelAndView cadastrarCarro() {
			
		ModelAndView mv = new ModelAndView("carro/cadastraCarro");
		mv.addObject("chaves", chaveService.searchAll());
		mv.addObject("documentos", documentoService.searchAll());
		mv.addObject("fabricantes", fabricanteService.searchAll());
		mv.addObject("carro", new Carro());
		return mv;
		}
	
	
	@PostMapping ("/salvar")
	public ModelAndView salvarCarro( Carro carro) {
			
		carroService.save(carro);
		return listarCarros();
	}
	
	
	@GetMapping ("/deletar/{id}")
	public ModelAndView deletarCarro(@PathVariable("id") Integer id) {
				
		carroService.delete(id);
		return listarCarros();
	}
	
	
	@GetMapping ("/alterar/{id}")
	public ModelAndView alterarCarro(@PathVariable("id") Integer id) throws ObjectNotFoundException {
				
		ModelAndView mv = new ModelAndView("carro/alteraCarro");
		mv.addObject("carro", carroService.search(id));
		mv.addObject("chaves", chaveService.searchAll());
		mv.addObject("documentos", documentoService.searchAll());
		mv.addObject("fabricantes", fabricanteService.searchAll());
		return mv;
	}
	
	
	@PostMapping ("/alterar")
	public ModelAndView alterar(Carro carro) throws ObjectNotFoundException {
			
		carroService.edit(carro);
		return listarCarros();
	}

}

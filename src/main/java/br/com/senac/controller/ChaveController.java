package br.com.senac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.domain.Chave;
import br.com.senac.service.ChaveService;
import javassist.tools.rmi.ObjectNotFoundException;

@Controller                          
@RequestMapping("/chave") 
public class ChaveController {
	
	@Autowired
	private ChaveService chaveService;
	
	
	@GetMapping ("/listar")
	public ModelAndView listarChaves() {
		
		ModelAndView mv = new ModelAndView("chave/listaChave");
		mv.addObject("chaves", chaveService.searchAll());
		return mv;
	}
	
	
	
	@GetMapping ("/cadastrar")
	public ModelAndView cadastrarChave() {
			
		ModelAndView mv = new ModelAndView("chave/cadastraChave");
		mv.addObject("chave", new Chave());
		return mv;
		}
	
	
	@PostMapping ("/salvar")
	public ModelAndView salvarChave( Chave chave) {
			
		chaveService.save(chave);
		return listarChaves();
	}
	
	
	@GetMapping ("/deletar/{id}")
	public ModelAndView deletarChave(@PathVariable("id") Integer id) {
				
		chaveService.delete(id);
		return listarChaves();
	}
	
	
	@GetMapping ("/alterar/{id}")
	public ModelAndView alterarChave(@PathVariable("id") Integer id) throws ObjectNotFoundException {
				
		ModelAndView mv = new ModelAndView("chave/alteraChave");
		mv.addObject("chave", chaveService.search(id));
		return mv;
	}
	
	
	@PostMapping ("/alterar")
	public ModelAndView alterar(Chave chave) throws ObjectNotFoundException {
			
		chaveService.edit(chave);
		return listarChaves();
	}

}

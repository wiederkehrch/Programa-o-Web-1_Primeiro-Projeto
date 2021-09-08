package br.com.senac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.domain.Acessorio;
import br.com.senac.service.AcessorioService;
import javassist.tools.rmi.ObjectNotFoundException;

@Controller                          
@RequestMapping("/acessorio") 
public class AcessorioController {
	
	@Autowired
	private AcessorioService acessorioService;
	
	
	@GetMapping ("/listar")
	public ModelAndView listarAcessorios() {
		
		ModelAndView mv = new ModelAndView("acessorio/listaAcessorio");
		mv.addObject("acessorios", acessorioService.searchAll());
		return mv;
	}
	
	
	
	@GetMapping ("/cadastrar")
	public ModelAndView cadastrarAcessorio() {
			
		ModelAndView mv = new ModelAndView("acessorio/cadastraAcessorio");
		mv.addObject("acessorio", new Acessorio());
		return mv;
		}
	
	
	@PostMapping ("/salvar")
	public ModelAndView salvarAcessorio( Acessorio acessorio) {
			
		acessorioService.save(acessorio);
		return listarAcessorios();
	}
	
	
	@GetMapping ("/deletar/{id}")
	public ModelAndView deletarAcessorio(@PathVariable("id") Integer id) {
				
		acessorioService.delete(id);
		return listarAcessorios();
	}
	
	
	@GetMapping ("/alterar/{id}")
	public ModelAndView alterarAcessorio(@PathVariable("id") Integer id) throws ObjectNotFoundException {
				
		ModelAndView mv = new ModelAndView("acessorio/alteraAcessorio");
		mv.addObject("acessorio", acessorioService.search(id));
		return mv;
	}
	
	
	@PostMapping ("/alterar")
	public ModelAndView alterar(Acessorio acessorio) throws ObjectNotFoundException {
			
		acessorioService.edit(acessorio);
		return listarAcessorios();
	}

}

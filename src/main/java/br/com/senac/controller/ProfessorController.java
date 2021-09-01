package br.com.senac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.domain.Professor;
import br.com.senac.service.ProfessorService;
import javassist.tools.rmi.ObjectNotFoundException;

@Controller                         
@RequestMapping("professor") 
public class ProfessorController {
	
	
	@Autowired
	private ProfessorService professorService;
	
	
	@GetMapping ("/listarProfessor")
	public ModelAndView listaTodosProfessores() {
		
		
		ModelAndView mv = new ModelAndView("professor/paginaListaProfessores");
		mv.addObject("professores", professorService.buscarTodosProfessores());
		return mv;
	}
	
	
	//criar uma rota para chamar tela de cadastro
		@GetMapping ("/cadastrarProfessor")
		public ModelAndView cadastrarProfessor() {
			
			ModelAndView mv = new ModelAndView("professor/cadastraProfessor");
			mv.addObject("professor", new Professor());
			return mv;
		}
		
		
		//criar uma rota para incluir professor
		@PostMapping ("/salvarProfessor")
		public ModelAndView salvarProfessor(Professor professor) {
				
			professorService.salvar(professor);
			return listaTodosProfessores();
			}
		
		
		//criar uma rota para alterar professor
		@GetMapping ("/alterarProfessor/{id}")
		public ModelAndView alterarProfessor(@PathVariable("id") Integer idProfessor) throws ObjectNotFoundException {
					
			ModelAndView mv = new ModelAndView("professor/alterarProfessor");
			mv.addObject("professor", professorService.buscaPorId(idProfessor));
			return mv;
		}
		
		
		//criar uma rota para salvar professor alterado
			@PostMapping ("/alterarProfessor")
			public ModelAndView salvarAlteraProfessor(Professor professor) throws ObjectNotFoundException {
					
				professorService.salvarAlteracao(professor);
				return listaTodosProfessores();
			}
		
			
			//criar uma rota para excluir professor
			@GetMapping ("/excluirProfessor/{id}")
			public ModelAndView excluirProfessor(@PathVariable("id") Integer idProfessor) throws ObjectNotFoundException {
						
				professorService.excluir(idProfessor);
				return listaTodosProfessores();
			}


}

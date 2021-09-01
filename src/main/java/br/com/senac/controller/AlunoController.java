package br.com.senac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.domain.Aluno;
import br.com.senac.service.AlunoService;
import javassist.tools.rmi.ObjectNotFoundException;



@Controller                           //Definindo classe de controle
@RequestMapping("aluno")              //Definindo rota
public class AlunoController {
	
	
	@Autowired
	private AlunoService alunoService;
	
	//Get é quando chama direto da url
	//@GetMapping (path="/{listarAluno}")
	//ou
	@GetMapping ("/listarAluno")
	public ModelAndView listaTodosAlunos() {
		
		//ir para uma página html (criada na pasta aluno)
		ModelAndView mv = new ModelAndView("aluno/paginaListaAlunos");
		mv.addObject("alunos", alunoService.buscarTodosAlunos());
		return mv;
	}
	
	
	//criar uma rota para chamar tela de cadastro
	@GetMapping ("/cadastrarAluno")
	public ModelAndView cadastrarAluno() {
		
		ModelAndView mv = new ModelAndView("aluno/cadastraAluno");
		mv.addObject("aluno", new Aluno());
		return mv;
	}
	
	
	//criar uma rota para incluir aluno
	@PostMapping ("/salvarAluno")
	public ModelAndView salvarAluno(Aluno aluno) {
			
		alunoService.salvar(aluno);
		return listaTodosAlunos();
	}
	
	
	//criar uma rota para alterar aluno
	@GetMapping ("/alterarAluno/{id}")
	public ModelAndView alterarAluno(@PathVariable("id") Integer idAluno) throws ObjectNotFoundException {
				
		ModelAndView mv = new ModelAndView("aluno/alterarAluno");
		mv.addObject("aluno", alunoService.buscaPorId(idAluno));
		return mv;
	}
	
	
	//criar uma rota para salvar aluno alterado
		@PostMapping ("/alterarAluno")
		public ModelAndView salvarAlteraAluno(Aluno aluno) throws ObjectNotFoundException {
				
			alunoService.salvarAlteracao(aluno);
			return listaTodosAlunos();
		}
	
		
		//criar uma rota para excluir aluno
		@GetMapping ("/excluirAluno/{id}")
		public ModelAndView excluirAluno(@PathVariable("id") Integer idAluno) throws ObjectNotFoundException {
					
			alunoService.excluir(idAluno);
			return listaTodosAlunos();
		}

}

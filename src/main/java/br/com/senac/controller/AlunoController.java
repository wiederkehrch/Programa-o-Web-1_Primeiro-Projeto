package br.com.senac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.senac.domain.Aluno;
import br.com.senac.service.AlunoService;



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
	
	
	

}

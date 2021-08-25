package br.com.senac.inicializacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.com.senac.domain.Professor;
import br.com.senac.service.ProfessorService;

//Classe de teste
@Component
public class InitProfessor implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	ProfessorService professorService;
	
	@Override
	public void onApplicationEvent (ContextRefreshedEvent event) {
		
		Professor professor1 = new Professor();
		professor1.setNome("Carla");
		professorService.salvar(professor1);
		
		
		Professor professor2 = new Professor();
		professor2.setNome("João");
		professorService.salvar(professor2);
		
		
		Professor professor3 = new Professor();
		professor3.setNome("Claudia");
		professorService.salvar(professor3);
		
		
		List<Professor> listaProfessores = professorService.buscarTodosProfessores();
		
			for (Professor professor: listaProfessores) {
				System.out.println(professor.getNome());
			}
			
	}
}

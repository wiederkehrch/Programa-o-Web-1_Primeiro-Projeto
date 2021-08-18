package br.com.senac.inicializacao;

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
		
	}
}

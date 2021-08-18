package br.com.senac.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senac.domain.Aluno;


//Especificando que a interface é do tipo repositório. Ela vai ser responsável pela transação.
//Necessário também que especifique por qual objeto (tabela) a interface será responsável, e o tipo da chave primária.
@Repository
public interface AlunoRepositorio extends JpaRepository<Aluno, Integer> {

}

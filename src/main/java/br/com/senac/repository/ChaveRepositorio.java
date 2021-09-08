package br.com.senac.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senac.domain.Chave;


@Repository
public interface ChaveRepositorio extends JpaRepository <Chave, Integer> {

}

package br.com.senac.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senac.domain.Carro;

@Repository
public interface CarroRepositorio extends JpaRepository <Carro, Integer>  {

}

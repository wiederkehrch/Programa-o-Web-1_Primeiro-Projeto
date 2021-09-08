package br.com.senac.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senac.domain.Fabricante;

@Repository
public interface FabricanteRepositorio extends JpaRepository <Fabricante, Integer> {

}

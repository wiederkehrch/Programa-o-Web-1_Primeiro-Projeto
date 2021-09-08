package br.com.senac.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senac.domain.Documento;


@Repository
public interface DocumentoRepositorio extends JpaRepository <Documento, Integer> {

}

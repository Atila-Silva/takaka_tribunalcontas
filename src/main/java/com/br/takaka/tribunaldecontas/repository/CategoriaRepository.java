package com.br.takaka.tribunaldecontas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.takaka.tribunaldecontas.model.CategoriaModel;


@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaModel, Long>{

}

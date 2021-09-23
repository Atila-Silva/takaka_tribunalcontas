package com.br.takaka.tribunaldecontas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.takaka.tribunaldecontas.model.ItemModel;

public interface ItemRepository extends JpaRepository <ItemModel, Long> {

}
package com.br.fiap.takaka_tribunaldecontas.repository;
/*
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
*/
import org.springframework.data.jpa.repository.JpaRepository;

import com.br.fiap.takaka_tribunaldecontas.model.ItemAvaliadoModel;

public interface ItemAvaliadoRepository extends JpaRepository<ItemAvaliadoModel, Long> {
	/*
	@Query("SELECT p FROM ItemAvaliadoModel p WHERE p.categoria.nomeCategoria = ?")
	List<ItemAvaliadoModel> findExpensiveItensByCategoria(String nomeCategoria);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE ITENS_AVALIADOS SET ITEM_PERGUNTA = ?1 WHERE ID_ITEM", nativeQuery = true)
	void updateItemNome(String nome, Long id);
	
	@Transactional
	@Modifying
	@Query("DELETE ItemAvaliadoModel WHERE ID_ITEM = ?1")
	void deleteById(long id);
	*/
	
}

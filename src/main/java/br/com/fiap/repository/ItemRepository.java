package br.com.fiap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.fiap.model.ItemModel;

public interface ItemRepository extends JpaRepository <ItemModel, Long> {

}

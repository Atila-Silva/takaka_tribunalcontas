package com.br.takaka.tribunaldecontas.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.br.takaka.tribunaldecontas.model.ItemModel;
import com.br.takaka.tribunaldecontas.repository.CategoriaRepository;
import com.br.takaka.tribunaldecontas.repository.ItemRepository;

import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/item")
public class ItemController {
	@Autowired
	public ItemRepository repository;

	@Autowired
	public CategoriaRepository categoriaRepository;

	@GetMapping()
	@ApiOperation(value = "Lista de Itens")
	public ResponseEntity<List<ItemModel>> findAll(Model model) {

		List<ItemModel> itens = repository.findAll();
		return ResponseEntity.ok(itens);
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Avaliação por Item")
	public ResponseEntity<ItemModel> findById(@PathVariable("id") long id) {

		ItemModel itens = repository.findById(id).get();
		return ResponseEntity.ok(itens);
	}

	@PostMapping()
	@ApiOperation(value = "Salvar nova Item")
	public ResponseEntity<?> save(@RequestBody @Valid ItemModel itemModel, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return ResponseEntity.badRequest().build();
		}

		ItemModel item = repository.save(itemModel);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(item.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}
	@PutMapping("/{id}")
	@ApiOperation(value = "Alteração em Item")
	public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody @Valid ItemModel itemModel, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			return ResponseEntity.badRequest().build();
		}
		
		itemModel.setId(id);
		repository.save(itemModel);
//		produtoRepository.updateProductNameAndSku(produtoModel.getNome(), produtoModel.getSku(), produtoModel.getId());
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Excluir Item")
	public ResponseEntity<?> deleteById(@PathVariable("id") long id) {
		
		repository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/criaritem")
	@ApiOperation(value = "criar")
	public void criar() {
		repository.save(new ItemModel("nome da rua", categoriaRepository.getById((long) 1)));
		repository.save(new ItemModel("valor gasto", categoriaRepository.getById((long) 2)));
		repository.save(new ItemModel("aonde foi gasto", categoriaRepository.getById((long) 3)));
		repository.save(new ItemModel("tipo de serviço", categoriaRepository.getById((long) 4)));
		repository.save(new ItemModel("quando foi gasto", categoriaRepository.getById((long) 2)));
		repository.save(new ItemModel("telefone", categoriaRepository.getById((long) 1)));
	}

}

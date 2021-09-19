package com.br.fiap.takaka_tribunaldecontas.controller;

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

import com.br.fiap.takaka_tribunaldecontas.model.ItemAvaliadoModel;
import com.br.fiap.takaka_tribunaldecontas.repository.ItemAvaliadoRepository;


@RestController
@RequestMapping("/itens")
public class ItemAvaliadoController {
	
	@Autowired
	ItemAvaliadoRepository repository;
	
	@GetMapping()
	public ResponseEntity<List<ItemAvaliadoModel>> findAll (Model model){
		
		List<ItemAvaliadoModel> itens = repository.findAll();
		return ResponseEntity.ok(itens);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ItemAvaliadoModel> findById(@PathVariable("id") long id){
		
		ItemAvaliadoModel item = repository.findById(id).get();
		return ResponseEntity.ok(item);
		
	}
	
	@PostMapping()
	public ResponseEntity<?> save (@RequestBody @Valid ItemAvaliadoModel itemAvaliadoModel, BindingResult bindingResult ){
		
		if (bindingResult.hasErrors()) {
			return ResponseEntity.badRequest().build();
		}
		
		ItemAvaliadoModel item = repository.save(itemAvaliadoModel);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(item.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody @Valid ItemAvaliadoModel itemAvaliadoModel, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			return ResponseEntity.badRequest().build();
		}
		
		itemAvaliadoModel.setId(id);
		repository.save(itemAvaliadoModel);
		
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable("id") long id) {
		
		repository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	

}

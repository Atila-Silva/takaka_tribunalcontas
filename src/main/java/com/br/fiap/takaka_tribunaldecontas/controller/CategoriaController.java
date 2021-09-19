package com.br.fiap.takaka_tribunaldecontas.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

import com.br.fiap.takaka_tribunaldecontas.model.CategoriaModel;
import com.br.fiap.takaka_tribunaldecontas.repository.CategoriaRepository;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
	
	@Autowired
	CategoriaRepository categoriaRepository;
	
	@GetMapping()
	public ResponseEntity<List<CategoriaModel>> findAll() {
		
		
		List<CategoriaModel> categoria = categoriaRepository.findAll();
		return ResponseEntity.ok(categoria);
		
	}
	
	@GetMapping("/id")
	public ResponseEntity<CategoriaModel> findById(@PathVariable("id") long id){
		
		
		CategoriaModel categoria = categoriaRepository.getById(id);
		return ResponseEntity.ok(categoria);
		
	}
	
	@PostMapping()
	public ResponseEntity<?> save(@RequestBody @Valid CategoriaModel categoriaModel, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			return ResponseEntity.badRequest().build();
		}
		
		CategoriaModel categoria = categoriaRepository.save(categoriaModel);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/id")
				.buildAndExpand(categoria.getIdCategoria()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping("/id")
	public ResponseEntity<?> update (@PathVariable("id") long id, @RequestBody @Valid CategoriaModel categoriaModel, BindingResult bindingResult){
		if (bindingResult.hasErrors()) {
			return ResponseEntity.badRequest().build();
		}
		
		categoriaModel.setIdCategoria(id);
		categoriaRepository.save(categoriaModel);
		
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/id")
	public ResponseEntity<?> deleteById(@PathVariable("id") long id){
		
		categoriaRepository.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}
	
	public void add() {
		CategoriaModel cat = new CategoriaModel("INSTITUCIONAIS");
		System.out.println(cat.getNomeCategoria() + cat.getIdCategoria());
		categoriaRepository.save(cat);
		CategoriaModel cat1 = new CategoriaModel("CONTABEIS");
		System.out.println(cat1.getNomeCategoria() + cat1.getIdCategoria());
		categoriaRepository.save(cat1);
		CategoriaModel cat2 = new CategoriaModel("AGENTES_PUBLICOS");
		System.out.println(cat2.getNomeCategoria() + cat2.getIdCategoria());
		categoriaRepository.save(cat2);
		CategoriaModel cat3 = new CategoriaModel("ORCAMENTARIAS");
		System.out.println(cat3.getNomeCategoria() + cat3.getIdCategoria());
		categoriaRepository.save(cat3);
	}

}

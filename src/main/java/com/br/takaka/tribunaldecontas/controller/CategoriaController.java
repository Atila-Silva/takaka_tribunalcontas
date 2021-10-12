package com.br.takaka.tribunaldecontas.controller;

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

import com.br.takaka.tribunaldecontas.model.CategoriaModel;
import com.br.takaka.tribunaldecontas.repository.CategoriaRepository;

import io.swagger.annotations.ApiOperation;



@RestController
@RequestMapping("/categoria")
public class CategoriaController {

	@Autowired
	public CategoriaRepository repository;

	@GetMapping()
	@ApiOperation(value = "Lista de categoria")
	public ResponseEntity<List<CategoriaModel>> findAll() {

		List<CategoriaModel> categorias = repository.findAll();
		return ResponseEntity.ok(categorias);
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Categoria por ID")
	public ResponseEntity<CategoriaModel> findById(@PathVariable("id") long id) {

		CategoriaModel categoria = repository.findById(id).get();
		return ResponseEntity.ok(categoria);
	}

	@PostMapping()
	@ApiOperation(value = "Salvar nova categoria")
	public ResponseEntity<?> save(@RequestBody @Valid CategoriaModel categoriaModel, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return ResponseEntity.badRequest().build();
		}

		CategoriaModel categoria = repository.save(categoriaModel);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(categoria.getIdCategoria()).toUri();

		return ResponseEntity.created(location).build();
	}

	@PutMapping("/{id}")
	@ApiOperation(value = "Alteração em categoria")
	public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody @Valid CategoriaModel categoriaModel,
			BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return ResponseEntity.badRequest().build();
		}

		categoriaModel.setIdCategoria(id);
		repository.save(categoriaModel);

		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Excluir categoria")
	public ResponseEntity<?> deleteById(@PathVariable("id") long id) {

		repository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/criarcategoria")
	@ApiOperation(value = "criar")
	public void criar() {
		repository.save(new CategoriaModel("Endereço"));
		repository.save(new CategoriaModel("gastos"));
		repository.save(new CategoriaModel("custos"));
		repository.save(new CategoriaModel("serviços"));
	}
}
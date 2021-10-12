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

import com.br.takaka.tribunaldecontas.model.AvaliacaoModel;
import com.br.takaka.tribunaldecontas.repository.AvaliacaoRepository;
import com.br.takaka.tribunaldecontas.repository.MunicipioRepository;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/avaliacao")
public class AvaliacaoController {
	
	@Autowired
	public AvaliacaoRepository repository;
	
	@Autowired
	public MunicipioRepository municipioRepository;

	@GetMapping()
	@ApiOperation(value = "Lista de avaliação")
	public ResponseEntity<List<AvaliacaoModel>> findAll() {

		List<AvaliacaoModel> Avaliacoes = repository.findAll();
		return ResponseEntity.ok(Avaliacoes);
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Avaliação por ID")
	public ResponseEntity<AvaliacaoModel> findById(@PathVariable("id") long id) {

		AvaliacaoModel Avaliacao = repository.findById(id).get();
		return ResponseEntity.ok(Avaliacao);
	}

	@PostMapping()
	@ApiOperation(value = "Salvar nova avaliação")
	public ResponseEntity<?> save(@RequestBody @Valid AvaliacaoModel avaliacaoModel, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return ResponseEntity.badRequest().build();
		}

		AvaliacaoModel avaliacao = repository.save(avaliacaoModel);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(avaliacao.getId()).toUri();

		return ResponseEntity.created(location).build();
	}

	@PutMapping("/{id}")
	@ApiOperation(value = "Alteração na avaliação")
	public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody @Valid AvaliacaoModel avaliacaoModel,
			BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return ResponseEntity.badRequest().build();
		}

		avaliacaoModel.setId(id);
		repository.save(avaliacaoModel);

		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Excluir avaliação")
	public ResponseEntity<?> deleteById(@PathVariable("id") long id) {

		repository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/criaravaliacao")
	@ApiOperation(value = "criar")
	public void criar() {
		repository.save(new AvaliacaoModel(municipioRepository.findById((long) 123341).get()));
		repository.save(new AvaliacaoModel(municipioRepository.findById((long) 651655).get()));
		repository.save(new AvaliacaoModel(municipioRepository.findById((long) 984941).get()));
		repository.save(new AvaliacaoModel(municipioRepository.findById((long) 659812).get()));
	}

}

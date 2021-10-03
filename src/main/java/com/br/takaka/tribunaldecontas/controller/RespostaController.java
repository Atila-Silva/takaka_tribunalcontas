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

import com.br.takaka.tribunaldecontas.model.RespostaModel;
import com.br.takaka.tribunaldecontas.repository.AvaliacaoRepository;
import com.br.takaka.tribunaldecontas.repository.ItemRepository;
import com.br.takaka.tribunaldecontas.repository.RespostaRepository;
import com.br.takaka.tribunaldecontas.repository.UserAvaliadorRepository;

@RestController
@RequestMapping("/respostas")
public class RespostaController {
	
	@Autowired
	public RespostaRepository repository;
	
	@Autowired
	public UserAvaliadorRepository userAvaliadorRepository;
	
	@Autowired
	public AvaliacaoRepository avaliadorRepository;
	
	@Autowired
	public ItemRepository itemRepository;

	@GetMapping()
	public ResponseEntity<List<RespostaModel>> findAll() {

		List<RespostaModel> respostas = repository.findAll();
		return ResponseEntity.ok(respostas);
	}

	@GetMapping("/{id}")
	public ResponseEntity<RespostaModel> findById(@PathVariable("id") long id) {

		RespostaModel resposta = repository.findById(id).get();
		return ResponseEntity.ok(resposta);
	}

	@PostMapping()
	public ResponseEntity<?> save(@RequestBody @Valid RespostaModel respostaModel, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return ResponseEntity.badRequest().build();
		}

		RespostaModel resposta = repository.save(respostaModel);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(resposta.getId()).toUri();

		return ResponseEntity.created(location).build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody @Valid RespostaModel respostaModel,
			BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return ResponseEntity.badRequest().build();
		}

		respostaModel.setId(id);
		repository.save(respostaModel);

		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable("id") long id) {

		repository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/criarresposta")
	public void criar() {
		
		repository.save(new RespostaModel(userAvaliadorRepository.findById((long) 1).get(), avaliadorRepository.findById((long) 1).get(), itemRepository.findById((long) 1).get(), true));
		repository.save(new RespostaModel(userAvaliadorRepository.findById((long) 2).get(), avaliadorRepository.findById((long) 2).get(), itemRepository.findById((long) 2).get(), false));
		repository.save(new RespostaModel(userAvaliadorRepository.findById((long) 3).get(), avaliadorRepository.findById((long) 3).get(), itemRepository.findById((long) 3).get(), true));
		repository.save(new RespostaModel(userAvaliadorRepository.findById((long) 4).get(), avaliadorRepository.findById((long) 4).get(), itemRepository.findById((long) 4).get(), false));
		
	}
	

}

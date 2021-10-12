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

import com.br.takaka.tribunaldecontas.model.UserAvaliadorModel;
import com.br.takaka.tribunaldecontas.repository.UserAvaliadorRepository;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/useravaliador")
public class UserAvaliadorController {
	
	
	@Autowired
	public UserAvaliadorRepository repository;
		
	
	@GetMapping()
	@ApiOperation(value = "Lista de usuarios avaliação")
	public ResponseEntity<List<UserAvaliadorModel>> findAll(Model model){
		List<UserAvaliadorModel> users = repository.findAll();
		return ResponseEntity.ok(users);
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value = "Usuario avaliação por ID")
	public ResponseEntity<UserAvaliadorModel> findById(@PathVariable("id") long id) {

		UserAvaliadorModel user = repository.findById(id).get();
		return ResponseEntity.ok(user);
	}

	@PostMapping()
	@ApiOperation(value = "Salvar nova usuario avaliação")
	public ResponseEntity<?> save(@RequestBody @Valid UserAvaliadorModel userModel, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return ResponseEntity.badRequest().build();
		}

		UserAvaliadorModel user = repository.save(userModel);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}
	@PutMapping("/{id}")
	@ApiOperation(value = "Alteração na usuario avaliação")
	public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody @Valid UserAvaliadorModel userModel, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			return ResponseEntity.badRequest().build();
		}
		
		userModel.setId(id);
		repository.save(userModel);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Excluir usuario avaliação")
	public ResponseEntity<?> deleteById(@PathVariable("id") long id) {
		
		repository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/criaruserava")
	@ApiOperation(value = "criar")
	public void criaruser() {
		repository.save(new UserAvaliadorModel("atila", "atila@atila", "25123"));
		repository.save(new UserAvaliadorModel("jair", "jair@jair", "984984"));
		repository.save(new UserAvaliadorModel("ian", "ian@ian", "984915"));
		repository.save(new UserAvaliadorModel("carlos", "carlos@carlos", "6584984"));
		repository.save(new UserAvaliadorModel("leo", "leo@leo", "498459"));
		repository.save(new UserAvaliadorModel("carol", "carol@carol", "984951"));
	}

}

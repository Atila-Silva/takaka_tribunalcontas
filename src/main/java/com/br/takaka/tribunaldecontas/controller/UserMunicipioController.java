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

import com.br.takaka.tribunaldecontas.model.UserMunicipioModel;
import com.br.takaka.tribunaldecontas.repository.MunicipioRepository;
import com.br.takaka.tribunaldecontas.repository.UserMunicipioRepository;

@RestController
@RequestMapping("/usermunicipio")
public class UserMunicipioController {
	
	@Autowired
	public UserMunicipioRepository repository;
	
	@Autowired
	public MunicipioRepository municipioRepository;
	
	
	@GetMapping()
	public ResponseEntity<List<UserMunicipioModel>> findAll(Model model){
		List<UserMunicipioModel> users = repository.findAll();
		return ResponseEntity.ok(users);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserMunicipioModel> findById(@PathVariable("id") long id) {

		UserMunicipioModel user = repository.findById(id).get();
		return ResponseEntity.ok(user);
	}

	@PostMapping()
	public ResponseEntity<?> save(@RequestBody @Valid UserMunicipioModel userModel, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return ResponseEntity.badRequest().build();
		}

		UserMunicipioModel user = repository.save(userModel);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getIdUserMunicipio())
				.toUri();

		return ResponseEntity.created(location).build();
	}
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody @Valid UserMunicipioModel userModel, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			return ResponseEntity.badRequest().build();
		}
		
		userModel.setIdUserMunicipio(id);
		repository.save(userModel);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable("id") long id) {
		
		repository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
}

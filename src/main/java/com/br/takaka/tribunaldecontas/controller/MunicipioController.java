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

import com.br.takaka.tribunaldecontas.model.MunicipioModel;
import com.br.takaka.tribunaldecontas.repository.MunicipioRepository;

@RestController
@RequestMapping("/municipio")
public class MunicipioController {
	
	@Autowired
	public MunicipioRepository repository;
	
	@GetMapping()
	public ResponseEntity<List<MunicipioModel>> findAll() {

		List<MunicipioModel> municipios = repository.findAll();
		return ResponseEntity.ok(municipios);
	}

	@GetMapping("/{id}")
	public ResponseEntity<MunicipioModel> findById(@PathVariable("id") long id) {

		MunicipioModel municipio = repository.findById(id).get();
		return ResponseEntity.ok(municipio);
	}

	@PostMapping()
	public ResponseEntity<?> save(@RequestBody @Valid MunicipioModel municipioModel, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return ResponseEntity.badRequest().build();
		}

		MunicipioModel municipio = repository.save(municipioModel);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(municipio.getIbgeMunicipio()).toUri();

		return ResponseEntity.created(location).build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable("ibge") long ibge, @RequestBody @Valid MunicipioModel municipioModel,
			BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return ResponseEntity.badRequest().build();
		}

		municipioModel.setIbgeMunicipio(ibge);
		repository.save(municipioModel);

		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable("id") long id) {

		repository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/criarmunicipio")
	public void criaruser() {
		repository.save(new MunicipioModel(123341, "Maua", "www.maua"));
		repository.save(new MunicipioModel(651655, "Guarulhos", "www.Guarulhos"));
		repository.save(new MunicipioModel(984941, "bauru", "www.bauru"));
		repository.save(new MunicipioModel(659812, "osasco", "www.osasco"));
		repository.save(new MunicipioModel(984212, "santo andre", "www.santo"));
		
	}

}

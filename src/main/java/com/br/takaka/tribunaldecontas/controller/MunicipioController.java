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

import com.br.takaka.tribunaldecontas.business.MunicipioBusiness;
import com.br.takaka.tribunaldecontas.exception.ResponseBusinessException;
import com.br.takaka.tribunaldecontas.model.MunicipioModel;
import com.br.takaka.tribunaldecontas.repository.MunicipioRepository;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/municipio")
public class MunicipioController {
	
	@Autowired
	public MunicipioRepository repository;
	
	@Autowired
	public MunicipioBusiness municipiosBusiness;
	
	@GetMapping()
	@ApiOperation(value = "Lista de municipios")
	public ResponseEntity<List<MunicipioModel>> findAll() {

		List<MunicipioModel> municipios = repository.findAll();
		return ResponseEntity.ok(municipios);
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Municipios por ID")
	public ResponseEntity<MunicipioModel> findById(@PathVariable("id") long id) {

		MunicipioModel municipio = repository.findById(id).get();
		return ResponseEntity.ok(municipio);
	}

	@PostMapping()
	@ApiOperation(value = "Salvar novo municipios")
	public ResponseEntity<?> save(@RequestBody @Valid MunicipioModel municipioModel, BindingResult bindingResult) throws ResponseBusinessException {

		MunicipioModel municipio = municipiosBusiness.applyBusiness(municipioModel);

		repository.save(municipio);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(municipio.getIbgeMunicipio()).toUri();

		return ResponseEntity.created(location).build();
	}

	@PutMapping("/{id}")
	@ApiOperation(value = "Alte��o no municipios")
	public ResponseEntity<?> update(@PathVariable("id") long ibge, @RequestBody @Valid MunicipioModel municipioModel) throws ResponseBusinessException {

		MunicipioModel municipio = municipiosBusiness.applyBusiness(municipioModel);

		municipio.setIbgeMunicipio(ibge);
		repository.save(municipio);

		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Excluir municipios")
	public ResponseEntity<?> deleteById(@PathVariable("id") long id) {

		repository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/criarmunicipio")
	@ApiOperation(value = "criar")
	public void criaruser() {
	
	}
	


}

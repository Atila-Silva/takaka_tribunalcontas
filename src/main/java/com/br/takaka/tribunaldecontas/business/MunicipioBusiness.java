package com.br.takaka.tribunaldecontas.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.br.takaka.tribunaldecontas.model.MunicipioModel;
import com.br.takaka.tribunaldecontas.repository.MunicipioRepository;

@Component
public class MunicipioBusiness {
	
	@Value("${rest.exception.business.contains-teste}")
	private String containsTeste;
	
	@Autowired
	public MunicipioRepository municipioRepository;
	
	public MunicipioModel applyBusiness(MunicipioModel municipio) {
		
		String nome = changeNomeToUpperCase(municipio.getNomeMunicipio());
		municipio.setNomeMunicipio(nome);
		
		return municipio;
		
	}
	
	protected String changeNomeToUpperCase(String nome) {
		return nome.toUpperCase();
	}
}

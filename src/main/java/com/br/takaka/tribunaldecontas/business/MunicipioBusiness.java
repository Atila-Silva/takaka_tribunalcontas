package com.br.takaka.tribunaldecontas.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.br.takaka.tribunaldecontas.model.MunicipioModel;
import com.br.takaka.tribunaldecontas.repository.MunicipioRepository;
import com.br.takaka.tribunaldecontas.exception.ResponseBusinessException;

@Component
public class MunicipioBusiness {
	
	
	private String containsTeste;
	
	@Autowired
	public MunicipioRepository municipioRepository;
	
	public MunicipioModel applyBusiness(MunicipioModel municipio) throws ResponseBusinessException {
		
		String nome = changeNomeToUpperCase(municipio.getNomeMunicipio());
		municipio.setNomeMunicipio(nome);
		
		verifyNomeMunicipio(municipio.getNomeMunicipio());
		
		return municipio;
		
	}
	
	protected String changeNomeToUpperCase(String nome) {
		return nome.toUpperCase();
	}
	
	protected void verifyNomeMunicipio(String nome) throws ResponseBusinessException {
		
		String nomeMunicipio = nome.toUpperCase();
		
		if(nomeMunicipio.contains("TESTE")) {
			throw new ResponseBusinessException(containsTeste);
		}
		
	}
}

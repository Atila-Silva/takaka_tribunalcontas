package com.br.takaka.tribunaldecontas.business;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import com.br.takaka.tribunaldecontas.exception.ResponseBusinessException;
import com.br.takaka.tribunaldecontas.model.MunicipioModel;


@SpringBootTest
public class MunicipioBusinessTest {
	
	@InjectMocks
	public MunicipioBusiness municipioBusiness;
	
	
	@Test
	public void testChangeNomeToUpperCase() {
		
		String nome = "maua";
		String expected = "MAUA";
		
		String actual = municipioBusiness.changeNomeToUpperCase(nome);
		
		assertEquals(expected, actual);
	}
	
	@Test()
	public void testVerifiyNomeProdutoWithTeste() throws ResponseBusinessException {

		// GIVEN
		String nomeMunicipio = "Municipio";

		// WHEN
		municipioBusiness.verifyNomeMunicipio(nomeMunicipio);
	}
	
	@Test()
	public void testVerifiyNomeProdutoWithoutTeste() throws ResponseBusinessException {

		// GIVEN
		String nomeMunicipio = "Municipio";

		// WHEN
		municipioBusiness.verifyNomeMunicipio(nomeMunicipio);
	}
	@Test
	public void testeApplyBusiness() throws ResponseBusinessException{
		

		MunicipioModel municipioModel = new MunicipioModel(651655, "Guarulhos", "www.Guarulhos");
		MunicipioModel expected = new MunicipioModel(651655, "GUARULHOS", "www.Guarulhos");
		
		MunicipioModel actual = municipioBusiness.applyBusiness(municipioModel);
		
		assertEquals(expected.getNomeMunicipio(), actual.getNomeMunicipio());
		
	}
	

}

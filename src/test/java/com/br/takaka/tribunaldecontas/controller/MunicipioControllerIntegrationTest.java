package com.br.takaka.tribunaldecontas.controller;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;




import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.br.takaka.tribunaldecontas.TribunaldecontasApplication;



@SpringBootTest(classes = TribunaldecontasApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class MunicipioControllerIntegrationTest {
	@Autowired
	private MockMvc mvc;
	

	
	@Test
	@DisplayName("Busca todas os Municipios!")
	void shouldFindAllMunicipio() throws Exception{
		
		mvc.perform(get("/municipio")
				.contentType(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON));
		
	}
	

	
	@Test
	@DisplayName("Deve retornar uma municipio pelo ID e com status 200")
	public void shouldFindCategoryById() throws Exception {
		
		mvc.perform(get("/municipio/651655")
				.contentType(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON));
		
		
	}
	
	@Test
	@DisplayName("Deve salvar um Municipio, retornar status 201 e Location no Header")
	public void shouldSaveCategory() throws Exception {
		
		mvc.perform(post("/municipio")
			.contentType(MediaType.APPLICATION_JSON)
			.content("{\"ibgeMunicipio\": 984814,\"nomeMunicipio\":\"Mogi\",\"urlMunicipio\":\"www.Mogi\",\"dataCadastro\":\"2021-10-18T20:15:11\"}"))
			.andDo(print())
			.andExpect(status().isCreated())
			.andExpect(header().exists("Location"));
	}
	
	@Test
	@DisplayName("Deve atualizar um municipio pelo id e retornar status 200")
	public void shouldUpdateCategory() throws Exception {
		
		mvc.perform(put("/984814")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"nomeMunicipio\":\"Mogi atualizado\",\"urlMunicipio\":\"www.Mogi\"}"))
				.andDo(print())
				.andExpect(status().isOk());
	}
	
	@Test
	@DisplayName("Deve deletar uma municipio pelo id e retornar status 204")
	public void shouldDeleteCategoryById() throws Exception {
		
		mvc.perform(delete("/municipio/659812")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNoContent());
	}
	

}

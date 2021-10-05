package com.br.takaka.tribunaldecontas.model;



import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "MUNICIPIO")
public class MunicipioModel {
	
	private long ibgeMunicipio;
	private String nomeMunicipio;
	private String urlMunicipio;
	private LocalDateTime dataCadastro = LocalDateTime.now();

	
	public MunicipioModel() {	}
 
	public MunicipioModel(long ibgeMunicipio, String nomeMunicipio, String urlMunicipio) {
		super();
		this.ibgeMunicipio = ibgeMunicipio;
		this.nomeMunicipio = nomeMunicipio;
		this.urlMunicipio = urlMunicipio;
	}

	@Id
	@Column(name = "IBGE_MUNICIPIO")
	public long getIbgeMunicipio() {
		return ibgeMunicipio;
	}


	public void setIbgeMunicipio(long ibgeMunicipio) {
		this.ibgeMunicipio = ibgeMunicipio;
	}


	@Column(name = "NOME_MUNICIPIO")
	@NotNull(message = "nome obrigatória")
	@Size(min = 2, max = 50, message = "o NOME deve ser entre 2 e 50 caracteres")
	public String getNomeMunicipio() {
		return nomeMunicipio;
	}


	public void setNomeMunicipio(String nomeMunicipio) {
		this.nomeMunicipio = nomeMunicipio;
	}


	@Column(name = "URL_MUNICIPIO")
	@Size(min = 2, max = 50, message = "A url deve ser entre 2 e 50 caracteres")
	public String getUrlMunicipio() {
		return urlMunicipio;
	}
	

	public void setUrlMunicipio(String urlMunicipio) {
		this.urlMunicipio = urlMunicipio;
	}
	
	@Column(name = "DATA_CADASTRO")
	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	
	
	
	

}

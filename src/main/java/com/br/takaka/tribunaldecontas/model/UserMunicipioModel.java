package com.br.takaka.tribunaldecontas.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModelProperty;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "USER_MUNICIPIO")
public class UserMunicipioModel {
	
	private long idUserMunicipio;
	private String nomeUserMunicipio;
	private String emailUserMunicipio;
	private String senhaUserMunicipio;
	private LocalDateTime dataCadastro;

	private MunicipioModel municipio;
	
	
	
	public UserMunicipioModel() {	}


	public UserMunicipioModel(String nomeUserMunicipio, String emailUserMunicipio, String senhaUserMunicipio, MunicipioModel municipio) {
		super();
		this.nomeUserMunicipio = nomeUserMunicipio;
		this.emailUserMunicipio = emailUserMunicipio;
		this.senhaUserMunicipio = senhaUserMunicipio;
		this.municipio = municipio;
		this.dataCadastro = LocalDateTime.now();
	}

	@Id
	@Column(name = "ID_USER_MUNICIPIO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_MUN_SEQ")
	@SequenceGenerator(name = "USER_MUN_SEQ", sequenceName = "USER_MUN_SEQ", allocationSize = 1)
	@ApiModelProperty(value = "ID do usuario municipio")
	public long getIdUserMunicipio() {
		return idUserMunicipio;
	}
	
	


	
	public void setIdUserMunicipio(long idUserMunicipio) {
		this.idUserMunicipio = idUserMunicipio;
	}


	@Column(name = "NOME_USER_MUNICIPIO")
	@NotNull(message = "Nome obrigatório")
	@Size(min = 2, max = 50, message = "NOME deve ser entre 2 e 40 caracteres")
	@ApiModelProperty(value = "Nome do usuario municipio")
	public String getNomeUserMunicipio() {
		return nomeUserMunicipio;
	}


	public void setNomeUserMunicipio(String nomeUserMunicipio) {
		this.nomeUserMunicipio = nomeUserMunicipio;
	}


	@Column(name = "EMAIL_USER_MUNICIPIO")
	@NotNull(message = "email obrigatório")
	@Size(min = 2, max = 50, message = "Email deve ser entre 2 e 40 caracteres")
	@ApiModelProperty(value = "Email do usuario municipio")
	public String getEmailUserMunicipio() {
		return emailUserMunicipio;
	}


	public void setEmailUserMunicipio(String emailUserMunicipio) {
		this.emailUserMunicipio = emailUserMunicipio;
	}


	@Column(name = "SENHA_USER_MUNICIPIO")
	@NotNull(message = "senha obrigatório")
	@Size(min = 2, max = 50, message = "Senha deve ser entre 2 e 40 caracteres")
	@ApiModelProperty(value = "Senha do usuario municipio")
	public String getSenhaUserMunicipio() {
		return senhaUserMunicipio;
	}


	public void setSenhaUserMunicipio(String senhaUserMunicipio) {
		this.senhaUserMunicipio = senhaUserMunicipio;
	}

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IBGE_MUNICIPIO", nullable = false )
	@ApiModelProperty(value = "Municipio do usuario municipio")
   public MunicipioModel getMunicipio() {
		return municipio;
	}


	public void setMunicipio(MunicipioModel municipio) {
		this.municipio = municipio;
	}
	
	@Column(name = "DATA_CADASTRO")
	@ApiModelProperty(value = "Data de cadastro do usuario municipio")
	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}


	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}


	
	
	
	
	
	
	

}

package com.br.takaka.tribunaldecontas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "USER_AVALIADOR")
public class UserAvaliadorModel {
	
	private long id;
	private String nome;
	private String email;
	private String senha;
	
	public UserAvaliadorModel() {	}
	
	
	
	public UserAvaliadorModel(String nome, String email, String senha) {
		super();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}



	@Id
	@Column(name = "ID_AVALIADOR")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_AVA_SEQ")
	@SequenceGenerator(name = "USER_AVA_SEQ", sequenceName = "USER_MUN_SEQ", allocationSize = 1)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "NOME_AVALIADOR")
	@NotNull(message = "Nome obrigatório")
	@Size(min = 2, max = 50, message = "NOME deve ser entre 2 e 40 caracteres")
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Column(name = "EMAIL_AVALIADOR")
	@NotNull(message = "Email obrigatório")
	@Size(min = 2, max = 50, message = "Email deve ser entre 2 e 40 caracteres")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name = "SENHA_AVALIADOR")
	@NotNull(message = "Senha obrigatório")
	@Size(min = 2, max = 8, message = "Senha deve ser entre 2 e 8 caracteres")
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}

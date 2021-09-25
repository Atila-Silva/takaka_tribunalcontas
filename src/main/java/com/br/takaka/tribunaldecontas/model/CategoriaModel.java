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
@Table(name = "TB_CATEGORIA")
public class CategoriaModel {

	private long idCategoria;
	private String nomeCategoria;

	public CategoriaModel() {
	}

	public CategoriaModel( String nomeCategoria) {
		super();
		this.nomeCategoria = nomeCategoria;
	}

	@Id
	@Column(name = "ID_CATEGORIA")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CATEGORIA_SEQ")
	@SequenceGenerator(name = "CATEGORIA_SEQ", sequenceName = "CATEGORIA_SEQ", allocationSize = 1)
	public long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(long idCategoria) {
		this.idCategoria = idCategoria;
	}

	@Column(name = "NOME_CATEGORIA")
	@NotNull(message = "Nome obrigat�rio")
	@Size(min = 2, max = 50, message = "NOME deve ser entre 2 e 40 caracteres")
	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}


}

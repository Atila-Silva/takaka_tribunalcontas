package com.br.takaka.tribunaldecontas.model;

import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "ITENS_AVALIADOS")
public class ItemModel {
	
	@Id
	@Column(name = "ID_ITEM")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	
	@Column(name = "ITEM_PERGUNTA")
	@NotNull(message = "Pergunta obrigatória")
	@Size(min = 2, max = 50, message = "A pergunta deve ser entre 2 e 100 caracteres")
	private String pergunta;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CATEGORIA", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT) )
    private CategoriaModel categoria;
   

    public ItemModel() {
	}


	public ItemModel(String pergunta, CategoriaModel categoria) {
		super();
		this.pergunta = pergunta;
		this.categoria = categoria;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getPergunta() {
		return pergunta;
	}


	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}


	public CategoriaModel getCategoria() {
		return categoria;
	}


	public void setCategoria(CategoriaModel categoria) {
		this.categoria = categoria;
	}

	
	
	
    
}


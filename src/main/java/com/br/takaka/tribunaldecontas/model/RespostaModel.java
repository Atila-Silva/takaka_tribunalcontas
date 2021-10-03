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

@Entity
@Table(name = "RESPOSTA")
public class RespostaModel {

	private Long id;
	private UserAvaliadorModel UserAvaliador;
	private AvaliacaoModel avaliacao;
	private ItemModel itemAvaliacao;
	private boolean cumprir;
	private LocalDateTime dataResposta;
	
	public RespostaModel() { }

	public RespostaModel(UserAvaliadorModel userAvaliador, AvaliacaoModel avaliacao, ItemModel itemAvaliacao,
			boolean cumprir) {
		UserAvaliador = userAvaliador;
		this.avaliacao = avaliacao;
		this.itemAvaliacao = itemAvaliacao;
		this.cumprir = cumprir;
		this.dataResposta = LocalDateTime.now();
	}
	
	
	
	@Id
	@Column(name = "ID_RESPOSTA")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RES_ID_SEQ")
	@SequenceGenerator(name = "RES_ID_SEQ", sequenceName = "RES_ID_SEQ", allocationSize = 1)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_USER_MUNICIPIO", nullable = false )
	public UserAvaliadorModel getUserAvaliador() {
		return UserAvaliador;
	}

	public void setUserAvaliador(UserAvaliadorModel userAvaliador) {
		UserAvaliador = userAvaliador;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_AVALIACAO", nullable = false )
	public AvaliacaoModel getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(AvaliacaoModel avaliacao) {
		this.avaliacao = avaliacao;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_ITEM", nullable = false )
	public ItemModel getItemAvaliacao() {
		return itemAvaliacao;
	}

	public void setItemAvaliacao(ItemModel itemAvaliacao) {
		this.itemAvaliacao = itemAvaliacao;
	}
	
	@Column(name = "CUMPRIR")
	public boolean isCumprir() {
		return cumprir;
	}

	public void setCumprir(boolean cumprir) {
		this.cumprir = cumprir;
	}
	
	@Column(name = "DATA_CADASTRO")
	public LocalDateTime getDataResposta() {
		return dataResposta;
	}

	public void setDataResposta(LocalDateTime dataResposta) {
		this.dataResposta = dataResposta;
	}


	
}

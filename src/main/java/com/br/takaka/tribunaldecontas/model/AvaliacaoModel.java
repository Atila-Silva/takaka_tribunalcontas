package com.br.takaka.tribunaldecontas.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModelProperty;


@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "AVALIACAO")
public class AvaliacaoModel {
	
	private Long id;
	private MunicipioModel municipio;
	private LocalDateTime dataAvaliacao;
	private List<RespostaModel> respostas = new ArrayList<RespostaModel>();
	
	public AvaliacaoModel() { }

	public AvaliacaoModel(MunicipioModel municipio) {
		super();
		this.municipio = municipio;
		this.dataAvaliacao = LocalDateTime.now();
	}

	@Id
	@Column(name = "ID_AVALIACAO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AVALIACAO_SEQ")
	@SequenceGenerator(name = "AVALIACAO_SEQ", sequenceName = "AVALIACAO_SEQ", allocationSize = 1)
	@ApiModelProperty(value = "ID da Avaliação")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IBGE_MUNICIPIO", nullable = false )
	@ApiModelProperty(value = "Municipio da Avaliação")
	public MunicipioModel getMunicipio() {
		return municipio;
	}

	public void setMunicipio(MunicipioModel municipio) {
		this.municipio = municipio;
	}
	
	
	@OneToMany(mappedBy = "avaliacao", cascade = CascadeType.ALL)
	@ApiModelProperty(value = "Lista de resposta da avaliações")
	public List<RespostaModel> getRespostas() {
		return respostas;
	}
	
	
	
	public void setRespostas(List<RespostaModel> respostas) {
		this.respostas = respostas;
	}

	public void setRespostas(RespostaModel respostas) {
		this.respostas.add(respostas);
		
	}

	@Column(name = "DATA_AVALIACAO")
	@ApiModelProperty(value = "Data da Avaliação")
	public LocalDateTime getDataAvaliacao() {
		return dataAvaliacao;
	}

	public void setDataAvaliacao(LocalDateTime dataAvaliacao) {
		this.dataAvaliacao = dataAvaliacao;
	}


}

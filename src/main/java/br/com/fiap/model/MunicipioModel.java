package br.com.fiap.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "TB_MUNICIPIO")
public class MunicipioModel {
	private long id;
	private String nome;
	private String url;
	private String data_mun;
	
	public MunicipioModel(String nome, String url) {
		super();
		this.nome = nome;
		this.url = url;
	}
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUTO_SEQ")
	@SequenceGenerator(name = "PRODUTO_SEQ", sequenceName = "PRODUTO_SEQ", allocationSize = 1)
	public long getId() {
		return id;
	}



	

	
	
}

package br.com.fiap.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "ITENS_AVALIADOS")
public class ItemModel {
	private long id;
	private String pergunta;
    private CategoriaModel categoria;
   

    public ItemModel() {
	}


	public ItemModel(String pergunta, CategoriaModel categoria) {
		super();
		this.pergunta = pergunta;
		this.categoria = categoria;
	}

	@Column(name = "NOME")
	@NotNull(message = "Pergunta obrigat�ria")
	@Size(min = 2, max = 50, message = "A pergunta deve ser entre 2 e 100 caracteres")
	public String getPergunta() {
		return pergunta;
	}


	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}
	@ManyToOne()
	@JoinColumn(name = "ID_CATEGORIA", nullable = false)
   public CategoriaModel getCategoria() {
		return categoria;
	}

    @Id
	@Column(name = "ID_ITEM")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUTO_SEQ")
	@SequenceGenerator(name = "PRODUTO_SEQ", sequenceName = "PRODUTO_SEQ", allocationSize = 1)
    public long getId() {
	return id;
    }


   public void setId(long id) {
	this.id = id;
   } 
	
	
    
}
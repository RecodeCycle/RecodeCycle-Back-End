package br.com.recodecycle.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "postagens")
public class Postagem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Size(min = 5, max = 500)
	private String titulo;
	
	@NotNull
	@Size(min = 5, max = 5000)
	private String texto;
	
	@Temporal(TemporalType.TIMESTAMP)
    private Date date = new java.sql.Date(System.currentTimeMillis());
    
	@NotNull
	@Size(min = 5, max = 255)
	private String regioes;
	
	@NotNull
	@Size(min = 5, max = 255)
	private String residuos;
	
	
	@Size(min = 5, max = 500)
	private String informativos;
	
	private int curtidas;
	
	@ManyToOne()
	@JsonIgnoreProperties("postagem")
	private Categoria categoria;
	
	@ManyToOne	
	@JsonIgnoreProperties("postagem")
	private Usuario usuario;


	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getRegioes() {
		return regioes;
	}

	public void setRegioes(String regioes) {
		this.regioes = regioes;
	}

	public String getResiduos() {
		return residuos;
	}

	public void setResiduos(String residuos) {
		this.residuos = residuos;
	}

	public String getInformativos() {
		return informativos;
	}

	public void setInformativos(String informativos) {
		this.informativos = informativos;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public int getCurtidas() {
		return curtidas;
	}

	public void setCurtidas(int curtidas) {
		this.curtidas = curtidas;
	}
	
}

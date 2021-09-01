package br.com.recodecycle.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Size(min = 5, max =100, message = "Nome Obrigatório")
	private String nome;
	
	@NotNull
	@Email
	@Size(min = 5, max =50, message = "Email Obrigatório")
	private String email;
	
	@NotNull
	@Size(min = 5, message = "Senha Obrigatório")
	private String senha;
	
	@Size(min = 5, max =500)
	private String biografia;
	
	@Size(min = 5, max =255)
	private String telefone;
	
	@Size(min = 5, max =255)
	private String recebaEmail;
	
	@Size(min = 5, max =255)
	private String fotoPerfil;
	
	@Size(min = 5, max = 20)
	private String admin;
	
	private int nivel;
	
	@OneToMany(mappedBy="usuario", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("usuario")
	private List<Postagem> postagem;
	
	public Usuario(long id, String nome, String usuario, String senha, LocalDate dataNascimento) {
		this.id = id;
		this.nome = nome;
		this.email = usuario;
		this.senha = senha;
		
	}

	
	public List<Postagem> getPostagem() {
		return postagem;
	}

	public void setPostagem(List<Postagem> postagem) {
		this.postagem = postagem;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getRecebaEmail() {
		return recebaEmail;
	}

	public void setRecebaEmail(String recebaEmail) {
		this.recebaEmail = recebaEmail;
	}

	public String getFotoPerfil() {
		return fotoPerfil;
	}

	public void setFotoPerfil(String fotoPerfil) {
		this.fotoPerfil = fotoPerfil;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBiografia() {
		return biografia;
	}

	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}

	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}
	

}

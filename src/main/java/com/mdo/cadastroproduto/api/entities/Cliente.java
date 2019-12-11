package com.mdo.cadastroproduto.api.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="cliente")
public class Cliente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private String email;
	private String senha;
	private String rua;
	private String cidade;
	private String bairro;
	private String estado;
	private String cep;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	
	@Column(name="nome")
	public String getNome() {
		return nome;
	}
	
	@Column(name="email")
	public String getEmail() {
		return email;
	}
	
	@Column(name="senha")
	public String getSenha() {
		return senha;
	}
	
	@Column(name="rua")
	public String getRua() {
		return rua;
	}
	
	@Column(name="cidade")
	public String getCidade() {
		return cidade;
	}
	
	@Column(name="bairro")
	public String getBairro() {
		return bairro;
	}
	
	@Column(name="estado")
	public String getEstado() {
		return estado;
	}
	
	@Column(name="cep")
	public String getCep() {
		return cep;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

}

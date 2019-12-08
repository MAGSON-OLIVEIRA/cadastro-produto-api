package com.mdo.cadastroproduto.api.entities;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.mdo.cadastroproduto.api.enums.CategoriaEnum;

@Entity
@Table(name="produto")
public class Produto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private CategoriaEnum categoria;
	private String produto;
	private Double preco;
	private Integer quantidade;
	private String descricao;
	private String foto;
	
	public Produto() {
		
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	
//	@PreUpdate
//	public void preUpdate() {
//		dataAtualizacao = new Date();
//	}
//	
//	@PrePersist
//	public void prePresist() {
//		final Date atual = new Date();
//		dataCriacao = atual;
//		dataAtualizacao = atual;
//	}
	
	

	@Column(name="produto", nullable = false)
	public String getProduto() {
		return produto;
	}

	@Column(name="categoria", nullable = false)
	public CategoriaEnum getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaEnum categoria) {
		this.categoria = categoria;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	@Column(name="preco", nullable = false)
	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	@Column(name="preco", nullable = false)
	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	@Column(name="preco", nullable = false)
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Column(name="preco", nullable = false)
	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

}

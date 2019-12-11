package com.mdo.cadastroproduto.api.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.mdo.cadastroproduto.api.enums.CategoriaEnum;

public class ProdutoDto {
	
	private Long codigo;
	private CategoriaEnum categoria;
	private String produto;
	private Double preco;
	private Integer quantidade;
	private String descricao;
	private String foto;
	
	public ProdutoDto(){
		
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public CategoriaEnum getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaEnum categoria) {
		this.categoria = categoria;
	}

	@NotEmpty(message = "Informe a descrição do produto")
	@Length(min=3, max=200, message="")
	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	@NotNull (message = "O preço do produto tem que ser informado")
	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Integer getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}


	@NotEmpty(message = "")
	@Length(min=3, max=500, message="")
	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public String getFoto() {
		return foto;
	}


	public void setFoto(String foto) {
		this.foto = foto;
	}

	@Override
	public String toString() {
		return "ProdutoDto [codigo=" + codigo + ", categoria=" + categoria + ", produto=" + produto + ", preco=" + preco
				+ ", quantidade=" + quantidade + ", descricao=" + descricao + ", foto=" + foto + "]";
	}

}

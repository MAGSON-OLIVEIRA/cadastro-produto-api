package com.mdo.cadastroproduto.api.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name = "pedidoitem")
public class PedidoItem {
	
	@EmbeddedId
	private PedidoItemPK chavePrimaria;
	
	private String descProduto;
	private Integer quantidade;
	private Double valor;
	
	@Transient
	private Double subtotal;
	
	@Column(name="quantidade")
	public Integer getQuantidade() {
		return quantidade;
	}
	
	@Column(name="descProduto")
	public String getDescProduto() {
		return descProduto;
	}
	
	@Column(name="valor")
	public Double getValor() {
		return valor;
	}
	
	
	public PedidoItemPK getChavePrimaria() {
		return chavePrimaria;
	}
	
	public Double getSubtotal() {
		return subtotal;
	}

	public void setChavePrimaria(PedidoItemPK chavePrimaria) {
		this.chavePrimaria = chavePrimaria;
	}

	public void setDescProduto(String descProduto) {
		this.descProduto = descProduto;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}


}

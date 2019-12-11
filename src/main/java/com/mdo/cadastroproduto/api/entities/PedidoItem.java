package com.mdo.cadastroproduto.api.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name = "pedidoitem")
public class PedidoItem {
	
	private Long id;
	private Produto produto;
	private Pedido pedido;
	private String descProduto;
	private Integer quantidade;
	private Double valor;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_produto")
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_pedido")
	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	@Transient
	private Double subtotal;
	
	@Column(name="quantidade")
	public Integer getQuantidade() {
		return quantidade;
	}
	
	@Column(name="desc_produto")
	public String getDescProduto() {
		return descProduto;
	}
	
	@Column(name="valor")
	public Double getValor() {
		return valor;
	}
	
	public Double getSubtotal() {
		return subtotal;
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

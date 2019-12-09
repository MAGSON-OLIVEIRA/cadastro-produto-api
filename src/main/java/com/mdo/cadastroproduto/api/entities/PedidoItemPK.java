package com.mdo.cadastroproduto.api.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Embeddable
public class PedidoItemPK  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Produto produto;
	private Pedido pedido;

	@ManyToOne
	@JoinColumn(name="idProduto")
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@ManyToOne
	@JoinColumn(name="idPedido")
	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

}

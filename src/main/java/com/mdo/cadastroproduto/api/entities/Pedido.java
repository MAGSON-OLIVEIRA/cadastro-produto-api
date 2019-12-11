package com.mdo.cadastroproduto.api.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.mdo.cadastroproduto.api.enums.StatusEnum;

@Entity
@Table(name = "pedido")
public class Pedido implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Long id;
	private Cliente cliente;
	private LocalDate data;
	private StatusEnum status;
	private String sessao;
	private List<PedidoItem> itens = new ArrayList<>();
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_cliente")
	public Cliente getCliente() {
		return cliente;
	}
	
	@Column(name="data")
	public LocalDate getData() {
		return data;
	}
	
	@Column(name="status", nullable = false)
	public StatusEnum getStatus() {
		return status;
	}
	
	@Column(name="sessao", nullable = false)
	public String getSessao() {
		return sessao;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public void setStatus(StatusEnum status) {
		this.status = status;
	}
	public void setSessao(String sessao) {
		this.sessao = sessao;
	}

	@OneToMany(mappedBy="pedido", cascade = CascadeType.ALL)
	public List<PedidoItem> getItens() {
		return itens;
	}

	public void setItens(List<PedidoItem> itens) {
		this.itens = itens;
	}

	
	
	
}

package com.mdo.cadastroproduto.api.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.mdo.cadastroproduto.api.entities.PedidoItem;
import com.mdo.cadastroproduto.api.enums.StatusEnum;

public class PedidoDto {

	private Long codigo;
	private String emailCliente;
	private StatusEnum status;
	
	private List<ItemDto> itens = new ArrayList<>();

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}



	public String getEmailCliente() {
		return emailCliente;
	}

	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	public List<ItemDto> getItens() {
		return itens;
	}

	public void setItens(List<ItemDto> itens) {
		this.itens = itens;
	}
	
}

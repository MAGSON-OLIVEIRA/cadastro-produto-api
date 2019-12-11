package com.mdo.cadastroproduto.api.services;

import java.util.Optional;

import com.mdo.cadastroproduto.api.entities.Pedido;

public interface PedidoService {
	Pedido persistir(Pedido pedido);
	Pedido updat(Pedido pedido);
	Optional<Pedido> getPedido(Long id);
	void delet(Pedido pedido);
}

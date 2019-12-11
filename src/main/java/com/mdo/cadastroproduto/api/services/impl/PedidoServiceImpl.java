package com.mdo.cadastroproduto.api.services.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mdo.cadastroproduto.api.entities.Pedido;
import com.mdo.cadastroproduto.api.repositories.PedidoRepository;
import com.mdo.cadastroproduto.api.services.PedidoService;

//import jdk.internal.org.jline.utils.Log;

@Service
public class PedidoServiceImpl  implements PedidoService {
	
	private static final Logger log = LoggerFactory.getLogger(PedidoServiceImpl.class);
	
	@Autowired
	PedidoRepository pedidoRepository;

	@Override
	public Pedido persistir(Pedido pedido) {
		log.info("salvar pedido na base ", pedido.toString());
		return this.pedidoRepository.save(pedido);
	}

	@Override
	public Pedido updat(Pedido pedido) {
		log.info("atualizar pedido na base ", pedido.toString());
		return this.pedidoRepository.saveAndFlush(pedido);
	}

	@Override
	public Optional<Pedido> getPedido(Long id) {
		log.info("pesquisar pedido na base ", id);
		return this.pedidoRepository.findById(id);
	}

	@Override
	public void delet(Pedido pedido) {
		log.info("deletar pedido na base ", pedido.toString());
		this.pedidoRepository.delete(pedido);
	}

}

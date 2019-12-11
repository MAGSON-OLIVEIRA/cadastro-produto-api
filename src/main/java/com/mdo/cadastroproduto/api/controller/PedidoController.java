package com.mdo.cadastroproduto.api.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mdo.cadastroproduto.api.dto.ClienteDto;
import com.mdo.cadastroproduto.api.dto.ItemDto;
import com.mdo.cadastroproduto.api.dto.PedidoDto;
import com.mdo.cadastroproduto.api.entities.Cliente;
import com.mdo.cadastroproduto.api.entities.Pedido;
import com.mdo.cadastroproduto.api.entities.PedidoItem;
import com.mdo.cadastroproduto.api.entities.Produto;
import com.mdo.cadastroproduto.api.enums.StatusEnum;
import com.mdo.cadastroproduto.api.response.Response;
import com.mdo.cadastroproduto.api.services.ClienteService;
import com.mdo.cadastroproduto.api.services.PedidoService;
import com.mdo.cadastroproduto.api.services.ProdutoService;

@RestController
@RequestMapping("/api/pedido")
@CrossOrigin(origins = "*")
public class PedidoController {
	private static final Logger log = LoggerFactory.getLogger(PedidoController.class);
	
	@Autowired
	private PedidoService pedidoService;
	
	@Autowired
	private ClienteService clienteService;
	
	@PostMapping
	public ResponseEntity<Response<PedidoDto>> save(@Valid @RequestBody PedidoDto dto, BindingResult result) {
		Response<PedidoDto> response = new Response<PedidoDto>();
		
		Cliente cliente = new Cliente();
		
		if(this.clienteService.getClientePorEmail(dto.getEmailCliente()).isPresent()) {
			cliente = this.clienteService.getClientePorEmail(dto.getEmailCliente()).get();
		}
		 
		
		Pedido pedido = getPedidoNovo(dto, cliente);
		List<PedidoItem> itens = this.getListItens(dto.getItens(), pedido);
		pedido.setItens(itens);
		
		if(result.hasErrors()) {
			log.info("Cadastro pedido: {}", dto.toString());
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		this.pedidoService.persistir(pedido);
		response.setData(getPedidoDto(pedido));
		return ResponseEntity.ok(response);
	}
	
	private List<PedidoItem> getListItens(List<ItemDto> itens, Pedido pedido) {
		List<PedidoItem> itensPedido = new ArrayList<PedidoItem>();
		itens.forEach(item ->  getListPedido(item, itensPedido, pedido));
		return itensPedido;
	}



	private void getListPedido(ItemDto item, List<PedidoItem> itensPedido, Pedido pedido) {
		PedidoItem itemNovo = new PedidoItem();
		itemNovo.setPedido(pedido);
		itemNovo.setDescProduto(item.getDescProduto());
		itemNovo.setProduto( new Produto(item.getCodigoProduto(), item.getDescProduto()));
		itemNovo.setQuantidade(item.getQuantidade());
		itemNovo.setValor(item.getValor());
		itensPedido.add(itemNovo);	
	}


	private Pedido getPedidoNovo(PedidoDto dto, Cliente cliente) {
		Pedido pedido = new Pedido();
		pedido.setCliente(cliente);
		pedido.setData(LocalDate.now());
		pedido.setSessao("");
		pedido.setStatus(StatusEnum.STATUS_INICIADO);
		return pedido;
	}
	
	private PedidoDto getPedidoDto(Pedido pedido) {
		List<ItemDto> itens = new ArrayList<>();
		PedidoDto dto = new PedidoDto();
		dto.setEmailCliente(pedido.getCliente().getEmail());
		dto.setStatus(pedido.getStatus());
		pedido.getItens().forEach(item -> getListPedidoDto(itens, item));
		dto.setItens(itens);
		return dto;
	}

	private void getListPedidoDto(List<ItemDto> itens, PedidoItem item) {
		ItemDto itemDto = new ItemDto();
		itemDto.setCodigoProduto(item.getProduto().getId());
		itemDto.setDescProduto(item.getProduto().getProduto());
		itemDto.setQuantidade(item.getQuantidade());
		itemDto.setValor(item.getValor());
		itens.add(itemDto);
	}

}

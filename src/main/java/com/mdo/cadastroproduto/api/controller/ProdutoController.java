package com.mdo.cadastroproduto.api.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mdo.cadastroproduto.api.dto.ProdutoDto;
import com.mdo.cadastroproduto.api.entities.Produto;
import com.mdo.cadastroproduto.api.enums.CategoriaEnum;
import com.mdo.cadastroproduto.api.response.Response;
import com.mdo.cadastroproduto.api.services.ProdutoService;

@RestController
@RequestMapping("/api/produto")
@CrossOrigin(origins = "*")
public class ProdutoController {
	
	private static final Logger log = LoggerFactory.getLogger(ProdutoController.class);
	
	@Autowired
	private ProdutoService produtoService;	
	
	@PostMapping
	public ResponseEntity<Response<ProdutoDto>> save(@Valid @RequestBody ProdutoDto dto, BindingResult result) {
		Response<ProdutoDto> response = new Response<ProdutoDto>();
		
		// validarDadosExistentes()
		Produto produto = this.getProdutoNovo(dto);
		if(result.hasErrors()) {
			log.info("Cadastro produto: {}", dto.toString());
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		this.produtoService.persistir(produto);
		response.setData(getDto(produto));
		return ResponseEntity.ok(response);
	}
	
	
	

	private ProdutoDto getDto(Produto produto) {
		ProdutoDto dto = new ProdutoDto();
		dto.setCategoria(produto.getCategoria());
		dto.setCodigo(produto.getId());
		dto.setDescricao(produto.getDescricao());
		dto.setFoto(produto.getFoto());
		dto.setPreco(produto.getPreco());
		dto.setProduto(produto.getProduto());
		dto.setQuantidade(produto.getQuantidade());
		return dto;
	}

	private Produto getProdutoNovo(ProdutoDto dto) {
		Produto produto = new Produto();
		produto.setCategoria(CategoriaEnum.valueOf(dto.getCategoria().name()));
		produto.setDescricao(dto.getDescricao());
		produto.setFoto(dto.getFoto());
		produto.setPreco(dto.getPreco());
		produto.setProduto("novo");
		return produto;
	}

}

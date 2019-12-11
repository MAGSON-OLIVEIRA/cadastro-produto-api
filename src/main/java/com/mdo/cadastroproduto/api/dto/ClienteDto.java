package com.mdo.cadastroproduto.api.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

public class ClienteDto {

	private Long codigo;
	private String nome;
	private String email;
	private String senha;
	private String rua;
	private String cidade;
	private String bairro;
	private String estado;
	private String cep;
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
	@NotEmpty(message = "Informe o nome.")
	@Length(min=3, max=200, message="Entre 3 a 200 digitos")
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Email(message = "Informe um E-mail, valido.")
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	@NotEmpty(message = "Informe uma senha.")
	@Length(min=3, max=100, message="senha: Entre 3 a 100 digitos")
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	@NotEmpty(message = "Informe a rua.")
	@Length(min=3, max=100, message="rua: Entre 3 a 100 digitos")
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	
	@NotEmpty(message = "Informe a cidade.")
	@Length(min=3, max=100, message="Cidade: Entre 3 a 100 digitos")
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	@NotEmpty(message = "Informe estado.")
	@Length(max=2, message="Estado: 2 digitos")
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	@NotEmpty(message = "Informe um cep.")
	@Length(max=8, message="cep: 8 digitos")
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	
}

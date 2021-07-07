package br.com.qm.api.pecas.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
public class Venda {

	@Id
	@Column(name = "id_venda")
	private long idVenda;
	
	@Column(name = "cod_barras")
	private long codBarras;
	
	private int quantidade;
	
	@Column(name = "nome_vendedor")
	private String nomeVendedor;

	@Column(name = "data_venda")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate dataVenda;

	@Column(name = "forma_pagamento")
	private String formaPagamento;
	
	@Column(name = "valor_venda")
	@JsonProperty(access = Access.READ_ONLY)
	private Float valorVenda;

	public Venda(long idVenda, long codBarras, int quantidade, String nomeVendedor, LocalDate dataVenda,
			String formaPagamento) {
		this.idVenda = idVenda;
		this.codBarras = codBarras;
		this.quantidade = quantidade;
		this.nomeVendedor = nomeVendedor;
		this.dataVenda = dataVenda;
		this.formaPagamento = formaPagamento;
	}

	public Venda() {
	}

	public long getIdVenda() {
		return idVenda;
	}

	public void setIdVenda(long idVenda) {
		this.idVenda = idVenda;
	}

	public long getCodBarras() {
		return codBarras;
	}

	public void setCodBarras(long codBarras) {
		this.codBarras = codBarras;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getNomeVendedor() {
		return nomeVendedor;
	}

	public void setNomeVendedor(String nomeVendedor) {
		this.nomeVendedor = nomeVendedor;
	}

	public LocalDate getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(LocalDate dataVenda) {
		this.dataVenda = dataVenda;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public Float getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(Float valorVenda) {
		this.valorVenda = valorVenda;
	}
	
}



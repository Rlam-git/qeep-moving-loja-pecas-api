package br.com.qm.api.pecas.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Peca {

//	- código de barras (chave primária)
//	- nome
//	- modelo do carro (para qual carro é aquela peça)
//	- fabricante
//	- preço de custo
//	- preço de venda
//	- quantidade em estoque
//	- categoria
	
	@Id
	@Column(name = "cod_barras")
	private long codBarras;
	
	private String nome;
	
	@Column(name = "modelo_carro")
	private String modeloCarro;
	
	private String fabricante;
	
	@Column(name = "preco_custo")
	private float precoCusto;
	
	@Column(name = "preco_venda")
	private float precoVenda;

	@Column(name = "qtd_estoque")
	private int qtdEstoque;
	
	private String categoria;

	public Peca(long codBarras, String nome, String modeloCarro, String fabricante, float precoCusto, float precoVenda,
			int qtdEstoque, String categoria) {
		this.codBarras = codBarras;
		this.nome = nome;
		this.modeloCarro = modeloCarro;
		this.fabricante = fabricante;
		this.precoCusto = precoCusto;
		this.precoVenda = precoVenda;
		this.qtdEstoque = qtdEstoque;
		this.categoria = categoria;
	}
	
	
	public Peca() {
	}


	public long getCodBarras() {
		return codBarras;
	}

	public void setCodBarras(long codBarras) {
		this.codBarras = codBarras;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getModeloCarro() {
		return modeloCarro;
	}

	public void setModeloCarro(String modeloCarro) {
		this.modeloCarro = modeloCarro;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public float getPrecoCusto() {
		return precoCusto;
	}

	public void setPrecoCusto(float precoCusto) {
		this.precoCusto = precoCusto;
	}

	public float getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(float precoVenda) {
		this.precoVenda = precoVenda;
	}

	public int getQtdEstoque() {
		return qtdEstoque;
	}

	public void setQtdEstoque(int qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
}

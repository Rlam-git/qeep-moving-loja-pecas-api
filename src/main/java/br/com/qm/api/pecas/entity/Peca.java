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
	private long codigoBarras;// como o nome da váriavel é curto não necessita de abreviação
	
	private String nome;
	
	@Column(name = "modelo_carro")
	private String modeloCarro;
	
	private String fabricante;
	
	@Column(name = "preco_custo")
	private float precoCusto;
	
	@Column(name = "preco_venda")
	private float precoVenda;

	@Column(name = "qtd_estoque")
	private int quantidadeEstoque;// como o nome da váriavel é curto não necessita de abreviação
	
	private String categoria;

	public Peca(long codigoBarras, String nome, String modeloCarro, String fabricante, float precoCusto, float precoVenda,
			int quantidadeEstoque, String categoria) {
		this.codigoBarras = codigoBarras;
		this.nome = nome;
		this.modeloCarro = modeloCarro;
		this.fabricante = fabricante;
		this.precoCusto = precoCusto;
		this.precoVenda = precoVenda;
		this.quantidadeEstoque = quantidadeEstoque;
		this.categoria = categoria;
	}
	
	
	public Peca() {
	}


	public long getcodigoBarras() {
		return codigoBarras;
	}

	public void setcodigoBarras(long codigoBarras) {
		this.codigoBarras = codigoBarras;
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

	public int getquantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setquantidadeEstoque(int quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
		result = prime * result + (int) (codigoBarras ^ (codigoBarras >>> 32));
		result = prime * result + ((fabricante == null) ? 0 : fabricante.hashCode());
		result = prime * result + ((modeloCarro == null) ? 0 : modeloCarro.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + Float.floatToIntBits(precoCusto);
		result = prime * result + Float.floatToIntBits(precoVenda);
		result = prime * result + quantidadeEstoque;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Peca other = (Peca) obj;
		if (categoria == null) {
			if (other.categoria != null)
				return false;
		} else if (!categoria.equals(other.categoria))
			return false;
		if (codigoBarras != other.codigoBarras)
			return false;
		if (fabricante == null) {
			if (other.fabricante != null)
				return false;
		} else if (!fabricante.equals(other.fabricante))
			return false;
		if (modeloCarro == null) {
			if (other.modeloCarro != null)
				return false;
		} else if (!modeloCarro.equals(other.modeloCarro))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (Float.floatToIntBits(precoCusto) != Float.floatToIntBits(other.precoCusto))
			return false;
		if (Float.floatToIntBits(precoVenda) != Float.floatToIntBits(other.precoVenda))
			return false;
		if (quantidadeEstoque != other.quantidadeEstoque)
			return false;
		return true;
	}

	
}

package br.com.qm.api.pecas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.qm.api.pecas.entity.Peca;
import br.com.qm.api.pecas.entity.Venda;
import br.com.qm.api.pecas.repository.VendaRepository;

@Service
public class VendaService {

	
	@Autowired
	VendaRepository vendaRepository;
	
	@Autowired
	PecaService pecaService;
	
	
	public Venda realizaVenda(Venda venda) {
		
		Optional<Peca> pecaOpt = pecaService.consultaPeca(venda.getCodBarras());
		
		if (pecaOpt.isEmpty()) {
			return null;
		}
		
		Peca peca = pecaOpt.get();
		
		if (peca.getQtdEstoque() < venda.getQuantidade()) {
			return null;
		}
		
		peca.setQtdEstoque(peca.getQtdEstoque() - venda.getQuantidade());
		venda.setValorVenda(venda.getQuantidade() * peca.getPrecoVenda());
		
		pecaService.alteraPeca(peca.getCodBarras(), peca);
		return vendaRepository.save(venda);
	}

	public List<Venda> listarVendas() {
		return (List<Venda>) vendaRepository.findAll();
	}

	public Float calculaFaturamento() {
		return vendaRepository.calculaFaturamento();
	}

	public List<Venda> listaVendasPorVendedor(String vendedor) {
		return vendaRepository.findAllByNomeVendedor(vendedor);
	}

	public List<Venda> listaVendasPorPagamento(String formaPagamento) {
		return vendaRepository.findAllByFormaPagamento(formaPagamento);
	}

	public boolean removeVenda(Long idVenda) {
		
		if (!vendaRepository.existsById(idVenda)) {
			return false;
		}
		
		vendaRepository.deleteById(idVenda);
		return true;
	}

}

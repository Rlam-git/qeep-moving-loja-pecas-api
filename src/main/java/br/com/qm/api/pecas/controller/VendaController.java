package br.com.qm.api.pecas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.qm.api.pecas.entity.Venda;
import br.com.qm.api.pecas.service.VendaService;

@RestController
@RequestMapping("/vendas")
public class VendaController {

//	POST /vendas 
//	- realizar uma venda.
//	Aqui você deverá criar uma estratégia para validar se é possível vender quantidade de peças informadas (de acordo com a quantidade em estoque).
//
//	GET /vendas
//	- Listar todas as vendas
//
//	GET /vendas/faturamento
//	- Retornar a soma dos valores de todas as vendas
//
//	GET /vendas/{nomeVendedor}/vendedor
//	- Listar todas as vendas de um vendedor
//
//	GET /vendas/{formaPagamento}/pagamento
//	- Listar todas as vendas por uma determinada forma de pagamento
//
//	DELETE /vendas/{idVenda}
//	- Remove uma venda
	
	@Autowired
	VendaService vendaService;
	
	@PostMapping
	public Venda realizaVenda(@RequestBody Venda venda) {
		return vendaService.realizaVenda(venda);
	}
	
	@GetMapping
	public List<Venda> listarVendas() {
		return vendaService.listarVendas();
	}
	
	@GetMapping(path = "/faturamento")
	public Float calculaFaturamento() {
		return vendaService.calculaFaturamento();
	}
	
	@GetMapping(path = "/{vendedor}/vendedor")
	public List<Venda> listaVendasPorVendedor(@PathVariable String vendedor) {
		return vendaService.listaVendasPorVendedor(vendedor);
	}
	
	@GetMapping(path = "/{formaPagamento}/pagamento")
	public List<Venda> listaVendasPorPagamento(@PathVariable String formaPagamento) {
		return vendaService.listaVendasPorPagamento(formaPagamento);
	}
	
	@DeleteMapping(path = "/{idVenda}")
	public boolean removeVenda(@PathVariable Long idVenda) {
		return vendaService.removeVenda(idVenda);
	}

}

package br.com.qm.api.pecas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.qm.api.pecas.dto.ResponseDTO;
import br.com.qm.api.pecas.dto.VendaDTO;
import br.com.qm.api.pecas.entity.Venda;
import br.com.qm.api.pecas.exception.ErroDeNegocioException;
import br.com.qm.api.pecas.service.VendaService;

@RestController
@RequestMapping("/vendas")
public class VendaController {

	@Autowired
	VendaService vendaService;
	
	@PostMapping
	public ResponseDTO realizaVenda(@Valid @RequestBody VendaDTO venda) throws ErroDeNegocioException {
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

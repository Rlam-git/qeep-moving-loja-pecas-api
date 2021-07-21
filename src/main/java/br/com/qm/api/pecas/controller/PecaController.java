package br.com.qm.api.pecas.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.qm.api.pecas.entity.Peca;
import br.com.qm.api.pecas.exception.ErroDeNegocioException;
import br.com.qm.api.pecas.service.PecaService;

@RestController
@RequestMapping("/pecas")
public class PecaController {

	@Autowired
	PecaService pecaService;
	
	@PostMapping
	public Peca cadastraPeca(@Valid @RequestBody Peca peca) throws ErroDeNegocioException {
		return pecaService.cadastraPeca(peca);
	}
	
	@GetMapping(path = "/{codBarras}")
	public Optional<Peca> consultaPeca(@PathVariable Long codBarras) {
		return pecaService.consultaPeca(codBarras);
	}

	@GetMapping
	public List<Peca> listaPecas() {
		return pecaService.listaPecas();
	}
	
	@DeleteMapping(path = "/{codBarras}")
	public boolean removePeca(@PathVariable Long codBarras) {
		return pecaService.removePeca(codBarras);
	}
	
	@PutMapping(path = "/{codBarras}")
	public Peca alteraPeca(@PathVariable Long codBarras, @RequestBody Peca peca) throws ErroDeNegocioException {
		return pecaService.alteraPeca(codBarras, peca);
	}
	
	// como a pesquisa é feita pelo nome a váriavel texto não fica bem claro qual campo a pesquisa é feita alterando para nome não é necessário ler o restante do código .
	// poderia mudar o nome do metodo como listarPecasComecadasComNome não sendo necessário ler o resante do código para saber qual compo é o critério de pesquisa
	@GetMapping(path = "/{texto}/comeco")
	public List<Peca> listaPecasComecadasCom(@PathVariable String nome) {
		return pecaService.listaPecasComecadasCom(nome);
	}
	
	@GetMapping(path = "/{modeloCarro}/modeloCarro")
	public List<Peca> listaPecasPorModelo(@PathVariable String modeloCarro) {
		return pecaService.listaPecasPorModelo(modeloCarro);
	}
	
	@GetMapping(path = "/{categoria}/categoria")
	public List<Peca> listaPecasPorCategoria(@PathVariable String categoria) {
		return pecaService.listaPecasPorCategoria(categoria);
	}
	
}

package com.br.java.rest.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.br.java.domain.entity.Produto;
import com.br.java.domain.services.produto.IProdutoService;

@RestController
@RequestMapping("api/produtos")
public class ProdutosController {

	private IProdutoService _service;

	public ProdutosController(IProdutoService service) {

		_service = service;
	}

	@GetMapping
	public List<Produto> GetAllProduto() {

		try {

			return _service.AllProduto();
		}

		catch (Exception ex) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
		}
	}

	@GetMapping("/by-id/{id}")
	public Produto GetProdutoById(@PathVariable Integer id) {

		try {
			return _service.ProdutoById(id);
			

		} catch (Exception ex) {

			throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
		}
				
	}

	@PostMapping("/cadastrar")
	@ResponseStatus(HttpStatus.CREATED)
	public Produto PostProduto(@RequestBody @Valid Produto produto) {
		try {
			return _service.SalvarProduto(produto);
		}

		catch (Exception ex) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
		}
	}

	@PutMapping("/atualizar")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public Produto PutProduto(@RequestBody @Valid Produto produto) {
		try {
			return _service.AlterarProduto(produto);
		} catch (Exception ex) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
		}
	}
	
	@DeleteMapping("/deletar/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void DeleteProduto(@PathVariable Integer id) {

		try {
			_service.DeletarProduto(id);
			return;

		} catch (Exception ex) {

			throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
		}
	}

}

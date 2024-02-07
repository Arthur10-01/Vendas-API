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
import com.br.java.domain.repository.ProdutosRepository;

@RestController
@RequestMapping("api/produtos")
public class ProdutosController {

	private ProdutosRepository _repository;

	public ProdutosController(ProdutosRepository repository) {

		_repository = repository;
	}

	@GetMapping
	public List<Produto> GetAllProduto() {

		try {

			return _repository.findAll();
		}

		catch (Exception ex) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
		}
	}

	@GetMapping("/byid/{id}")
	public Produto GetProdutoById(@PathVariable Integer id) {

		return _repository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado"));
	}

	@PostMapping("/cadastrar")
	@ResponseStatus(HttpStatus.CREATED)
	public Produto PostProduto(@RequestBody @Valid Produto produto) {
		try {
			return _repository.save(produto);
		}

		catch (Exception ex) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
		}
	}

	@PutMapping("/atualizar")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public Produto PutProduto(@RequestBody @Valid Produto produto) {
		try {
			return _repository.save(produto);
		} catch (Exception ex) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
		}
	}
	
	@DeleteMapping("/deletar/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public Produto DeleteProduto(@PathVariable Integer id) {

		return _repository.findById(id).map(produto -> {
			_repository.delete(produto);
			return produto;
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado"));
	}

}

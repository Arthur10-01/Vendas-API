package com.br.java.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.br.java.domain.entity.Produto;
import com.br.java.domain.repository.ProdutosRepository;

import com.br.java.utils.Formatador;

@Service
public class ProdutoService {

	private Formatador _formatador;
	private ProdutosRepository _repository;

	public ProdutoService(ProdutosRepository repository, Formatador formatador) {
		_repository = repository;
		_formatador = formatador;
	}

	public List<Produto> AllProduto() {

		return _repository.findAll();
	}

	public Produto ProdutoById(Integer id) throws Exception {
		return _repository.findById(id).orElseThrow(() -> new Exception("Produto não Encontrado"));
	}

}

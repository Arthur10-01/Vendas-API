package com.br.java.domain.services.produto;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.br.java.domain.entity.Produto;
import com.br.java.domain.repository.ProdutosRepository;

@Service
public class ProdutoService implements IProdutoService {

	private ProdutosRepository _repository;

	public ProdutoService(ProdutosRepository repository) {
		_repository = repository;

	}

	public List<Produto> AllProduto() {

		return _repository.findAll();
	}

	public Produto ProdutoById(Integer id) {
		Optional<Produto> produto = _repository.findById(id);

		return produto.get();
	}

	@Override
	public Produto SalvarProduto(Produto produto) {
		return _repository.save(produto);
	}

	@Override
	public Produto AlterarProduto(Produto produto) {
		return _repository.save(produto);
	}

	@Override
	public void DeletarProduto(Integer id) {
		_repository.deleteById(id);
		
	}
	
	

}

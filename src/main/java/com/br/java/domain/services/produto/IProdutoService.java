package com.br.java.domain.services.produto;

import java.util.List;

import com.br.java.domain.entity.Produto;

public interface IProdutoService {
	public List<Produto> AllProduto();
	public Produto ProdutoById(Integer id);
	public Produto SalvarProduto(Produto produto);
	public Produto AlterarProduto(Produto produto);
	public void DeletarProduto(Integer id);
}

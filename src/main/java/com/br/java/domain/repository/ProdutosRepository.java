package com.br.java.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.java.domain.entity.Produto;

public interface ProdutosRepository extends JpaRepository<Produto, Integer>  {

}

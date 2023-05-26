package com.br.java.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.java.domain.entity.Pedido;

public interface PedidosRepository extends JpaRepository<Pedido, Integer> {

}

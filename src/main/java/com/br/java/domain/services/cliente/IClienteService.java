package com.br.java.domain.services.cliente;

import java.util.List;

import com.br.java.domain.entity.Cliente;
import com.br.java.domain.entity.Produto;

public interface IClienteService {
	public List<Cliente> AllClientes();

	public Cliente ClienteById(Integer id) throws Exception;

	public Cliente SalvarCliente(Cliente cliente);

	public Cliente AtualizarCliente(Cliente cliente);

	public void DeletarCliente(Integer id);
}

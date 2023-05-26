package com.br.java.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.br.java.domain.entity.Cliente;
import com.br.java.domain.repository.ClientesRepository;
import com.br.java.utils.Formatador;

@Service
public class ClienteService {

	private ClientesRepository _repository;
	private Formatador _formatador;

	public ClienteService(ClientesRepository repository, Formatador formatador) {
		_repository = repository;
		_formatador = formatador;
	}

	public List<Cliente> AllClientes() {

		List<Cliente> clientesList = _repository.findAll();

		for (Cliente cliente : clientesList) {
			if (cliente.getCpf() != null)
				cliente.setCpf(_formatador.FormatCpf(cliente.getCpf()));
		}

		return clientesList;
	}

	public Cliente ClienteById(Integer id) throws Exception {

		Optional<Cliente> clientes = _repository.findById(id);
		if (clientes.isPresent()) {
			Cliente cliente = clientes.get();
			cliente.setCpf(_formatador.FormatCpf(cliente.getCpf()));
			return cliente;

		} else {
			throw new Exception("Usuário não encontrado");
		}

	}

	public Cliente SalvarCliente(Cliente cliente) {

		return _repository.save(cliente);
	}

	public Cliente AtualizarCliente(Cliente cliente) {
		return _repository.save(cliente);

	}

	public void DeletarCliente(Integer id) {

		_repository.deleteById(id);

	}

}

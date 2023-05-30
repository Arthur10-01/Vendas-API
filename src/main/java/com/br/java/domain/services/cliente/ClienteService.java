package com.br.java.domain.services.cliente;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.br.java.domain.entity.Cliente;
import com.br.java.domain.repository.ClientesRepository;
import com.br.java.utils.Formatador;

@Service
public class ClienteService implements IClienteService{

	private ClientesRepository _repository;
	private Formatador formatador;

	public ClienteService(ClientesRepository repository, Formatador formatador) {
		_repository = repository;
		this.formatador = formatador;
	}

	public List<Cliente> AllClientes() {

		List<Cliente> clientesList = _repository.findAll();

		for (Cliente cliente : clientesList) {
			if (cliente.getCpf() != null)
				cliente.setCpf(formatador.FormatCpf(cliente.getCpf()));
		}

		return clientesList;
	}

	public Cliente ClienteById(Integer id) {

		Optional<Cliente> clientes = _repository.findById(id);
		if (clientes.isPresent()) {
			Cliente cliente = clientes.get();
			cliente.setCpf(formatador.FormatCpf(cliente.getCpf()));
			return cliente;

		} else {
			return clientes.get();
		}

	}

	public Cliente SalvarCliente(Cliente cliente) {
        cliente.setCpf(formatador.LimparCpf(cliente.getCpf()));
		return _repository.save(cliente);
	}

	public Cliente AtualizarCliente(Cliente cliente) {
	    cliente.setCpf(formatador.LimparCpf(cliente.getCpf()));
		return _repository.save(cliente);

	}

	public void DeletarCliente(Integer id) {

		_repository.deleteById(id);

	}

}

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

import com.br.java.domain.entity.Cliente;
import com.br.java.domain.repository.ClientesRepository;
import com.br.java.domain.service.ClienteService;

@RestController
@RequestMapping("/api/clientes")
public class ClientesController {

	private ClienteService _service;

	public ClientesController(ClienteService service) {
		_service = service;
	}

	@GetMapping
	public List<Cliente> GetAllClientes() {

		try {

			return _service.AllClientes();

		} catch (Exception ex) {

			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
		}
	}

	@GetMapping("/ById/{id}")
	public Cliente GetById(@PathVariable Integer id) {

		try {

			return _service.ClienteById(id);

		} catch (Exception ex) {

			throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
		}
	}

	@PostMapping("/Cadastrar")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente PostCliente(@RequestBody @Valid Cliente cliente) {
		try {
			return _service.SalvarCliente(cliente);
		} catch (Exception ex) {

			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
		}
	}

	@DeleteMapping("/Deletar/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void DeleteCliente(@PathVariable Integer id) {

		try {
			_service.DeletarCliente(id);
			return;

		} catch (Exception ex) {

			throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
		}
	}

	@PutMapping("/Atualizar")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public Cliente PutCliente(@RequestBody @Valid Cliente cliente) {
		try {
			return _service.AtualizarCliente(cliente);

		} catch (Exception ex) {

			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
		}
	}
}

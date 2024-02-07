package com.br.java.rest.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
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

import com.br.java.domain.entity.Usuario;
import com.br.java.domain.service.UsuarioService;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

	private UsuarioService _service;

	public UsuarioController(UsuarioService service) {
		_service = service;
	}

	@GetMapping
	public List<Usuario> GetAllUsuarios() {

		try {

			return _service.AllUsuarios();

		} catch (Exception ex) {

			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
		}
	}

	@GetMapping("/byid/{id}")
	public Usuario GetById(@PathVariable Integer id) {

		try {

			return _service.UsuarioById(id);

		} catch (Exception ex) {

			throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
		}
	}
	@CrossOrigin(origins = "http://localhost:8090")
	@PostMapping("/logar")
	public Usuario GetUsuarioLogar(@RequestBody @Valid Usuario usuario) {

		try {
			
            System.out.println("Passei aqui");
            return _service.UsuarioByEmailSenha(usuario.getEmail(), usuario.getSenha());
			

		} catch (Exception ex) {

			throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
		}
	}

	@PostMapping("/cadastrar")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario PostUsuario(@RequestBody @Valid Usuario Usuario) {
		try {
			return _service.SalvarUsuario(Usuario);
		} catch (Exception ex) {

			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
		}
	}

	@DeleteMapping("/deletar/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void DeleteUsuario(@PathVariable Integer id) {

		try {
			_service.DeletarUsuario(id);
			return;

		} catch (Exception ex) {

			throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
		}
	}

	@PutMapping("/atualizar")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public Usuario PutUsuario(@RequestBody @Valid Usuario usuario) {
		try {
			return _service.AtualizarUsuario(usuario);

		} catch (Exception ex) {

			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
		}
	}
}

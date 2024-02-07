package com.br.java.domain.service;

import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import org.springframework.stereotype.Service;
import com.br.java.domain.entity.Usuario;
import com.br.java.domain.repository.UsuarioRepository;
import com.br.java.utils.Formatador;

@Service
public class UsuarioService {

	private UsuarioRepository _repository;
	private Formatador _formatador;

	public UsuarioService(UsuarioRepository repository, Formatador formatador) {
		_repository = repository;
		_formatador = formatador;
	}

	public List<Usuario> AllUsuarios() {

		List<Usuario> usuariosList = _repository.findAll();

		for (Usuario usuario : usuariosList) {
			if (usuario.getCpf() != null)
				usuario.setCpf(_formatador.FormatCpf(usuario.getCpf()));
		}

		return usuariosList;
	}

	public Usuario UsuarioById(Integer id) throws Exception {

		Optional<Usuario> usuarios = _repository.findById(id);
		if (usuarios.isPresent()) {
			Usuario usuario = usuarios.get();
			usuario.setCpf(_formatador.FormatCpf(usuario.getCpf()));
			return usuario;

		} else {
			throw new Exception("Usuário não encontrado");
		}

	}
	
	public Usuario UsuarioByEmailSenha(String email, String senha) throws Exception {

		List<Usuario> usuarios = _repository.encontrarPorEmailESenha(email, senha);
		if (usuarios.size() > 0) {
			Usuario usuario = new Usuario();
			for(Usuario item : usuarios) {
				usuario = item;
			}
			
			return usuario;
		} else {
			throw new Exception("Usuário não encontrado");
		}

	}
	
	

	public Usuario SalvarUsuario(Usuario usuario) {

		return _repository.save(usuario);
	}

	public Usuario AtualizarUsuario(Usuario usuario) {
		return _repository.save(usuario);

	}

	public void DeletarUsuario(Integer id) {

		_repository.deleteById(id);

	}

}

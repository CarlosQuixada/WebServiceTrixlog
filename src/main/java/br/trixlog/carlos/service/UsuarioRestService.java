package br.trixlog.carlos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.trixlog.carlos.model.Usuario;
import br.trixlog.carlos.repository.UsuarioRepository;

@Service
public class UsuarioRestService {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario cadastrarUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	public Usuario getUsuario(String usuarioId) {
		return usuarioRepository.findOne(usuarioId);
	}

	public List<Usuario> getAllUsuarios() {
		List<Usuario> usuarios = usuarioRepository.findAll();
		return usuarios;
	}
	
	public Usuario getByLogin(String login){
		return usuarioRepository.findUsuarioByLogin(login);
	}
}

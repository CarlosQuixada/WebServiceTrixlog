package br.trixlog.carlos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.trixlog.carlos.model.Usuario;
import br.trixlog.carlos.service.UsuarioService;

@RestController
@RequestMapping("/api/trixlog/usuarios")
public class UsuarioRestController {
	
	@Autowired
	private UsuarioService usuarioService;
	

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Usuario>> getAllUsuarios() {
		List<Usuario> usuarios = usuarioService.getAllUsuarios();
		return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);
	}

	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> getUsuario(@PathVariable("id") String id) {

		Usuario usuario = usuarioService.getUsuario(id);
		if (usuario == null) {
			return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}
	@RequestMapping(value="/logar",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> logar(@RequestBody Usuario usuario){
		Usuario user = usuarioService.getByNome(usuario.getUser());
		if(user != null){
			if(user.getSenha() == usuario.getSenha()){
				return new ResponseEntity<Usuario>(user,HttpStatus.OK);
			}
		}
		return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario) {

		Usuario savedUsuario = usuarioService.cadastrarUsuario(usuario);

		return new ResponseEntity<Usuario>(savedUsuario, HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> updateGreeting(@RequestBody Usuario usuario) {

		Usuario updatedUsuario = usuarioService.cadastrarUsuario(usuario);
		if (updatedUsuario == null) {
			return new ResponseEntity<Usuario>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<Usuario>(updatedUsuario, HttpStatus.OK);
	}
}

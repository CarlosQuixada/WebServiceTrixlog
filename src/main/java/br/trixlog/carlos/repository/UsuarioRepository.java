package br.trixlog.carlos.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.trixlog.carlos.model.Usuario;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String> {
	public Usuario findUsuarioByLogin(String login);
}

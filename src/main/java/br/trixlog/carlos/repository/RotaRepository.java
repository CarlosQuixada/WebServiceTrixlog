package br.trixlog.carlos.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.trixlog.carlos.model.Rota;

public interface RotaRepository extends MongoRepository<Rota, String> {
	public List<Rota> findRotaByName(String name);
}

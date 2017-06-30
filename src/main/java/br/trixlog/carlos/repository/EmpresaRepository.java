package br.trixlog.carlos.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.trixlog.carlos.model.Empresa;

public interface EmpresaRepository extends MongoRepository<Empresa, String>{

}

package br.trixlog.carlos.service;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.trixlog.carlos.model.Parada;
import br.trixlog.carlos.model.Rota;
import br.trixlog.carlos.repository.RotaRepository;

@Service
public class RotaService {
	@Autowired
	private RotaRepository rotaRepository;
	
	public void gerarRota(List<Parada> stops) {

	}

	public Rota cadastrarRota(Rota rota) {
		return rotaRepository.save(rota);
	}

	public Rota getRota(String rotaId) {
		return rotaRepository.findOne(rotaId);
	}

	public List<Rota> getAllRotas() {
		return null;
	}
}

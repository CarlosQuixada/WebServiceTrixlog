package br.trixlog.carlos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.trixlog.carlos.model.Rota;
import br.trixlog.carlos.repository.RotaRepository;

@Service
public class RotaService {
	@Autowired
	private RotaRepository rotaRepository;
	
	public Rota cadastrarRota(Rota rota) {
		return rotaRepository.save(rota);
	}

	public Rota getRota(String rotaId) {
		return rotaRepository.findOne(rotaId);
	}

	public List<Rota> getAllRotas() {
		return rotaRepository.findAll();
	}
	
	public Rota gerarRota(Rota rota){
		Util util = new Util();
		Rota rotaGerada = util.gerarRota(rota);
		return rotaGerada;
	}
	
	public List<Rota> buscarRotaByEmpresa(String name){
		return rotaRepository.findRotaByName(name);
	}
}

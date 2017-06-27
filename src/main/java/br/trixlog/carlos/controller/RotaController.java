package br.trixlog.carlos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.trixlog.carlos.model.Rota;
import br.trixlog.carlos.service.RotaService;

@RestController
@RequestMapping("/api/trixlog/rotas")
public class RotaController {
	@Autowired
	private RotaService rotaService;
	
	@RequestMapping()
	public ResponseEntity<List<Rota>> getRotas() {
		List<Rota> rotas = rotaService.getAllRotas();
		if (rotas.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Rota>>(rotas, HttpStatus.OK);
	}
}

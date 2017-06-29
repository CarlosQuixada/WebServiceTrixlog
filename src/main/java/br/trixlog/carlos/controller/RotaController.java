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

import br.trixlog.carlos.model.Rota;
import br.trixlog.carlos.service.RotaService;

@RestController
@RequestMapping("/api/trixlog/rotas")
public class RotaController {
	@Autowired
	private RotaService rotaService;
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Rota>> getAllRotas() {
		List<Rota> rotas = rotaService.getAllRotas();
		return new ResponseEntity<List<Rota>>(rotas, HttpStatus.OK);
	}

	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Rota> getGreeting(@PathVariable("id") String id) {

		Rota rota = rotaService.getRota(id);
		if (rota == null) {
			return new ResponseEntity<Rota>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Rota>(rota, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Rota> createGreeting(@RequestBody Rota rota) {

		Rota savedRota = rotaService.cadastrarRota(rota);

		return new ResponseEntity<Rota>(savedRota, HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Rota> updateGreeting(@RequestBody Rota rota) {

		Rota updatedRota = rotaService.cadastrarRota(rota);
		if (updatedRota == null) {
			return new ResponseEntity<Rota>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<Rota>(updatedRota, HttpStatus.OK);
	}
}

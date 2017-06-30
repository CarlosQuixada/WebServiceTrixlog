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
public class RotaRestController {
	@Autowired
	private RotaService rotaService;
	

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Rota>> getAllRotas() {
		List<Rota> rotas = rotaService.getAllRotas();
		return new ResponseEntity<List<Rota>>(rotas, HttpStatus.OK);
	}
	@RequestMapping(value="/gerarRota")
	public ResponseEntity<Rota> gerarRota(@RequestBody Rota rota){
		Rota rotaGerada = rotaService.gerarRota(rota);
		return new ResponseEntity<Rota>(rotaGerada,HttpStatus.OK);
	}

	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Rota> getRota(@PathVariable("id") String id) {
		Rota rota = rotaService.getRota(id);
		if (rota == null) {
			return new ResponseEntity<Rota>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Rota>(rota, HttpStatus.OK);
	}
}

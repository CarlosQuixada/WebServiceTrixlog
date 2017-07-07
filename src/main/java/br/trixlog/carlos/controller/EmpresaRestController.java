package br.trixlog.carlos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.trixlog.carlos.model.ListaEmpresa;
import br.trixlog.carlos.service.EmpresaRestService;

@Controller
@RequestMapping("/api/trixlog/empresas")
public class EmpresaRestController {
	@Autowired
	private EmpresaRestService empresaService;
	
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ListaEmpresa> getAllRotas() {
		ListaEmpresa listaEmpresa = empresaService.getAllEmpresa();
		return new ResponseEntity<ListaEmpresa>(listaEmpresa, HttpStatus.OK);
	}
}

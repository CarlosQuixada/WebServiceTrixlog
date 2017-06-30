package br.trixlog.carlos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.trixlog.carlos.model.Empresa;
import br.trixlog.carlos.repository.EmpresaRepository;

@Service
public class EmpresaService {
	@Autowired
	private EmpresaRepository empresaRepository;
	
	public void cadastrarEmpresa(Empresa empresa){
		empresaRepository.save(empresa);
	}
	
	public Empresa getEmpresa(String empresaId){
		return empresaRepository.findOne(empresaId);
	}
}

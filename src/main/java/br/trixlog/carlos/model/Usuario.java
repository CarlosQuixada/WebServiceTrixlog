package br.trixlog.carlos.model;

public class Usuario {
	private String id;
	private String nome;
	private String empresaId;
	private String login;
	private String senha;
	private Papel papel;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmpresaId() {
		return empresaId;
	}

	public void setEmpresaId(String empresaId) {
		this.empresaId = empresaId;
	}

	public Papel getPapel() {
		return papel;
	}

	public void setPapel(Papel papel) {
		this.papel = papel;
	}

}

package br.edu.ufc.smd.entidades;

public abstract class ProfissionalSaude {
	
	protected String nome;
	
	protected String contato;
	
	protected String registroConselho;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public String getRegistroConselho() {
		return registroConselho;
	}

	public void setRegistroConselho(String registroConselho) {
		this.registroConselho = registroConselho;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return nome;
	}
	
	
	
}

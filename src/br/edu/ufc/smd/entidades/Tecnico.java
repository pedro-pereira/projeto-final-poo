package br.edu.ufc.smd.entidades;

public class Tecnico extends ProfissionalSaude {
	
	public Tecnico(String coren, String nome, String contato) {
		super();
		super.setContato(contato);
		super.setNome(nome);
		this.setRegistroConselho(coren);
	}

	public void setRegistroConselho(String registroConselho) {
		super.registroConselho = Utils.formatarRegistroCoren(registroConselho);
	}
	
	public void coletar(Exame exame) {
		System.out.println("Tecnico coletou o exame!");
	}
}

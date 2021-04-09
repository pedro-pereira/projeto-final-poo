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
	
	public void coletar(Exame exame, Paciente paciente) {
		System.out.println("O técnico " + this.getNome() + " coletou o exame " + exame.getDescricao() + ".");
	}
}

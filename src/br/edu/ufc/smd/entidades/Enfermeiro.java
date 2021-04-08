package br.edu.ufc.smd.entidades;

public class Enfermeiro extends ProfissionalSaude {
	
	public Enfermeiro(String coren, String nome, String contato) {
		super();
		super.setContato(contato);
		super.setNome(nome);
		this.setRegistroConselho(coren);
	}

	public void setRegistroConselho(String registroConselho) {
		super.registroConselho = Utils.formatarRegistroCoren(registroConselho);
	}
	
	public void manterProntuario(Paciente paciente) {
		System.out.println("Enfermeiro manteve o prontuário!");
	}
}

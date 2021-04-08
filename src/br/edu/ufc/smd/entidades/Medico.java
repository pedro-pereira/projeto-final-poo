package br.edu.ufc.smd.entidades;

public class Medico extends ProfissionalSaude {

	public Medico(String crm, String nome, String contato) {
		super();
		super.setContato(contato);
		super.setNome(nome);
		this.setRegistroConselho(crm);
	}

	public void setRegistroConselho(String registroConselho) {
		super.registroConselho = Utils.formatarRegistroCRM(registroConselho);
	}

	public void realizaExame(Paciente paciente, Exame exame) {
		System.out.println("Médico realizou exame!");
	}
}

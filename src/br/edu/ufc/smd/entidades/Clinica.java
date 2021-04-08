package br.edu.ufc.smd.entidades;

public class Clinica {

	private String endereco;
	
	public Clinica(String endereco) {
		setEndereco(endereco);
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public void agendarAtendimento(Paciente paciente, Medico medico) {
		System.out.println("Clinica agendou o atendimento!");
	}
}

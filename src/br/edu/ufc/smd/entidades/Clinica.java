package br.edu.ufc.smd.entidades;

import java.util.List;

public class Clinica {

	private String endereco;
	
	private List<ProfissionalSaude> profissionais;
	
	private List<Atendimento> atendimentos;
	
	public Clinica(String endereco) {
		setEndereco(endereco);
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public List<ProfissionalSaude> getProfissionais() {
		return profissionais;
	}

	public void setProfissionais(List<ProfissionalSaude> profissionais) {
		this.profissionais = profissionais;
	}

	public List<Atendimento> getAtendimentos() {
		return atendimentos;
	}

	public void setAtendimentos(List<Atendimento> atendimentos) {
		this.atendimentos = atendimentos;
	}

	public void agendarAtendimento(Paciente paciente, Medico medico) {
		System.out.println("A Clínica agendou o atendimento para o paciente " + paciente.getNome() + " para o médico " + medico.getNome());
	}
}

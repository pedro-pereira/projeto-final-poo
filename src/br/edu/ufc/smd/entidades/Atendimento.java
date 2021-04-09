package br.edu.ufc.smd.entidades;

import java.util.Date;

public class Atendimento {
	
	private Date data;
	
	private Date hora;
	
	private Paciente paciente;
	
	private ProfissionalSaude profissionalSaude;
	
	public Atendimento() {
		
	}

	public Atendimento(Date data, Date hora, Paciente paciente, ProfissionalSaude profissionalSaude) {
		setData(data);
		setHora(hora);
		setPaciente(paciente);
		setProfissionalSaude(profissionalSaude);
	}

	public Date getData() {
		return data;
	}
	
	public void setData(Date data) {
		this.data = data;
	}
	
	public Date getHora() {
		return hora;
	}
	
	public void setHora(Date hora) {
		this.hora = hora;
	}
	
	public Paciente getPaciente() {
		return paciente;
	}
	
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
	public ProfissionalSaude getProfissionalSaude() {
		return profissionalSaude;
	}
	
	public void setProfissionalSaude(ProfissionalSaude profissionalSaude) {
		this.profissionalSaude = profissionalSaude;
	}
	
	public void registrar(Paciente paciente, ProfissionalSaude profissionalSaude) {
		this.paciente = paciente;
		this.profissionalSaude = profissionalSaude;
		System.out.println("Atendimento registrado!");
	}
}

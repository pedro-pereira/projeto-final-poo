package br.edu.ufc.smd.entidades;

import java.time.LocalDate;
import java.time.LocalTime;

public class Atendimento {
	
	private LocalDate data;
	
	private LocalTime hora;
	
	private Paciente paciente;
	
	private ProfissionalSaude profissionalSaude;

	public Atendimento(LocalDate data, LocalTime hora, Paciente paciente, ProfissionalSaude profissionalSaude) {
		setData(data);
		setHora(hora);
		setPaciente(paciente);
		setProfissionalSaude(profissionalSaude);
	}

	public LocalDate getData() {
		return data;
	}
	
	public void setData(LocalDate data) {
		this.data = data;
	}
	
	public LocalTime getHora() {
		return hora;
	}
	
	public void setHora(LocalTime hora) {
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
	
	public void registrar() {
		System.out.println("Atendimento registrado!");
	}
}

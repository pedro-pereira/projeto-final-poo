package br.edu.ufc.smd.entidades;

import java.util.Date;

public class Paciente {

	private String nome;
	private Date nascimento;
	private String telefone;
	private String endereco;

	public Paciente(String nome, Date nascimento, String telefone, String endereco) {
		super();
		this.nome = nome;
		this.nascimento = nascimento;
		this.telefone = telefone;
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public void obterResultado () {
		System.out.println("Exame recebido");
	}

}

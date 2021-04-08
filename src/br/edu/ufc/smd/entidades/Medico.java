package br.edu.ufc.smd.entidades;

public class Medico extends ProfissionalSaude {
	
	private String crm;
	
	public Medico(String crm, String nome, String contato) {
		super();
		super.setContato(contato);
		super.setNome(nome);
		this.crm = crm;
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

}

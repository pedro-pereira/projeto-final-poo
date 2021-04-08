package br.edu.ufc.smd.entidades;

public abstract class Exame {
	
	protected long id;
	
	protected String descricao;
	
	protected String preparo;

	public long getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = Long.parseLong(id);
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getPreparo() {
		return preparo;
	}
	
	public void setPreparo(String preparo) {
		this.preparo = preparo;
	}
}

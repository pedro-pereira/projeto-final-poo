package br.edu.ufc.smd.entidades;

public class ExameImagem extends Exame {
	
	static private String perito;

	public ExameImagem(String id, String descricao, String preparo) {
		super();
		super.setId(id);
		super.setDescricao(descricao);
		super.setPreparo(preparo);
	}
	
	static public String getPerito() {
		return ExameImagem.perito;
	}
	
	static public void setPerito(String perito) {
		ExameImagem.perito = perito;
	}
}

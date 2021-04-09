package br.edu.ufc.smd.gui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.edu.ufc.smd.entidades.Exame;
import br.edu.ufc.smd.entidades.ExameImagem;
import br.edu.ufc.smd.entidades.ExameLaboratorial;

class TableModelExame extends AbstractTableModel {

	List<Exame> exames;
	private static final String[] COLUMN_NAMES = { "Tipo", "Id", "Descrição", "Preparo" };

	public TableModelExame(List<Exame> list) {
		exames = list;
	}

	@Override
    public int getColumnCount() {
        return COLUMN_NAMES.length;
    }

	@Override
	public int getRowCount() {
		return exames.size();
	}

	@Override
	public Object getValueAt(int row, int column) {
		Exame exame = null;
		exame = exames.get(row);
 
		switch (column) {
			case 0:
				if(exame instanceof ExameLaboratorial) {
					return "Laboratorial";
				} else if(exame instanceof ExameImagem) {
					return "Imagem";
				}
			case 1:
				return Long.toString(exame.getId());
			case 2:
				return exame.getDescricao();
			case 3:
				return exame.getPreparo();
			default :
		}
		return "";
	}

	 @Override
	    public String getColumnName(int column) {
	        return COLUMN_NAMES[column];
	    }
}
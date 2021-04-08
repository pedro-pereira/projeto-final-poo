package br.edu.ufc.smd.gui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.edu.ufc.smd.entidades.Atendimento;

class TableModelAtendimento extends AbstractTableModel {

	List<Atendimento> atendimentos;
	private static final String[] COLUMN_NAMES = { "Data", "Hora", "Paciente", "Profissional" };

	public TableModelAtendimento(List<Atendimento> list) {
		atendimentos = list;
	}

	@Override
    public int getColumnCount() {
        return COLUMN_NAMES.length;
    }

	@Override
	public int getRowCount() {
		return atendimentos.size();
	}

	// this method is called to set the value of each cell
	@Override
	public Object getValueAt(int row, int column) {
		Atendimento atendimento = null;
		atendimento = atendimentos.get(row);
 
		switch (column) {
			case 0:
				return atendimento.getData().toString();
			case 1:
				return atendimento.getHora().toString();
			case 2:
				return "";
			case 3:
				return "";
			default :
		}
		return "";
	}

	// This method will be used to display the name of columns
	 @Override
	    public String getColumnName(int column) {
		    System.out.println(COLUMN_NAMES[column]);
	        return COLUMN_NAMES[column];
	    }
}
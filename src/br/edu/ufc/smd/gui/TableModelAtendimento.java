package br.edu.ufc.smd.gui;

import java.text.SimpleDateFormat;
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

	@Override
	public Object getValueAt(int row, int column) {
		Atendimento atendimento = null;
		atendimento = atendimentos.get(row);
 
		switch (column) {
			case 0:
				String datePattern = "dd-MM-yyyy";
		        SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);
				return dateFormatter.format(atendimento.getData());
			case 1:
				datePattern = "HH:mm:ss";
		        dateFormatter = new SimpleDateFormat(datePattern);
				return dateFormatter.format(atendimento.getHora());
			case 2:
				return atendimento.getPaciente().toString();
			case 3:
				return atendimento.getProfissionalSaude().toString();
			default :
		}
		return "";
	}

	 @Override
	    public String getColumnName(int column) {
	        return COLUMN_NAMES[column];
	    }
}
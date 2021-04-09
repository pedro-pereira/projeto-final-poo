package br.edu.ufc.smd.gui;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.edu.ufc.smd.entidades.Paciente;

class TableModelPaciente extends AbstractTableModel {

	List<Paciente> pacientes;
	private static final String[] COLUMN_NAMES = { "Nome", "Nascimento", "Telefone", "Endereço" };

	public TableModelPaciente(List<Paciente> list) {
		pacientes = list;
	}

	@Override
    public int getColumnCount() {
        return COLUMN_NAMES.length;
    }

	@Override
	public int getRowCount() {
		return pacientes.size();
	}

	@Override
	public Object getValueAt(int row, int column) {
		Paciente paciente = null;
		paciente = (Paciente) pacientes.get(row);
 
		switch (column) {
 
			case 0:
				return paciente.getNome();
			case 1:
				String datePattern = "dd-MM-yyyy";
		        SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);
				return dateFormatter.format(paciente.getNascimento());
			case 2:
				return paciente.getTelefone();
			case 3:
				return paciente.getEndereco();
			default :
		}
		return "";
	}

	 @Override
	    public String getColumnName(int column) {
	        return COLUMN_NAMES[column];
	    }
}
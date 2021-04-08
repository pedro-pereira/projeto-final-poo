package br.edu.ufc.smd.gui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.edu.ufc.smd.entidades.Medico;
import br.edu.ufc.smd.entidades.Paciente;
import br.edu.ufc.smd.entidades.ProfissionalSaude;

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

	// this method is called to set the value of each cell
	@Override
	public Object getValueAt(int row, int column) {
		Paciente paciente = null;
		paciente = (Paciente) pacientes.get(row);
 
		switch (column) {
 
			case 0:
				return paciente.getNome();
			case 1:
				return paciente.getNascimento();
			case 2:
				return paciente.getTelefone();
			case 3:
				return paciente.getEndereco();
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
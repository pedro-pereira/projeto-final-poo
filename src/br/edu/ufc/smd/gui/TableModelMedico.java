package br.edu.ufc.smd.gui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.edu.ufc.smd.entidades.Medico;
import br.edu.ufc.smd.entidades.ProfissionalSaude;

class TableModelMedico extends AbstractTableModel {

	List<ProfissionalSaude> profissionais;
	private static final String[] COLUMN_NAMES = { "Perfil", "Crm", "Nome", "Contato" };

	public TableModelMedico(List<ProfissionalSaude> list) {
		profissionais = list;
	}

	@Override
    public int getColumnCount() {
        return COLUMN_NAMES.length;
    }

	@Override
	public int getRowCount() {
		return profissionais.size();
	}

	// this method is called to set the value of each cell
	@Override
	public Object getValueAt(int row, int column) {
		ProfissionalSaude profissionalSaude = null;
		profissionalSaude = (Medico) profissionais.get(row);
 
		switch (column) {
 
			case 0:
				return "Médico";
			case 1:
				return ((Medico) profissionalSaude).getCrm();
			case 2:
				return profissionalSaude.getNome();
			case 3:
				return profissionalSaude.getContato();
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
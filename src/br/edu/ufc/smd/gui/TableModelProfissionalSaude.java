package br.edu.ufc.smd.gui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.edu.ufc.smd.entidades.Enfermeiro;
import br.edu.ufc.smd.entidades.Medico;
import br.edu.ufc.smd.entidades.ProfissionalSaude;
import br.edu.ufc.smd.entidades.Tecnico;

class TableModelProfissionalSaude extends AbstractTableModel {

	List<ProfissionalSaude> profissionais;
	private static final String[] COLUMN_NAMES = { "Perfil", "Crm", "Nome", "Contato" };

	public TableModelProfissionalSaude(List<ProfissionalSaude> list) {
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
		profissionalSaude = profissionais.get(row);
 
		switch (column) {
			case 0:
				if(profissionalSaude instanceof Medico) {
					return "Médico";
				} else if(profissionalSaude instanceof Enfermeiro) {
					return "Enfermeiro";
				} else if(profissionalSaude instanceof Tecnico) {
					return "Técnico";
				}
			case 1:
				return profissionalSaude.getRegistroConselho();
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
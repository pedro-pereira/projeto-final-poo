package br.edu.ufc.smd.gui;

import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

import br.edu.ufc.smd.entidades.Paciente;

public class PacienteComboModel extends AbstractListModel<Paciente> implements ComboBoxModel<Paciente> {

    private List<Paciente> lista;

    /* Seleciona um objeto na caixa de seleção */
    private Paciente selecionado;

    /* Método construtor */
    public PacienteComboModel(List<Paciente> lista) {
        /* Popula a lista */
        this.lista = lista;
    }

    /* Captura o tamanho da listagem */
    public int getSize() {
        int totalElementos = lista.size();
        return totalElementos;
    }

    /* Captura um elemento da lista em uma posição informada */
    public Paciente getElementAt(int indice) {
    	Paciente t = lista.get(indice);
        return t;
    }

    /* Marca um objeto na lista como selecionado */
    public void setSelectedItem(Object item) {
        selecionado = (Paciente) item;
    }

    /* Captura o objeto selecionado da lista */
    public Object getSelectedItem() {
        return selecionado;
    }
}

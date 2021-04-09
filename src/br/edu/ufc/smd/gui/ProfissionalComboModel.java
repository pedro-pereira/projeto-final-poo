package br.edu.ufc.smd.gui;

import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

import br.edu.ufc.smd.entidades.ProfissionalSaude;

public class ProfissionalComboModel extends AbstractListModel<ProfissionalSaude> implements ComboBoxModel<ProfissionalSaude> {

    private List<ProfissionalSaude> lista;

    /* Seleciona um objeto na caixa de seleção */
    private ProfissionalSaude selecionado;

    /* Método construtor */
    public ProfissionalComboModel(List<ProfissionalSaude> lista) {
        /* Popula a lista */
        this.lista = lista;
    }

    /* Captura o tamanho da listagem */
    public int getSize() {
        int totalElementos = lista.size();
        return totalElementos;
    }

    /* Captura um elemento da lista em uma posição informada */
    public ProfissionalSaude getElementAt(int indice) {
    	ProfissionalSaude t = lista.get(indice);
        return t;
    }

    /* Marca um objeto na lista como selecionado */
    public void setSelectedItem(Object item) {
        selecionado = (ProfissionalSaude) item;
    }

    /* Captura o objeto selecionado da lista */
    public Object getSelectedItem() {
        return selecionado;
    }
}

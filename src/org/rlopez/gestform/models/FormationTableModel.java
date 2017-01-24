/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.rlopez.gestform.models;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author rico
 */
public class FormationTableModel extends AbstractTableModel {
    
    private final String[] entetes = {"Id", "Nom"};
    private List<Formation> formations;

    public FormationTableModel(List<Formation> formations) {
        this.formations = formations;
    }

    @Override
    public String getColumnName(int column) {
        return entetes[column];
    }

    @Override
    public int getRowCount() {
        return formations.size();
    }

    @Override
    public int getColumnCount() {
        return entetes.length;
    }

    public Formation getFormation(int rowIndex){
        return formations.get(rowIndex);
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {

            case 0:
                return formations.get(rowIndex).getId();

            case 1:
                return formations.get(rowIndex).getNom();


            default:
                throw new IllegalArgumentException();
        }

}
}

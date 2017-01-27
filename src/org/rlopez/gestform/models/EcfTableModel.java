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
public class EcfTableModel  extends AbstractTableModel {
    
    private final String[] entetes = {"Id", "Nom", "id_formation", "resultat"};
    private List<Ecf> ecfs;

    public EcfTableModel(List<Ecf> ecfs) {
        this.ecfs = ecfs;
    }
    
    public void setModel(List<Ecf> ecfs) {
        this.ecfs = ecfs;
        fireTableDataChanged();
    }
    
    public void addEcf(Ecf ecf){
        this.ecfs.add(ecf);
        this.fireTableDataChanged();
}
    
        public void delEcf(Ecf ecf){
        this.ecfs.remove(ecf);
        this.fireTableDataChanged();
}

    @Override
    public String getColumnName(int column) {
        return entetes[column];
    }

    @Override
    public int getRowCount() {
        return ecfs.size();
    }

    @Override
    public int getColumnCount() {
        return entetes.length;
    }

    public Ecf getEcf(int rowIndex){
        return ecfs.get(rowIndex);
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {

            case 0:
                return ecfs.get(rowIndex).getId();

            case 1:
                return ecfs.get(rowIndex).getNom();
                
            case 2:
                return ecfs.get(rowIndex).getId_formation();
            
            case 3:
                return ecfs.get(rowIndex).getResultat();


            default:
                throw new IllegalArgumentException();
        }

}
}
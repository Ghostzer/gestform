/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.rlopez.gestform.models;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import org.rlopez.gestform.dao.EcfDAO;

/**
 *
 * @author rico
 */
public class EcfTableModel  extends AbstractTableModel {
    
    private final String[] entetes = {"Nom", "Formation", "Resultat"};
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
        Ecf ecf = ecfs.get(rowIndex);
        switch (columnIndex) {

            case 0:
                return ecf.getNom();

            case 1:
                Formation form = ecf.getFormation();
                return form.getNom();
                
            case 2:
                return ecf.getResultat();


            default:
                throw new IllegalArgumentException();
        }

}
    
    @Override
      public Class<?> getColumnClass(int columnIndex) {
          return getValueAt(0, columnIndex).getClass();
}
      
      @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Ecf ecf = ecfs.get(rowIndex);
        if (columnIndex==2){
            ecf.setResultat(((Boolean)aValue));
            try {
                //update database
                EcfDAO.updateResultat(ecf);
                fireTableCellUpdated(rowIndex, columnIndex);// notify listeners
                
            } catch (Exception ex) {
//                Logger.getLogger(ECFTableModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
        @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return (columnIndex==2);
}
      
}
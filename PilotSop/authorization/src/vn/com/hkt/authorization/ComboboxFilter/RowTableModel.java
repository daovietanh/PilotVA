/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.authorization.ComboboxFilter;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Admin
 */
public class RowTableModel extends AbstractTableModel {

    private Row row;

    public RowTableModel(Row row) {
        this.row = row;
    }

    @Override
    public int getRowCount() {
        return 1;
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return row.getId();
            case 1:
                return row.getVal();
            case 2:
                return row.getExtra();
        }
        return null;
    }
}

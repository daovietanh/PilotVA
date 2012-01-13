/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.chart.ui.panel;

import java.awt.Component;
import javax.swing.AbstractCellEditor;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellEditor;

/**
 *
 * @author longnt
 */
public class CommonCell extends AbstractCellEditor implements TableCellEditor {
    
    private Component component;
    private JComboBox cboQuocgia, cboCity, cboVung;
    private JTextField txtPCode;

    public CommonCell() {
        
        txtPCode = new JTextField();

        cboQuocgia = new JComboBox();
        cboVung = new JComboBox();
        cboCity = new JComboBox();
    }

    @Override
    public Object getCellEditorValue() {
        if (component == cboVung) {
            return cboVung.getSelectedItem();
        } else if (component == txtPCode) {
            return txtPCode.getText();
        } else if (component == cboQuocgia) {
            return cboQuocgia.getSelectedItem();
        } else {
            return cboCity.getSelectedItem();
        }
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        if (column == 1) {
            if (row == 3) {
                component = txtPCode;
            }
            if (row == 0) {
                component = cboQuocgia;
            }
            if (row == 4) {
                component = cboQuocgia;
            }
            if (row == 1) {
                component = cboVung;
            }
            if (row == 2) {
                component = cboCity;
            }
        }
        return component;
    }
}

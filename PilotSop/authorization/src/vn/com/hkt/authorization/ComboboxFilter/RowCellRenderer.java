/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.authorization.ComboboxFilter;

import java.awt.Component;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;

/**
 *
 * @author Admin
 */
public class RowCellRenderer extends JTable implements
        ListCellRenderer {

    public RowCellRenderer() {
        setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
    }

    @Override
    public Component getListCellRendererComponent(JList list, Object value,
            int index, boolean isSelected, boolean cellHasFocus) {
        setModel(new RowTableModel((Row) value));
        if (isSelected) {
            getSelectionModel().setSelectionInterval(0, 0);
        }
        return this;
    }
}

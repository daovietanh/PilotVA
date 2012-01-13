/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.pilot.ui.setup;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

/**
 *
 * @author VietAnh
 */
public class StripedTableCellRenderer implements TableCellRenderer {
  public StripedTableCellRenderer(TableCellRenderer targetRenderer,
      Color evenBack, Color evenFore, Color oddBack, Color oddFore) {
    this.targetRenderer = targetRenderer;
    this.evenBack = evenBack;
    this.evenFore = evenFore;
    this.oddBack = oddBack;
    this.oddFore = oddFore;
  }

  // Implementation of TableCellRenderer interface
    @Override
  public Component getTableCellRendererComponent(JTable table, Object value,
      boolean isSelected, boolean hasFocus, int row, int column) {
        //JOptionPane.showMessageDialog(null,"aaaaaaa");
    TableCellRenderer renderer = targetRenderer;
    if (renderer == null) {
      // Get default renderer from the table
      renderer = table.getDefaultRenderer(table.getColumnClass(column));
    }

    // Let the real renderer create the component
    Component comp = renderer.getTableCellRendererComponent(table, value,
        isSelected, hasFocus, row, column);

    // Now apply the stripe effect
    if (isSelected == false && hasFocus == false) {
      if ((row & 1) == 0) {
        comp.setBackground(evenBack != null ? evenBack : table
            .getBackground());
        //JOptionPane.showMessageDialog(null,"gia tri"+ (row&1)+"");
        comp.setForeground(evenFore != null ? evenFore : table
            .getForeground());
      } else {
        comp.setBackground(oddBack != null ? oddBack : table
            .getBackground());
        comp.setForeground(oddFore != null ? oddFore : table
            .getForeground());
      }
    }

    return comp;
  }

  // Convenience method to apply this renderer to single column
  public static void installInColumn(JTable table,
      Color evenBack, Color evenFore, Color oddBack, Color oddFore) {
      TableColumn tc = table.getColumnModel().getColumn(0);

    // Get the cell renderer for this column, if any
    TableCellRenderer targetRenderer = tc.getCellRenderer();

    // Create a new StripedTableCellRenderer and install it
    tc.setCellRenderer(new StripedTableCellRenderer(targetRenderer,
        evenBack, evenFore, oddBack, oddFore));
    
  }

  protected TableCellRenderer targetRenderer;

  protected Color evenBack;

  protected Color evenFore;

  protected Color oddBack;

  protected Color oddFore;
}




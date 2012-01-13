/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PersonPanel.java
 *
 * Created on Nov 23, 2011, 3:16:47 PM
 */
package vn.com.hkt.hrm.person.ui;

import javax.swing.JTable;
import org.openide.windows.WindowManager;

/**
 *
 * @author longnt
 */
public class PersonPanel extends javax.swing.JPanel {

    /** Creates new form PersonPanel */
    public PersonPanel() {
        initComponents();

        tabelPerson.getColumnModel().getColumn(1).setCellEditor(new PersonCell());
    }

    public JTable getTabelPerson() {
        return tabelPerson;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelPerson = new javax.swing.JTable();

        tabelPerson.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Họ (first name)", " "},
                {"Tên (last name)", " "},
                {"Công ty", " "},
                {"Bộ phận", " "},
                {"Chức vụ", " "},
                {"Mã Person", " "},
                {"Ảnh", " "}

            },
            new String [] {
                "", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelPerson.setRowHeight(25);
        tabelPerson.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelPersonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelPerson);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tabelPersonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelPersonMouseClicked

          if (evt.getClickCount()==2) {
        if (tabelPerson.getSelectedRow() == 4) {
                EditChucVuDialog editChucVuDialog = new EditChucVuDialog();
                editChucVuDialog.show();
            }
        }
    }//GEN-LAST:event_tabelPersonMouseClicked
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelPerson;
    // End of variables declaration//GEN-END:variables
}

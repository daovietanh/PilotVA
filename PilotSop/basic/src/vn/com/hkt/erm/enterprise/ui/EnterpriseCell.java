/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.erm.enterprise.ui;

import vn.com.hkt.pilot.entities.Enterprise;
import vn.com.hkt.pilot.entities.Person;
import vn.com.hkt.basic.api.IEnterpriseBN;
import vn.com.hkt.basic.api.IPersonBN;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellEditor;
import org.openide.util.Lookup;

/**
 *
 * @author longnt
 */
public class EnterpriseCell extends AbstractCellEditor implements TableCellEditor, MouseListener {

    private Component component;
    private JComboBox cboEnterprise, cboPerson;
    private JTextField txtNameE, txtIdE, txtLogo, txtSlogan;
    private JFileChooser chooser;
    private DefaultComboBoxModel modelPerson, modelEnter;
    private IEnterpriseBN enterpriseDAO;
    private IPersonBN personDAO;

    public JTextField getTxtIdE() {
        return txtIdE;
    }

    public JTextField getTxtNameE() {
        return txtNameE;
    }
    

    public EnterpriseCell() {
        
        this.enterpriseDAO = Lookup.getDefault().lookup(IEnterpriseBN.class);
        this.personDAO = Lookup.getDefault().lookup(IPersonBN.class);
        txtIdE = new JTextField();
        txtLogo = new JTextField();
        txtLogo.addMouseListener(this);
        txtNameE = new JTextField();
        txtSlogan = new JTextField();

        modelEnter = new DefaultComboBoxModel();
        modelEnter.addElement(" ");
        modelPerson = new DefaultComboBoxModel();
        modelPerson.addElement(" ");
        txtIdE.setText(" ");
        txtNameE.setText(" ");

        // Create model for combobox

        List<Enterprise> list = new ArrayList<Enterprise>();
        list = enterpriseDAO.getAllEnterprise();
        for (Enterprise bean : list) {
            modelEnter.addElement(bean);
        }

        List<Person> list1 = new ArrayList<Person>();
        list1 = personDAO.getAllPerson();
        for (Person bean : list1) {
            modelPerson.addElement(bean);
        }

        cboEnterprise = new JComboBox(modelEnter);
        cboPerson = new JComboBox(modelPerson);

    }

    @Override
    public Object getCellEditorValue() {
        if (component == txtIdE) {
            return txtIdE.getText();
        } else if (component == txtLogo) {
            return txtLogo.getText();
        } else if (component == txtNameE) {
            return txtNameE.getText();
        } else if (component == txtSlogan) {
            return txtSlogan.getText();
        } else if (component == cboEnterprise) {
            if (cboEnterprise.getSelectedItem().toString().trim().length() != 0) {
                return (Enterprise) cboEnterprise.getSelectedItem();
            } else {
                return cboEnterprise.getSelectedItem();
            }
        } else {
             if (cboPerson.getSelectedItem().toString().trim().length() != 0) {
                return (Person) cboPerson.getSelectedItem();
            } else {
                return cboPerson.getSelectedItem();
            }
        }
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        if (column == 1) {
            if (row == 0) {
                component = txtNameE;
            }
            if (row == 1) {
                component = txtIdE;
            }
            if (row == 2) {
                component = cboEnterprise;
            }
            if (row == 3) {
                component = cboPerson;
            }
            if (row == 4) {
                component = txtLogo;
            }
            if (row == 5) {
                component = txtSlogan;
            }
        }
        return component;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        mouseEvent(e);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        mouseEvent(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        mouseEvent(e);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        mouseEvent(e);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        mouseEvent(e);
    }

    public void mouseEvent(MouseEvent e) {
        if (e.getClickCount() == 2) {
            chooser = new JFileChooser();
            chooser.setCurrentDirectory(new File("."));

            chooser.setFileFilter(new javax.swing.filechooser.FileFilter() {

                @Override
                public boolean accept(File f) {
                    return f.getName().toLowerCase().endsWith(".jpg")
                            || f.isDirectory();
                }

                @Override
                public String getDescription() {
                    return "JPG Images";
                }
            });

            int r = chooser.showOpenDialog(new JFrame());
            if (r == JFileChooser.APPROVE_OPTION) {
                String name = chooser.getSelectedFile().getName();
                txtLogo.setText(name);
            }
        }
    }
}

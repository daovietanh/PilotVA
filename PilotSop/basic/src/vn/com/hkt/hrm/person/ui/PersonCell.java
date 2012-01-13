/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.hrm.person.ui;

import java.awt.event.ItemEvent;
import vn.com.hkt.pilot.entities.Department;
import vn.com.hkt.pilot.entities.Enterprise;
import vn.com.hkt.basic.api.IDepartmentBN;
import vn.com.hkt.basic.api.IEnterpriseBN;
import java.awt.Component;
import java.awt.event.ItemListener;
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
import vn.com.hkt.pilot.dialog.dao.MissionBN;
import vn.com.hkt.pilot.entities.Mission;

/**
 *
 * @author longnt
 */
public class PersonCell extends AbstractCellEditor implements TableCellEditor, MouseListener, ItemListener {

    private Component component;
    private JComboBox cboEnterprise, cboBophan, cboChucvu;
    private JTextField txtFName, txtIdP, txtPhoto, txtLName;
    private JFileChooser chooser;
    private DefaultComboBoxModel modelEnter, modelBophan, modelChucvu;
    private IEnterpriseBN enterpriseBN;
    private MissionBN missionBN;
    private Enterprise enterprise;

    public JTextField getTxtFName() {
        return txtFName;
    }

    public JTextField getTxtIdP() {
        return txtIdP;
    }

    public JTextField getTxtLName() {
        return txtLName;
    }
    private IDepartmentBN departmentBN;

    public PersonCell() {
        enterprise = new Enterprise();
        this.enterpriseBN = Lookup.getDefault().lookup(IEnterpriseBN.class);
        this.departmentBN = Lookup.getDefault().lookup(IDepartmentBN.class);
        missionBN = new MissionBN();
        txtIdP = new JTextField();
        txtPhoto = new JTextField();
        txtPhoto.addMouseListener(this);
        txtFName = new JTextField();

        txtLName = new JTextField();
        modelEnter = new DefaultComboBoxModel();
        modelEnter.addElement(" ");

        modelBophan = new DefaultComboBoxModel();
        modelBophan.addElement(" ");

        modelChucvu = new DefaultComboBoxModel();
        modelChucvu.addElement(" ");

        txtFName.setText(" ");
        txtIdP.setText(" ");
        txtLName.setText(" ");
        txtPhoto.setText(" ");


        List<Enterprise> list = new ArrayList<Enterprise>();
        list = enterpriseBN.getAllEnterprise();
        for (Enterprise bean : list) {
            modelEnter.addElement(bean);
        }

        List<Mission> list2 = new ArrayList<Mission>();
        list2 = missionBN.getAllMission();
        for (Mission bean : list2) {
            modelChucvu.addElement(bean);
        }
        cboBophan = new JComboBox(modelBophan);
        cboEnterprise = new JComboBox(modelEnter);
        cboChucvu = new JComboBox(modelChucvu);
    }

    @Override
    public Object getCellEditorValue() {
        if (component == txtIdP) {
            return txtIdP.getText();
        } else if (component == txtPhoto) {
            return txtPhoto.getText();
        } else if (component == txtFName) {
            return txtFName.getText();
        } else if (component == cboBophan) {
            if (cboBophan.getSelectedItem().toString().trim().length() != 0) {
                return (Department) cboBophan.getSelectedItem();
            } else {
                return cboBophan.getSelectedItem();
            }
        } else if (component == cboEnterprise) {
            if (cboEnterprise.getSelectedItem().toString().trim().length() != 0) {
                return (Enterprise) cboEnterprise.getSelectedItem();
            } else {
                return cboEnterprise.getSelectedItem();
            }
        } else if (component == cboChucvu) {
            return cboChucvu.getSelectedItem();
        } else {
            return txtLName.getText();
        }
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        if (column == 1) {
            if (row == 0) {
                component = txtFName;
            }
            if (row == 5) {
                component = txtIdP;
            }
            if (row == 2) {
                component = cboEnterprise;
            }
            if (row == 1) {
                component = txtLName;
            }
            if (row == 4) {
                component = cboChucvu;
            }
            if (row == 6) {
                component = txtPhoto;
            }
            if (row == 3) {
                component = cboBophan;
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

                public boolean accept(File f) {
                    return f.getName().toLowerCase().endsWith(".jpg")
                            || f.isDirectory();
                }

                public String getDescription() {
                    return "GIF Images";
                }
            });

            int r = chooser.showOpenDialog(new JFrame());
            if (r == JFileChooser.APPROVE_OPTION) {
                String name = chooser.getSelectedFile().getName();
                txtPhoto.setText(name);
            }
        }

    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        JComboBox comboBox = (JComboBox) e.getSource();
        if (comboBox == cboEnterprise) {
            if (cboEnterprise.getSelectedItem().toString().trim().length() != 0) {
                enterprise = (Enterprise) cboEnterprise.getSelectedItem();
                modelBophan.removeAllElements();
                modelBophan.addElement(" ");
                List<Department> list1 = new ArrayList<Department>();
                list1 = departmentBN.filterDepartmentByEnterprise(enterprise);
                for (Department bean : list1) {
                    modelBophan.addElement(bean);
                }
            }
        }

    }

    public void resetCombobox(Enterprise enterprise) {
        modelBophan.removeAllElements();
        modelBophan.addElement(" ");
        List<Department> list1 = new ArrayList<Department>();
        list1 = departmentBN.filterDepartmentByEnterprise(enterprise);
        for (Department bean : list1) {
            modelBophan.addElement(bean);
        }
    }
}

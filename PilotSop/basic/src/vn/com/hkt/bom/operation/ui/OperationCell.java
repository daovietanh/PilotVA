/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.bom.operation.ui;

/**
 *
 * @author longnt
 */
import java.awt.event.ItemEvent;
import vn.com.hkt.pilot.entities.Department;
import vn.com.hkt.pilot.entities.Enterprise;
import vn.com.hkt.pilot.entities.Person;
import vn.com.hkt.pilot.entities.Product;
import vn.com.hkt.basic.api.IDepartmentBN;
import vn.com.hkt.basic.api.IEnterpriseBN;
import vn.com.hkt.basic.api.IPersonBN;
import vn.com.hkt.basic.api.IProductBN;
import java.awt.Component;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.AbstractCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.table.TableCellEditor;
import org.openide.util.Lookup;
import vn.com.hkt.pilot.dialog.api.IUnitsOfMeasurement;
import vn.com.hkt.pilot.dialog.dao.ClassificationBN;
import vn.com.hkt.pilot.entities.Classification;
import vn.com.hkt.pilot.entities.UnitsOfMeasurement;

/**
 *
 * @author longnt
 */
public class OperationCell extends AbstractCellEditor implements TableCellEditor, ItemListener {

    private Component component;
    private JComboBox cboEnterprise, cboPerson, cboProduct, cboDepartment,// cboUnit,
            cboPhanloai, cbDonViDo;
    private JTextField txtNameO, txtIdO, txtSoluong, txtDongia, txtTonggia, txtDonviTinh;
    private JSpinner spinnerDate;
    private Date date;
    private JSpinner.DateEditor dateEditor;
    private DefaultComboBoxModel modelPerson, modelEnter, modelDepartment, modelProduct, modelPhanloai, modelDonViDo;
    private IEnterpriseBN enterpriseDAO;
    private IProductBN productBN;
    private IPersonBN personBN;
    private IDepartmentBN departmentBN;
    private ClassificationBN iClassification;
    private IUnitsOfMeasurement unitsOfMeasurementDAO;
    private Enterprise enterprise = null;

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    // private OperationCell operationCell = new OperationCell();
    public OperationCell() {
        this.productBN = Lookup.getDefault().lookup(IProductBN.class);
        this.personBN = Lookup.getDefault().lookup(IPersonBN.class);
        this.enterpriseDAO = Lookup.getDefault().lookup(IEnterpriseBN.class);
        this.departmentBN = Lookup.getDefault().lookup(IDepartmentBN.class);
        iClassification = new ClassificationBN();
        this.unitsOfMeasurementDAO = Lookup.getDefault().lookup(IUnitsOfMeasurement.class);
        txtIdO = new JTextField();
        txtNameO = new JTextField();
        txtSoluong = new JTextField();
        txtDongia = new JTextField();
        txtTonggia = new JTextField();

        txtDongia.setText("0");
        txtIdO.setText(" ");
        txtNameO.setText(" ");
        // txtTonggia.setText("0");
        txtSoluong.setText("0");

        modelEnter = new DefaultComboBoxModel();
        modelEnter.addElement(" ");
        modelPerson = new DefaultComboBoxModel();
        modelPerson.addElement(" ");
        modelDepartment = new DefaultComboBoxModel();
        modelDepartment.addElement(" ");
        modelProduct = new DefaultComboBoxModel();
        modelProduct.addElement(" ");
        modelPhanloai = new DefaultComboBoxModel();
        modelPhanloai.addElement(" ");

        modelDonViDo = new DefaultComboBoxModel();
        modelDonViDo.addElement(" ");

        List<Enterprise> list = new ArrayList<Enterprise>();
        list = enterpriseDAO.getAllEnterprise();
        for (Enterprise bean : list) {
            modelEnter.addElement(bean);
        }

        List<Classification> list4 = new ArrayList<Classification>();
        list4 = iClassification.getAllClassification();
        for (Classification bean : list4) {
            modelPhanloai.addElement(bean);
        }

        List<UnitsOfMeasurement> list5 = new ArrayList<UnitsOfMeasurement>();
        list5 = unitsOfMeasurementDAO.getAllUnitsOfMeasurement();
        for (UnitsOfMeasurement bean : list5) {
            modelDonViDo.addElement(bean);
        }

        cboEnterprise = new JComboBox(modelEnter);
        cboPerson = new JComboBox(modelPerson);
        cboDepartment = new JComboBox(modelDepartment);
        cboProduct = new JComboBox(modelProduct);
        cboPhanloai = new JComboBox(modelPhanloai);

        cbDonViDo = new JComboBox(modelDonViDo);

        // Set index = null for combobox
        cboEnterprise.setSelectedIndex(0);
        cboPerson.setSelectedIndex(0);
        cboDepartment.setSelectedIndex(0);
        cboProduct.setSelectedIndex(0);

        cbDonViDo.setSelectedIndex(0);
        //  cboUnit = new JComboBox();

        //txtDongia = new JTextField();
        txtDonviTinh = new JTextField();
        txtDonviTinh.setText(" ");
        // txtTonggia = new JTextField();

        date = new Date();

        spinnerDate = new JSpinner(new SpinnerDateModel(date, null, null, Calendar.YEAR));
        dateEditor = new JSpinner.DateEditor(spinnerDate, "dd/MM/yyyy");
        spinnerDate.setEditor(dateEditor);
        cboEnterprise.addItemListener(this);
    }

    public JComboBox getCbDonViDo() {
        return cbDonViDo;
    }

    public JComboBox getCboPhanloai() {
        return cboPhanloai;
    }

    public JTextField getTxtDongia() {
        return txtDongia;
    }

    public JTextField getTxtNameO() {
        return txtNameO;
    }

    public JTextField getTxtDonviTinh() {
        return txtDonviTinh;
    }

    public JTextField getTxtSoluong() {
        return txtSoluong;
    }

    public JTextField getTxtTonggia() {
        return txtTonggia;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {


        if (column == 1) {
            if (row == 0) {

                component = txtNameO;
            }
            if (row == 1) {

                component = txtIdO;
            }
            if (row == 4) {
                component = cboEnterprise;
            }
            if (row == 8) {
                component = txtSoluong;
            }
            if (row == 2) {
                component = spinnerDate;
            }
            if (row == 7) {
                component = cboPhanloai;
            }
            if (row == 3) {
                component = cboProduct;
            }
            if (row == 5) {
                component = cboDepartment;
            }
            if (row == 6) {
                component = cboPerson;
            }
            if (row == 9) {
                component = txtDongia;
            }
            if (row == 10) {
                component = txtTonggia;
            }
            if (row == 11) {
                component = txtDonviTinh;
            }
            if (row == 12) {
                component = cbDonViDo;
            }
        }

        return component;
    }

    @Override
    public Object getCellEditorValue() {
        if (component == txtIdO) {
            return txtIdO.getText();
        } else if (component == spinnerDate) {
            return dateEditor.getFormat().format(spinnerDate.getValue());
        } else if (component == txtNameO) {
            return txtNameO.getText();
        } else if (component == cboPhanloai) {
            return cboPhanloai.getSelectedItem();
        } else if (component == cboEnterprise) {
            if (cboEnterprise.getSelectedItem().toString().trim().length() != 0) {
                return (Enterprise) cboEnterprise.getSelectedItem();
            } else {
                return cboEnterprise.getSelectedItem();
            }

        } else if (component == cboDepartment) {
            if (cboDepartment.getSelectedItem().toString().trim().length() != 0) {
                return (Department) cboDepartment.getSelectedItem();
            } else {
                return cboDepartment.getSelectedItem();
            }
        } else if (component == cboPerson) {
            if (cboPerson.getSelectedItem().toString().trim().length() != 0) {
                return (Person) cboPerson.getSelectedItem();
            } else {
                return cboPerson.getSelectedItem();
            }
        } else if (component == cboProduct) {
            if (cboProduct.getSelectedItem().toString().trim().length() != 0) {
                return (Product) cboProduct.getSelectedItem();
            } else {
                return cboProduct.getSelectedItem();
            }
        } else if (component == cbDonViDo) {
            return cbDonViDo.getSelectedItem();
        } else if (component == txtDongia) {
            return txtDongia.getText();
        } else if (component == txtSoluong) {
            return txtSoluong.getText();
        } else if (component == txtDonviTinh) {
            return txtDonviTinh.getText();
        } else {
            txtTonggia.setText(String.valueOf((Integer.parseInt(txtDongia.getText())) * Integer.parseInt(txtSoluong.getText())));
            return txtTonggia.getText();
        }

    }

    public JTextField getTxtIdO() {
        return txtIdO;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        JComboBox comboBox = (JComboBox) e.getSource();
        if (comboBox == cboEnterprise) {
            if (cboEnterprise.getSelectedItem().toString().trim().length() != 0) {
                enterprise = (Enterprise) cboEnterprise.getSelectedItem();

                modelDepartment.removeAllElements();
                modelPerson.removeAllElements();
                modelProduct.removeAllElements();

                modelDepartment.addElement(" ");
                modelPerson.addElement(" ");
                modelProduct.addElement(" ");
                List<Person> list1 = new ArrayList<Person>();
                list1 = personBN.filterPersonByEnterprise(enterprise);

                for (Person bean : list1) {
                    modelPerson.addElement(bean);
                }

                List<Department> list2 = new ArrayList<Department>();
                list2 = departmentBN.filterDepartmentByEnterprise(enterprise);
                for (Department bean : list2) {
                    modelDepartment.addElement(bean);
                }

                List<Product> list3 = new ArrayList<Product>();
                list3 = productBN.getByEnterprise(enterprise);
                for (Product bean : list3) {
                    modelProduct.addElement(bean);
                }

            }
            this.getCellEditorValue();
        }
    }

    public void resetCombobox(Enterprise enterprise) {

        modelDepartment.removeAllElements();
        modelPerson.removeAllElements();
        modelProduct.removeAllElements();

        modelDepartment.addElement(" ");
        modelPerson.addElement(" ");
        modelProduct.addElement(" ");
        List<Person> list1 = new ArrayList<Person>();
        list1 = personBN.filterPersonByEnterprise(enterprise);

        for (Person bean : list1) {
            modelPerson.addElement(bean);
        }

        List<Department> list2 = new ArrayList<Department>();
        list2 = departmentBN.filterDepartmentByEnterprise(enterprise);
        for (Department bean : list2) {
            modelDepartment.addElement(bean);
        }

        List<Product> list3 = new ArrayList<Product>();
        list3 = productBN.getByEnterprise(enterprise);
        for (Product bean : list3) {
            modelProduct.addElement(bean);
        }

    }
}

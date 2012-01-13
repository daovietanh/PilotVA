/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.bom.operation.ui;

import java.io.IOException;
import vn.com.hkt.pilot.entities.Operation;
import vn.com.hkt.basic.api.IOperationBN;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.openide.util.NbBundle;
import org.openide.windows.TopComponent;
import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.util.Lookup;
import org.openide.util.lookup.ServiceProvider;
import org.openide.windows.WindowManager;
import vn.com.hkt.bom.product.ui.ProductTopComponent;
import vn.com.hkt.erm.department.ui.DepartmentTopComponent;
import vn.com.hkt.erm.enterprise.ui.EnterpriseTopComponent;
import vn.com.hkt.hrm.person.ui.PersonTopComponent;
import vn.com.hkt.pilot.entities.Department;
import vn.com.hkt.pilot.entities.Enterprise;
import vn.com.hkt.pilot.entities.Person;
import vn.com.hkt.pilot.entities.Product;
import vn.com.hkt.pilot.enterprise.viewer.api.Observable;
import vn.com.hkt.pilot.enterprise.viewer.api.Observer;
import vn.com.hkt.pilot.enterprise.viewer.api.ResetCookieList;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(dtd = "-//vn.com.hkt.bom.operation.ui//Operation//EN",
autostore = false)
@TopComponent.Description(preferredID = "OperationTopComponent",
//iconBase="SET/PATH/TO/ICON/HERE", 
persistenceType = TopComponent.PERSISTENCE_ALWAYS)
@TopComponent.Registration(mode = "editor", openAtStartup = false)
@ActionID(category = "Window", id = "vn.com.hkt.bom.operation.ui.OperationTopComponent")
@ActionReference(path = "Menu/Nhập Số Liệu" /*, position = 333 */)
@TopComponent.OpenActionRegistration(displayName = "#CTL_OperationAction",
preferredID = "OperationTopComponent")
@ServiceProvider(service = ResetCookieList.class)
public final class OperationTopComponent extends TopComponent implements ActionListener, ResetCookieList, Observer, Observable {

    private IOperationBN operationBN;
    private OperationPanel operationPanel = new OperationPanel();
    private Vector obs;
    private boolean change = false;

    public Vector getObs() {
        return obs;
    }

    public OperationTopComponent() {
        initComponents();
        setName(NbBundle.getMessage(OperationTopComponent.class, "CTL_OperationTopComponent"));
        setToolTipText(NbBundle.getMessage(OperationTopComponent.class, "HINT_OperationTopComponent"));
        // panelForm.setLayout(new GridLayout());
        buttonEdit.setEnabled(false);

        buttonSaveDS.addActionListener(this);
        buttonEdit.addActionListener(this);
        buttonExit.addActionListener(this);
        buttonHelp.addActionListener(this);
        buttonReset.addActionListener(this);
        buttonSave.addActionListener(this);

        this.operationBN = Lookup.getDefault().lookup(IOperationBN.class);
        obs = new Vector();
    }

    public JPanel getPanelForm() {
        return panelForm;
    }

    public JButton getButtonEdit() {
        return buttonEdit;
    }

    public OperationPanel getOperationPanel() {
        return operationPanel;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelForm = new javax.swing.JPanel();
        panelButton = new javax.swing.JPanel();
        buttonReset = new javax.swing.JButton();
        buttonEdit = new javax.swing.JButton();
        buttonSave = new javax.swing.JButton();
        buttonExit = new javax.swing.JButton();
        buttonHelp = new javax.swing.JButton();
        buttonSaveDS = new javax.swing.JButton();

        javax.swing.GroupLayout panelFormLayout = new javax.swing.GroupLayout(panelForm);
        panelForm.setLayout(panelFormLayout);
        panelFormLayout.setHorizontalGroup(
            panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 747, Short.MAX_VALUE)
        );
        panelFormLayout.setVerticalGroup(
            panelFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 336, Short.MAX_VALUE)
        );

        panelButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        org.openide.awt.Mnemonics.setLocalizedText(buttonReset, org.openide.util.NbBundle.getMessage(OperationTopComponent.class, "OperationTopComponent.buttonReset.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(buttonEdit, org.openide.util.NbBundle.getMessage(OperationTopComponent.class, "OperationTopComponent.buttonEdit.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(buttonSave, org.openide.util.NbBundle.getMessage(OperationTopComponent.class, "OperationTopComponent.buttonSave.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(buttonExit, org.openide.util.NbBundle.getMessage(OperationTopComponent.class, "OperationTopComponent.buttonExit.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(buttonHelp, org.openide.util.NbBundle.getMessage(OperationTopComponent.class, "OperationTopComponent.buttonHelp.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(buttonSaveDS, org.openide.util.NbBundle.getMessage(OperationTopComponent.class, "OperationTopComponent.buttonSaveDS.text")); // NOI18N

        javax.swing.GroupLayout panelButtonLayout = new javax.swing.GroupLayout(panelButton);
        panelButton.setLayout(panelButtonLayout);
        panelButtonLayout.setHorizontalGroup(
            panelButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonReset, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonSave, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonSaveDS)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonExit, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonHelp, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(107, Short.MAX_VALUE))
        );
        panelButtonLayout.setVerticalGroup(
            panelButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonReset)
                    .addComponent(buttonEdit)
                    .addComponent(buttonSave)
                    .addComponent(buttonExit)
                    .addComponent(buttonHelp)
                    .addComponent(buttonSaveDS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(panelForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonEdit;
    private javax.swing.JButton buttonExit;
    private javax.swing.JButton buttonHelp;
    private javax.swing.JButton buttonReset;
    private javax.swing.JButton buttonSave;
    private javax.swing.JButton buttonSaveDS;
    private javax.swing.JPanel panelButton;
    private javax.swing.JPanel panelForm;
    // End of variables declaration//GEN-END:variables

    @Override
    public void componentOpened() {
        if (operationPanel == null) {
            operationPanel = new OperationPanel();
        }
        panelForm.setLayout(new GridLayout());
        panelForm.add(operationPanel);
        if (obs.isEmpty()) {
            addObserver();
        }
    }

    public void setOperationPanel(OperationPanel operationPanel) {
        this.operationPanel = operationPanel;
    }

    @Override
    public void componentClosed() {
        reset();
        panelForm.removeAll();
        obs.removeAllElements();
    }

    void writeProperties(java.util.Properties p) {
        // better to version settings since initial version as advocated at
        // http://wiki.apidesign.org/wiki/PropertyFiles
        p.setProperty("version", "1.0");
        // TODO store your settings
    }

    void readProperties(java.util.Properties p) {
        String version = p.getProperty("version");
        // TODO read your settings according to their version
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        if (button == buttonSaveDS) {
            update();
            buttonEdit.setEnabled(false);
            operationPanel.getTableO().setEnabled(true);

        }
        if (button == buttonExit) {
            this.close();
        }
        if (button == buttonSave) {
            save();
            buttonEdit.setEnabled(false);
            operationPanel.getTableO().setEnabled(true);
        }
        if (button == buttonReset) {
            reset();
            buttonEdit.setEnabled(false);
            operationPanel.getTableO().setEnabled(true);
        }
        if (button == buttonEdit) {
            buttonEdit.setEnabled(false);
            operationPanel.getTableO().setEnabled(true);
        }
    }

    // reset lại table mỗi khi save hoặc muốn điền mới
    public void reset() {
        operationPanel.getTableO().setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                    {"Tên nghiệp vụ", " "},
                    {"Mã nghiệp vụ", " "},
                    {"Ngày tháng năm", " "},
                    {"Sản phảm dịch vụ", " "},
                    {"Công ty", " "},
                    {"Bộ phận (Phòng)", " "},
                    {"Người chịu trách nhiệm", " "},
                    {"Phân loại", " "},
                    {"Số lượng", "0"},
                    {"Đơn giá", "0"},
                    {"Tổng giá", "0"},
                    {"Đơn vị tính", " "},
                    {"Đơn vị đo", " "}
                },
                new String[]{
                    "", ""
                }) {

            boolean[] canEdit = new boolean[]{
                false, true
            };

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        operationPanel.getTableO().getColumnModel().getColumn(1).setCellEditor(new OperationCell());

    }

    public void save() {
        Operation bean = null;
        String id = operationPanel.getTableO().getValueAt(1, 1).toString().trim();
        String name = operationPanel.getTableO().getValueAt(0, 1).toString().trim();
        String day = operationPanel.getTableO().getValueAt(2, 1).toString().trim();
        String spdv;
        String cty;
        String bophan;
        String person;
        String phanloai = operationPanel.getTableO().getValueAt(7, 1).toString().trim();
        String soluong = operationPanel.getTableO().getValueAt(8, 1).toString().trim();
        String dongia = operationPanel.getTableO().getValueAt(9, 1).toString().trim();
        String tonggia = operationPanel.getTableO().getValueAt(10, 1).toString().trim();
        String dvtinh = operationPanel.getTableO().getValueAt(11, 1).toString().trim();
        String dvdo = operationPanel.getTableO().getValueAt(12, 1).toString().trim();
        // Lấy mã và lưu Enterprise xuống csdl
        if (operationPanel.getTableO().getValueAt(4, 1) != null) {
            if (operationPanel.getTableO().getValueAt(4, 1).toString().trim().length() != 0) {
                Enterprise enterprise = (Enterprise) operationPanel.getTableO().getValueAt(4, 1);
                cty = enterprise.getEnterpriseID().trim();
            } else {
                cty = operationPanel.getTableO().getValueAt(4, 1).toString().trim();
            }
        } else {
            cty = " ";
        }


        // Lấy mã và lưu Product xuống csdl
        if (operationPanel.getTableO().getValueAt(3, 1) != null) {
            if (operationPanel.getTableO().getValueAt(3, 1).toString().trim().length() != 0) {
                Product product = (Product) operationPanel.getTableO().getValueAt(3, 1);
                spdv = product.getProductID().trim();
            } else {
                spdv = operationPanel.getTableO().getValueAt(3, 1).toString().trim();
            }
        } else {
            spdv = " ";
        }


        // Lấy mã và lưu Department xuống csdl
        if (operationPanel.getTableO().getValueAt(5, 1) != null) {
            if (operationPanel.getTableO().getValueAt(5, 1).toString().trim().length() != 0) {
                Department department = (Department) operationPanel.getTableO().getValueAt(5, 1);
                bophan = department.getDepartmentID();
            } else {
                bophan = operationPanel.getTableO().getValueAt(5, 1).toString().trim();
            }
        } else {
            bophan = " ";
        }


        // lấy và lưu mã Person xuống csdl 
        if (operationPanel.getTableO().getValueAt(6, 1) != null) {
            if (operationPanel.getTableO().getValueAt(6, 1).toString().trim().length() != 0) {
                Person person1 = (Person) operationPanel.getTableO().getValueAt(6, 1);
                person = person1.getPersonID();
            } else {
                person = operationPanel.getTableO().getValueAt(6, 1).toString().trim();
            }

        } else {
            person = " ";
        }


        bean = new Operation(id, name, day, spdv, cty, bophan, person, phanloai, Integer.parseInt(soluong),
                Integer.parseInt(dongia), Integer.parseInt(tonggia), dvtinh, dvdo);

        if (operationPanel.getTableO().getValueAt(0, 1).toString().trim().length() != 0
                && operationPanel.getTableO().getValueAt(1, 1).toString().trim().length() != 0) {
            operationBN.updateOperation(bean);
            this.setChanged();
            this.notifyObservers(null);
            this.close();
            this.open();

        } else {
            JOptionPane.showMessageDialog(null, "Bạn chưa nhập mã hoặc tên");
        }

    }

    public void update() {
        Operation bean = null;

        String id = operationPanel.getTableO().getValueAt(1, 1).toString().trim();
        String name = operationPanel.getTableO().getValueAt(0, 1).toString().trim();
        String day = operationPanel.getTableO().getValueAt(2, 1).toString().trim();
        String spdv;
        String cty;
        String bophan;
        String person;
        String phanloai = operationPanel.getTableO().getValueAt(7, 1).toString().trim();
        String soluong = operationPanel.getTableO().getValueAt(8, 1).toString().trim();
        String dongia = operationPanel.getTableO().getValueAt(9, 1).toString().trim();
        String tonggia = operationPanel.getTableO().getValueAt(10, 1).toString().trim();
        String dvtinh = operationPanel.getTableO().getValueAt(11, 1).toString().trim();
        String dvdo = operationPanel.getTableO().getValueAt(12, 1).toString().trim();

        // Lấy mã và lưu Enterprise xuống csdl
        if (operationPanel.getTableO().getValueAt(4, 1) != null) {
            if (operationPanel.getTableO().getValueAt(4, 1).toString().trim().length() != 0) {
                Enterprise enterprise = (Enterprise) operationPanel.getTableO().getValueAt(4, 1);
                cty = enterprise.getEnterpriseID().trim();
            } else {
                cty = operationPanel.getTableO().getValueAt(4, 1).toString().trim();
            }
        } else {
            cty = " ";
        }


        // Lấy mã và lưu Product xuống csdl
        if (operationPanel.getTableO().getValueAt(3, 1) != null) {
            if (operationPanel.getTableO().getValueAt(3, 1).toString().trim().length() != 0) {
                Product product = (Product) operationPanel.getTableO().getValueAt(3, 1);
                spdv = product.getProductID().trim();
            } else {
                spdv = operationPanel.getTableO().getValueAt(3, 1).toString().trim();
            }
        } else {
            spdv = " ";
        }


        // Lấy mã và lưu Department xuống csdl
        if (operationPanel.getTableO().getValueAt(5, 1) != null) {
            if (operationPanel.getTableO().getValueAt(5, 1).toString().trim().length() != 0) {
                Department department = (Department) operationPanel.getTableO().getValueAt(5, 1);
                bophan = department.getDepartmentID();
            } else {
                bophan = operationPanel.getTableO().getValueAt(5, 1).toString().trim();
            }
        } else {
            bophan = " ";
        }


        // lấy và lưu mã Person xuống csdl 
        if (operationPanel.getTableO().getValueAt(6, 1) != null) {
            if (operationPanel.getTableO().getValueAt(6, 1).toString().trim().length() != 0) {
                Person person1 = (Person) operationPanel.getTableO().getValueAt(6, 1);
                person = person1.getPersonID();
            } else {
                person = operationPanel.getTableO().getValueAt(6, 1).toString().trim();
            }

        } else {
            person = " ";
        }


        bean = new Operation(id, name, day, spdv, cty, bophan, person, phanloai, Integer.parseInt(soluong),
                Integer.parseInt(dongia), Integer.parseInt(tonggia), dvtinh, dvdo);

        if (operationPanel.getTableO().getValueAt(0, 1).toString().trim().length() != 0
                && operationPanel.getTableO().getValueAt(1, 1).toString().trim().length() != 0) {
            operationBN.updateOperation(bean);
            this.setChanged();
            this.notifyObservers(null);
            this.close();
            ListOperationTopComponent tc5 = (ListOperationTopComponent) WindowManager.getDefault().findTopComponent("ListOperationTopComponent");
            if (tc5 != null) {
                tc5.open();
                tc5.loadData();
                tc5.requestActive();
            }

        } else {
            JOptionPane.showMessageDialog(null, "Bạn chưa nhập mã hoặc tên");
        }
    }

    @Override
    public void resetCookie() throws IOException {
        OperationTopComponent tc1 = (OperationTopComponent) WindowManager.getDefault().findTopComponent("OperationTopComponent");
        if (tc1 != null) {
            tc1.reset();
        }
    }

    @Override
    public void updateObserver(Observable o, Object arg) {
        reset();
    }

    @Override
    public void notifyObservers(Object arg) {
        Object[] arrLocal;
        synchronized (this) {
            if (!change) {
                return;
            }
            arrLocal = obs.toArray();
            clearChanged();
        }
        for (int i = arrLocal.length - 1; i >= 0; i--) {
            ((Observer) arrLocal[i]).updateObserver(this, arg);
        }

    }

    @Override
    public void setChanged() {
        change = true;
    }

    @Override
    public void clearChanged() {
        change = false;
    }

    public void addObserver() {
        ProductTopComponent tc = (ProductTopComponent) WindowManager.getDefault().findTopComponent("ProductTopComponent");
        if (tc != null) {
            obs.addElement(tc);
        }

        DepartmentTopComponent tc2 = (DepartmentTopComponent) WindowManager.getDefault().findTopComponent("DepartmentTopComponent");
        if (tc2 != null) {
            obs.addElement(tc2);
        }
        PersonTopComponent tc3 = (PersonTopComponent) WindowManager.getDefault().findTopComponent("PersonTopComponent");
        if (tc3 != null) {
            obs.addElement(tc3);
        }
        EnterpriseTopComponent tc4 = (EnterpriseTopComponent) WindowManager.getDefault().findTopComponent("EnterpriseTopComponent");
        if (tc4 != null) {
            obs.addElement(tc4);
        }
    }
}
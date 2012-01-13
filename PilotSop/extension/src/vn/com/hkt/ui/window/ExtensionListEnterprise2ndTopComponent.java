/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.ui.window;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.openide.util.Lookup;
import org.openide.util.LookupEvent;
import org.openide.util.NbBundle;
import org.openide.windows.TopComponent;
import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.cookies.ViewCookie;
import org.openide.util.LookupListener;
import org.openide.util.lookup.AbstractLookup;
import org.openide.util.lookup.InstanceContent;
import org.openide.util.lookup.ServiceProvider;
import org.openide.windows.WindowManager;
import vn.com.hkt.basic.api.IEnterpriseBN;
import vn.com.hkt.basic.api.IPersonBN;
import vn.com.hkt.enterprise.ext.dao.EnterpriseExtBN;
import vn.com.hkt.enterprise.ext.entity.EnterpriseExt;
import vn.com.hkt.pilot.entities.Enterprise;
import vn.com.hkt.pilot.ui.setup.StripedTableCellRenderer;
import vn.com.hkt.pilot.enterprise.viewer.api.FilterCookie;
import vn.com.hkt.pilot.enterprise.viewer.api.IEnterpriseExtViewer;
import vn.com.hkt.pilot.enterprise.viewer.api.RemoveCookie;
import vn.com.hkt.pilot.entities.Person;
import vn.com.hkt.ui.panel.ExtensionListEnterprisePanel2nd;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(dtd = "-//vn.com.hkt.ui.window//ExtensionListEnterprise2nd//EN",
autostore = false)
@TopComponent.Description(preferredID = "ExtensionListEnterprise2ndTopComponent",
//iconBase="SET/PATH/TO/ICON/HERE", 
persistenceType = TopComponent.PERSISTENCE_ALWAYS)
@TopComponent.Registration(mode = "editor", openAtStartup = false)
@ActionID(category = "Window", id = "vn.com.hkt.ui.window.ExtensionListEnterprise2ndTopComponent")
@ActionReference(path = "Menu/Window" /*, position = 333 */)
@TopComponent.OpenActionRegistration(displayName = "#CTL_ExtensionListEnterprise2ndAction",
preferredID = "ExtensionListEnterprise2ndTopComponent")
@ServiceProvider(service = IEnterpriseExtViewer.class)
public final class ExtensionListEnterprise2ndTopComponent extends TopComponent implements IEnterpriseExtViewer, ViewCookie, RemoveCookie,
        LookupListener, FilterCookie, MouseListener {

    private static double LEVEL = 0.0;
    private ExtensionListEnterprisePanel2nd listEnterprisePanel;
    private DefaultTableModel model;
    private IEnterpriseBN enterdao;
    private EnterpriseExtBN enterpriseExtdao;
    private InstanceContent contentforbasic = new InstanceContent();
    private AbstractLookup lookupforbasic;
    private Lookup.Result<Enterprise> resultforbasic = null;
    //private InstanceContent contentforext = new InstanceContent();
    private AbstractLookup lookupforext;
    //private Lookup.Result<Enterprise> resultforext = null;
    //private IEnterpriseViewer enterpriseViewer;
    private String idEnterprise;
     private IPersonBN personBN;

    public ExtensionListEnterprise2ndTopComponent() {
        initComponents();
        setName(NbBundle.getMessage(ExtensionListEnterprise2ndTopComponent.class, "CTL_ExtensionListEnterprise2ndTopComponent"));
        setToolTipText(NbBundle.getMessage(ExtensionListEnterprise2ndTopComponent.class, "HINT_ExtensionListEnterprise2ndTopComponent"));

        enterdao = Lookup.getDefault().lookup(IEnterpriseBN.class);
        enterpriseExtdao = new EnterpriseExtBN();
        listEnterprisePanel = new ExtensionListEnterprisePanel2nd();
        listEnterprisePanel.getTblEnterpriseExt().addMouseListener(this);
        lookupforbasic = new AbstractLookup(contentforbasic);
        // lookupforext = new AbstractLookup(contentforext);
        this.personBN = Lookup.getDefault().lookup(IPersonBN.class);

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    @Override
    public void componentOpened() {
        // TODO add custom code on component opening
    }

    @Override
    public void componentClosed() {
        // TODO add custom code on component closing
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
    public JPanel getEnterpriseExtViewer() {
        return listEnterprisePanel;
    }

    @Override
    public Lookup getEnterpriseExtLookup() {
        return lookupforext;
    }

    @Override
    public void remove() throws IOException {
        JTable table = listEnterprisePanel.getTblEnterpriseExt();
        int row = table.getSelectedRow();
        if (row >= 0) {
            String id = table.getValueAt(row, 1).toString();
            String name = table.getValueAt(row, 0).toString();
            String director = table.getValueAt(row, 3).toString();
            String parent = table.getValueAt(row, 2).toString();
            String logo = table.getValueAt(row, 4).toString();
            String slogan = table.getValueAt(row, 5).toString();
            Enterprise enterprise = new Enterprise(id, name, parent, director, logo, slogan);
            if (enterdao.deleteEnterprise(enterprise)) {
                EnterpriseExt enterpriseExt = enterpriseExtdao.getEnterpriseExtByID(enterprise.getEnterpriseID());
                if (enterpriseExt != null) {
                    if (enterpriseExtdao.deleteEnterpriseExt(enterpriseExt)) {
                        // JOptionPane.showMessageDialog(null, "Extension Deleted!");
                    }
                    //JOptionPane.showMessageDialog(null, "Base Deleted!");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Error!");
            }
        }
    }

    @Override
    public void resultChanged(LookupEvent le) {
        resultforbasic = (Lookup.Result) le.getSource();
        Collection<? extends Enterprise> allEnterprise = resultforbasic.allInstances();
        if (allEnterprise != null) {
            for (Enterprise bean : allEnterprise) {
                idEnterprise = bean.getEnterpriseID();
            }
        }
    }

    @Override
    public String toString() {
        return "Extension 2";
    }

    @Override
    public Lookup getEnterpriseLookup() {
        return lookupforbasic;
    }

    protected void loadData() {
        String[] header = {"Tên Cty", "Mã Cty", "Cty Mẹ", "Giám Đốc", "Logo", "Slogan",
            "Địa chỉ", "Tell", "Fax", "Email", "Web"};
        model = new DefaultTableModel(header, 0);
        List<Enterprise> list1 = enterdao.getAllEnterprise();
        List<EnterpriseExt> list2 = new ArrayList<EnterpriseExt>();
        list2 = enterpriseExtdao.getAllEnterpriseExt();

        int n = list1.size();
        int m = list2.size();
        int i, j;
        int flag = -1;
        for (i = 0; i < n; i++) {
            Enterprise enterprise = list1.get(i);
            for (j = 0; j < m; j++) {
                if (list1.get(i).getEnterpriseID().equals(list2.get(j).getEnterpriseID())) {
                    flag = j;
                }
            }

            if (flag != -1) {
                EnterpriseExt bean = list2.get(flag);
                Enterprise enterprise1 = enterdao.getEnterpriseByID(enterprise.getEnterpriseParent());  // Lấy ra 1 Enterprise theo mã
                Person person1 = personBN.getPersonByID(enterprise.getDirector());
                Object[] rows = {enterprise.getEnterpriseName(), enterprise.getEnterpriseID(), enterprise1, person1,
                    enterprise.getLogo(), enterprise.getSlogan(), bean.getEnterpriseAddress(), bean.getEnterpriseTel(), bean.getEnterpriseFax(),
                    bean.getEnterpriseEmail(), bean.getEnterpriseWeb()};
                model.addRow(rows);
                flag = -1;
            } else {
                Enterprise enterprise1 = enterdao.getEnterpriseByID(enterprise.getEnterpriseParent());  // Lấy ra 1 Enterprise theo mã
                Person person1 = personBN.getPersonByID(enterprise.getDirector());
                Object[] rows = {enterprise.getEnterpriseName(), enterprise.getEnterpriseID(), enterprise1, person1,
                    "", "", "", "", "", "", ""};
                model.addRow(rows);
            }
        }
        listEnterprisePanel.getTblEnterpriseExt().setModel(model);
        setupTable();
    }

    @Override
    public void filterID(String tk) throws IOException {
        String[] header = {"Tên Cty", "Mã Cty", "Cty Mẹ", "Giám Đốc", "Logo", "Slogan",
            "Địa chỉ", "Tell", "Fax", "Email", "Web"};
        model = new DefaultTableModel(header, 0);
        List<Enterprise> list1 = enterdao.filterEnterpriseByID(tk);
        List<EnterpriseExt> list2 = new ArrayList<EnterpriseExt>();
        list2 = enterpriseExtdao.filterEnterpriseExtByID(tk);

        int n = list1.size();
        int m = list2.size();
        int i, j;
        int flag;
        for (i = 0; i < n; i++) {
            flag = -1;
            Enterprise enterprise = list1.get(i);
            for (j = 0; j < m; j++) {
                if (list1.get(i).getEnterpriseID().equals(list2.get(j).getEnterpriseID())) {
                    flag = j;
                }
            }

            if (flag != -1) {
                EnterpriseExt bean = list2.get(flag);
                Enterprise enterprise1 = enterdao.getEnterpriseByID(enterprise.getEnterpriseParent());  // Lấy ra 1 Enterprise theo mã
                Person person1 = personBN.getPersonByID(enterprise.getDirector());
                Object[] rows = {enterprise.getEnterpriseName(), enterprise.getEnterpriseID(), enterprise1, person1,
                    enterprise.getLogo(), enterprise.getSlogan(), bean.getEnterpriseAddress(), bean.getEnterpriseTel(), bean.getEnterpriseFax(),
                    bean.getEnterpriseEmail(), bean.getEnterpriseWeb()};
                model.addRow(rows);
                //flag = -1;
            } else {
               Enterprise enterprise1 = enterdao.getEnterpriseByID(enterprise.getEnterpriseParent());  // Lấy ra 1 Enterprise theo mã
                Person person1 = personBN.getPersonByID(enterprise.getDirector());
                Object[] rows = {enterprise.getEnterpriseName(), enterprise.getEnterpriseID(), enterprise1, person1,
                    "", "", "", "", "", "", ""};
                model.addRow(rows);
            }
        }
        listEnterprisePanel.getTblEnterpriseExt().setModel(model);
        setupTable();
    }

    @Override
    public void filterName(String tk) throws IOException {
        String[] header = {"Tên Cty", "Mã Cty", "Cty Mẹ", "Giám Đốc", "Logo", "Slogan",
            "Địa chỉ", "Tell", "Fax", "Email", "Web"};
        model = new DefaultTableModel(header, 0);
        List<Enterprise> list1 = enterdao.filterEnterpriseByName(tk);
        List<EnterpriseExt> list2 = new ArrayList<EnterpriseExt>();
        list2 = enterpriseExtdao.filterEnterpriseExtByName(tk);

        int n = list1.size();
        int m = list2.size();
        int i, j;
        int flag;
        for (i = 0; i < n; i++) {
            flag = -1;
            Enterprise enterprise = list1.get(i);
            for (j = 0; j < m; j++) {
                if (list1.get(i).getEnterpriseID().equals(list2.get(j).getEnterpriseID())) {
                    flag = j;
                }
            }

            if (flag != -1) {
                EnterpriseExt bean = list2.get(flag);
                Enterprise enterprise1 = enterdao.getEnterpriseByID(enterprise.getEnterpriseParent());  // Lấy ra 1 Enterprise theo mã
                Person person1 = personBN.getPersonByID(enterprise.getDirector());
                Object[] rows = {enterprise.getEnterpriseName(), enterprise.getEnterpriseID(), enterprise1, person1,
                    enterprise.getLogo(), enterprise.getSlogan(), bean.getEnterpriseAddress(), bean.getEnterpriseTel(), bean.getEnterpriseFax(),
                    bean.getEnterpriseEmail(), bean.getEnterpriseWeb()};
                model.addRow(rows);
                //flag = -1;
            } else {
               Enterprise enterprise1 = enterdao.getEnterpriseByID(enterprise.getEnterpriseParent());  // Lấy ra 1 Enterprise theo mã
                Person person1 = personBN.getPersonByID(enterprise.getDirector());
                Object[] rows = {enterprise.getEnterpriseName(), enterprise.getEnterpriseID(), enterprise1, person1,
                    "", "", "", "", "", "", ""};
                model.addRow(rows);
            }
        }
        listEnterprisePanel.getTblEnterpriseExt().setModel(model);
        setupTable();
    }

    @Override
    public void view() {
        loadData();
    }

    // Xử lý click đúp lấy dữ liệu từ list sang form nhap
    public void mouseEvent(MouseEvent e) {
        int i = listEnterprisePanel.getTblEnterpriseExt().getSelectedRow();
        if (e.getClickCount() == 2) {
            if (i >= 0) {
                TopComponent topCreat = WindowManager.getDefault().findTopComponent("EnterpriseCreatorTopComponent");
                if (topCreat != null) {
                    topCreat.open();
                }

                TopComponent topView = WindowManager.getDefault().findTopComponent("EnterpriseViewerTopComponent");
                if (topView != null) {
                    if (topView.isOpened()) {
                        topView.close();
                    }
                }

                String strRow = listEnterprisePanel.getTblEnterpriseExt().getValueAt(i, 1).toString().trim();
                Enterprise enterprise = enterdao.getEnterpriseByID(strRow);
                // JOptionPane.showMessageDialog(null, enterprise.getEnterpriseName());
                contentforbasic.set(Collections.singleton(enterprise), null);
                topView.requestActive();
            }

        }
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

    protected void setupTable() {
        StripedTableCellRenderer.installInColumn(listEnterprisePanel.getTblEnterpriseExt(), new Color(250, 251, 252), null, new Color(242, 242, 242), null);
    }

    @Override
    public double getLevelNumber() {
        return this.LEVEL;
    }
}

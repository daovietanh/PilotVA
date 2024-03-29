/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.authorization.gui;

import com.vn.hkt.core.Permission;
import com.vn.hkt.core.Window;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListModel;
import org.openide.util.NbBundle;
import org.openide.windows.TopComponent;
import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.util.Lookup;
import vn.com.hkt.authorization.api.IAuthorization;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(dtd = "-//vn.com.hkt.authorization.gui//MangeUser//EN",
autostore = false)
@TopComponent.Description(preferredID = "MangeUserTopComponent",
//iconBase="SET/PATH/TO/ICON/HERE", 
persistenceType = TopComponent.PERSISTENCE_ALWAYS)
@TopComponent.Registration(mode = "editor", openAtStartup = false)
@ActionID(category = "Window", id = "vn.com.hkt.authorization.gui.MangeUserTopComponent")
@ActionReference(path = "Menu/Users" /*, position = 333 */)
@TopComponent.OpenActionRegistration(displayName = "#CTL_MangeUserAction",
preferredID = "MangeUserTopComponent")
public final class ManageUserTopComponent extends TopComponent {

    Vector header;
    Vector data;
    private IAuthorization authorization;
    DefaultListModel modelLock, modelView, modelUpdate;
    int findUserID, getFromListNo;
    Window w;

    public ManageUserTopComponent() {
        initComponents();
        w = new Window();
        setName(NbBundle.getMessage(ManageUserTopComponent.class, "CTL_MangeUserTopComponent"));
        setToolTipText(NbBundle.getMessage(ManageUserTopComponent.class, "HINT_MangeUserTopComponent"));
        this.authorization = Lookup.getDefault().lookup(IAuthorization.class);
        select();
    }

    private void select() {
        header = new Vector();
        header.addElement("UserID");
        header.addElement("User Name");
        header.addElement("Password");
        header.addElement("PersonID");
        header.addElement("GroupID");
        data = authorization.loadUsers();
        JTable tb = new JTable(data, header);
        this.tblUsers.setModel(tb.getModel());
    }

    private void loadToLockList() {
        List<Permission> list = authorization.getLockWindowByUserID(findUserID);
        modelLock = new DefaultListModel();
        for (Permission p : list) {
            w = authorization.getWindowNameByID(p.getWindowID());
            modelLock.addElement(w.getWindowName());
        }
        lstLock.setModel(modelLock);
    }

    private void loadToViewList() {
        List<Permission> list = authorization.getViewWindowByUserID(findUserID);
        modelView = new DefaultListModel();
        for (Permission p : list) {
            w = authorization.getWindowNameByID(p.getWindowID());
            modelView.addElement(w.getWindowName());
        }
        lstView.setModel(modelView);
    }

    private void loadToUpdateList() {
        List<Permission> list = authorization.getUpdateWindowByUserID(findUserID);
        modelUpdate = new DefaultListModel();
        for (Permission p : list) {
            w = authorization.getWindowNameByID(p.getWindowID());
            modelUpdate.addElement(w.getWindowName());
        }
        lstUpdate.setModel(modelUpdate);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlGeneral = new javax.swing.JPanel();
        tpnManageUser = new javax.swing.JTabbedPane();
        pnlUsers = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsers = new javax.swing.JTable();
        btnRefresh = new javax.swing.JButton();
        btnCreateAccount = new javax.swing.JButton();
        pnlAuthorization = new javax.swing.JPanel();
        pnlUpdate = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstUpdate = new javax.swing.JList();
        pnlView = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstView = new javax.swing.JList();
        pnlLock = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        lstLock = new javax.swing.JList();
        btnUpdate = new javax.swing.JButton();
        btnView = new javax.swing.JButton();
        btnLock = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();

        tblUsers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblUsers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUsersMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblUsers);
        tblUsers.getColumnModel().getColumn(0).setHeaderValue(org.openide.util.NbBundle.getMessage(ManageUserTopComponent.class, "ManageUserTopComponent.tblUsers.columnModel.title0")); // NOI18N
        tblUsers.getColumnModel().getColumn(1).setHeaderValue(org.openide.util.NbBundle.getMessage(ManageUserTopComponent.class, "ManageUserTopComponent.tblUsers.columnModel.title1")); // NOI18N
        tblUsers.getColumnModel().getColumn(2).setHeaderValue(org.openide.util.NbBundle.getMessage(ManageUserTopComponent.class, "ManageUserTopComponent.tblUsers.columnModel.title2")); // NOI18N
        tblUsers.getColumnModel().getColumn(3).setHeaderValue(org.openide.util.NbBundle.getMessage(ManageUserTopComponent.class, "ManageUserTopComponent.tblUsers.columnModel.title3")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(btnRefresh, org.openide.util.NbBundle.getMessage(ManageUserTopComponent.class, "ManageUserTopComponent.btnRefresh.text")); // NOI18N
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(btnCreateAccount, org.openide.util.NbBundle.getMessage(ManageUserTopComponent.class, "ManageUserTopComponent.btnCreateAccount.text")); // NOI18N
        btnCreateAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateAccountActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlUsersLayout = new javax.swing.GroupLayout(pnlUsers);
        pnlUsers.setLayout(pnlUsersLayout);
        pnlUsersLayout.setHorizontalGroup(
            pnlUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUsersLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
                    .addGroup(pnlUsersLayout.createSequentialGroup()
                        .addComponent(btnRefresh)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCreateAccount)))
                .addContainerGap())
        );
        pnlUsersLayout.setVerticalGroup(
            pnlUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUsersLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRefresh)
                    .addComponent(btnCreateAccount))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        tpnManageUser.addTab(org.openide.util.NbBundle.getMessage(ManageUserTopComponent.class, "ManageUserTopComponent.pnlUsers.TabConstraints.tabTitle"), pnlUsers); // NOI18N

        pnlUpdate.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(ManageUserTopComponent.class, "ManageUserTopComponent.pnlUpdate.border.title"))); // NOI18N

        lstUpdate.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        lstUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstUpdateMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(lstUpdate);

        javax.swing.GroupLayout pnlUpdateLayout = new javax.swing.GroupLayout(pnlUpdate);
        pnlUpdate.setLayout(pnlUpdateLayout);
        pnlUpdateLayout.setHorizontalGroup(
            pnlUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUpdateLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlUpdateLayout.setVerticalGroup(
            pnlUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pnlView.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(ManageUserTopComponent.class, "ManageUserTopComponent.pnlView.border.title"))); // NOI18N

        lstView.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        lstView.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstViewMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(lstView);

        javax.swing.GroupLayout pnlViewLayout = new javax.swing.GroupLayout(pnlView);
        pnlView.setLayout(pnlViewLayout);
        pnlViewLayout.setHorizontalGroup(
            pnlViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlViewLayout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlViewLayout.setVerticalGroup(
            pnlViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pnlLock.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(ManageUserTopComponent.class, "ManageUserTopComponent.pnlLock.border.title"))); // NOI18N

        lstLock.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        lstLock.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstLockMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(lstLock);

        javax.swing.GroupLayout pnlLockLayout = new javax.swing.GroupLayout(pnlLock);
        pnlLock.setLayout(pnlLockLayout);
        pnlLockLayout.setHorizontalGroup(
            pnlLockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLockLayout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlLockLayout.setVerticalGroup(
            pnlLockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        org.openide.awt.Mnemonics.setLocalizedText(btnUpdate, org.openide.util.NbBundle.getMessage(ManageUserTopComponent.class, "ManageUserTopComponent.btnUpdate.text")); // NOI18N
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(btnView, org.openide.util.NbBundle.getMessage(ManageUserTopComponent.class, "ManageUserTopComponent.btnView.text")); // NOI18N
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(btnLock, org.openide.util.NbBundle.getMessage(ManageUserTopComponent.class, "ManageUserTopComponent.btnLock.text")); // NOI18N
        btnLock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLockActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(btnSave, org.openide.util.NbBundle.getMessage(ManageUserTopComponent.class, "ManageUserTopComponent.btnSave.text")); // NOI18N
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(btnCancel, org.openide.util.NbBundle.getMessage(ManageUserTopComponent.class, "MangeUserTopComponent.btnCancel.text")); // NOI18N
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 18));
        org.openide.awt.Mnemonics.setLocalizedText(lblTitle, org.openide.util.NbBundle.getMessage(ManageUserTopComponent.class, "ManageUserTopComponent.lblTitle.text")); // NOI18N

        javax.swing.GroupLayout pnlAuthorizationLayout = new javax.swing.GroupLayout(pnlAuthorization);
        pnlAuthorization.setLayout(pnlAuthorizationLayout);
        pnlAuthorizationLayout.setHorizontalGroup(
            pnlAuthorizationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAuthorizationLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlAuthorizationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlAuthorizationLayout.createSequentialGroup()
                        .addComponent(pnlUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlLock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addGroup(pnlAuthorizationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                            .addComponent(btnLock, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                            .addComponent(btnView, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                            .addComponent(btnCancel, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)))
                    .addComponent(lblTitle))
                .addContainerGap())
        );
        pnlAuthorizationLayout.setVerticalGroup(
            pnlAuthorizationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAuthorizationLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTitle)
                .addGap(18, 18, 18)
                .addGroup(pnlAuthorizationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(pnlAuthorizationLayout.createSequentialGroup()
                        .addComponent(btnUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnView)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLock)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancel))
                    .addComponent(pnlLock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        tpnManageUser.addTab(org.openide.util.NbBundle.getMessage(ManageUserTopComponent.class, "ManageUserTopComponent.pnlAuthorization.TabConstraints.tabTitle"), pnlAuthorization); // NOI18N

        javax.swing.GroupLayout pnlGeneralLayout = new javax.swing.GroupLayout(pnlGeneral);
        pnlGeneral.setLayout(pnlGeneralLayout);
        pnlGeneralLayout.setHorizontalGroup(
            pnlGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlGeneralLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tpnManageUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlGeneralLayout.setVerticalGroup(
            pnlGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGeneralLayout.createSequentialGroup()
                .addComponent(tpnManageUser, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
// TODO add your handling code here:
    select();
}//GEN-LAST:event_btnRefreshActionPerformed

private void tblUsersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUsersMouseClicked
// TODO add your handling code here:
    findUserID = Integer.parseInt(tblUsers.getModel().getValueAt(tblUsers.getSelectedRow(), 0).toString());
    String findUserName = tblUsers.getModel().getValueAt(tblUsers.getSelectedRow(), 1).toString();
    loadToLockList();
    loadToUpdateList();
    loadToViewList();
    lblTitle.setText(findUserName);
    tpnManageUser.setSelectedIndex(1);
}//GEN-LAST:event_tblUsersMouseClicked

private void lstLockMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstLockMouseClicked
// TODO add your handling code here:
    //List Lock đặt là List number 1
    this.getFromListNo = 1;
}//GEN-LAST:event_lstLockMouseClicked

private void btnLockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLockActionPerformed
// TODO add your handling code here:
    //Chuyển từ list View sang list Lock. List View= 2
    if (getFromListNo == 2) {
        modelLock.addElement(lstView.getSelectedValue());
        modelView.removeElement(lstView.getSelectedValue());
    } //Chuyển từ list Update sang list Lock. List Update= 3
    else if (getFromListNo == 3) {
        modelLock.addElement(lstUpdate.getSelectedValue());
        modelUpdate.removeElement(lstUpdate.getSelectedValue());
    }
}//GEN-LAST:event_btnLockActionPerformed

private void lstViewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstViewMouseClicked
// TODO add your handling code here:
    //List View đặt là List number 2
    this.getFromListNo = 2;
}//GEN-LAST:event_lstViewMouseClicked

private void lstUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstUpdateMouseClicked
// TODO add your handling code here:
    //List Update đặt là list number 3
    this.getFromListNo = 3;
}//GEN-LAST:event_lstUpdateMouseClicked

private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
// TODO add your handling code here:
    //Chuyển từ list Lock sang list View. List Lock= 1
    if (getFromListNo == 1) {
        modelView.addElement(lstLock.getSelectedValue());
        modelLock.removeElement(lstLock.getSelectedValue());
    } //Chuyển từ list Update sang list View. List Update= 3
    else if (getFromListNo == 3) {
        modelView.addElement(lstUpdate.getSelectedValue());
        modelUpdate.removeElement(lstUpdate.getSelectedValue());
    }
}//GEN-LAST:event_btnViewActionPerformed

private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
// TODO add your handling code here:
    //Chuyển từ list Lock sang list Update. List Lock=1
    if (getFromListNo == 1) {
        modelUpdate.addElement(lstLock.getSelectedValue());
        modelLock.removeElement(lstLock.getSelectedValue());
    } //Chuyển từ list View sang list Update. List View= 2
    else if (getFromListNo == 2) {
        modelUpdate.addElement(lstView.getSelectedValue());
        modelView.removeElement(lstView.getSelectedValue());
    }
}//GEN-LAST:event_btnUpdateActionPerformed

private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
// TODO add your handling code here:
    ListModel model1 = lstLock.getModel();
    for (int i = 0; i < model1.getSize(); i++) {
        String item = (String) model1.getElementAt(i);
        Window w = new Window();
        w = authorization.getWindowIDByName(item);
        authorization.setPermissionAtLockList(findUserID, w.getWindowID());
    }

    ListModel model2 = lstView.getModel();
    for (int i = 0; i < model2.getSize(); i++) {
        String item = (String) model2.getElementAt(i);
        Window w = new Window();
        w = authorization.getWindowIDByName(item);
        authorization.setPermissionAtViewList(findUserID, w.getWindowID());
    }

    ListModel model3 = lstUpdate.getModel();
    for (int i = 0; i < model3.getSize(); i++) {
        String item = (String) model3.getElementAt(i);
        Window w = new Window();
        w = authorization.getWindowIDByName(item);
        authorization.setPermissionAtUpdateList(findUserID, w.getWindowID());
    }

    JOptionPane.showMessageDialog(null, "Saved!");
}//GEN-LAST:event_btnSaveActionPerformed

private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
// TODO add your handling code here:
    this.close();
}//GEN-LAST:event_btnCancelActionPerformed

private void btnCreateAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateAccountActionPerformed
// TODO add your handling code here:
    CreateAccount account = new CreateAccount();
    account.setVisible(true);
}//GEN-LAST:event_btnCreateAccountActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnCreateAccount;
    private javax.swing.JButton btnLock;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnView;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JList lstLock;
    private javax.swing.JList lstUpdate;
    private javax.swing.JList lstView;
    private javax.swing.JPanel pnlAuthorization;
    private javax.swing.JPanel pnlGeneral;
    private javax.swing.JPanel pnlLock;
    private javax.swing.JPanel pnlUpdate;
    private javax.swing.JPanel pnlUsers;
    private javax.swing.JPanel pnlView;
    private javax.swing.JTable tblUsers;
    private javax.swing.JTabbedPane tpnManageUser;
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
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package installer;

import com.vn.hkt.generic.api.IGenericAPI;
import installerGUI.LoginForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import org.openide.DialogDisplayer;
import org.openide.LifecycleManager;
import org.openide.NotifyDescriptor;
import org.openide.modules.ModuleInstall;
import org.openide.util.Lookup;

public class Installer extends ModuleInstall {

    LoginForm form;
    int tryTime = 3;
    private NotifyDescriptor nd;
    private IGenericAPI iGenericAPI;

    public Installer() {
        this.iGenericAPI = Lookup.getDefault().lookup(IGenericAPI.class);
    }

    @Override
    public void restored() {
        form = new LoginForm();
        JButton login = new JButton("Login");
        JButton cancel = new JButton("Cancel");
        nd = new NotifyDescriptor.Confirmation(form, "User Login");
        nd.setOptions(new Object[]{login, cancel});
        nd.addPropertyChangeListener(new PropertyChangeListener() {

            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                ndPropertyChange(evt);
            }
        });
        DialogDisplayer.getDefault().notifyLater(nd);

        login.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                loginAction(e);
            }
        });

        cancel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                LifecycleManager.getDefault().exit();
            }
        });

    }
//when click login button

    private void loginAction(ActionEvent ae) {
        String user = form.getUserName();
        String pass = form.getPassword();
        if (tryTime == 0) {
            JOptionPane.showMessageDialog(null, "You tried 3 times fail. Application will be close");
            LifecycleManager.getDefault().exit();
        }
        if (user.trim().equals("") && pass.trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter username and password. You have " + --tryTime + " time(s) to try");
            DialogDisplayer.getDefault().notify(nd);
        } else if (user.trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter username. You have " + --tryTime + " time(s) to try");
            DialogDisplayer.getDefault().notify(nd);
        } else if (pass.trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter your password. You have " + --tryTime + " time(s) to try");
            DialogDisplayer.getDefault().notify(nd);
        } else {
//            hardcode
            if (user.equals("admin") && pass.equals("admin")) {
                //JOptionPane.showMessageDialog(null, "Login Successfully");
            } else {
                JOptionPane.showMessageDialog(null, "User or Password incorrect. You have " + --tryTime + " time(s) to try");
                DialogDisplayer.getDefault().notify(nd);
            }
        }
    }

    private void ndPropertyChange(PropertyChangeEvent pce) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                if (nd.getValue().toString().equals("-1")) {
                    LifecycleManager.getDefault().exit();
                }
            }
        });

    }
}

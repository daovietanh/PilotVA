/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.tree.ui.enterprise;

import java.beans.PropertyEditor;
import java.beans.PropertyEditorSupport;
import vn.com.hkt.pilot.entities.Enterprise;
import vn.com.hkt.basic.api.IEnterpriseBN;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;
import org.openide.nodes.Node;
import org.openide.nodes.Node.Property;
import org.openide.nodes.PropertySupport;
import org.openide.nodes.Sheet;
import org.openide.util.Lookup;
import org.openide.util.lookup.Lookups;

/**
 *
 * @author longnt
 */
public class EnterpriseParent extends Children.Keys {

    private List<Enterprise> list = new ArrayList<Enterprise>();
    private IEnterpriseBN enterpriseBN = Lookup.getDefault().lookup(IEnterpriseBN.class);
    public static String Giamdoc_PROPERTY = "GiamDoc";
    public static String Congtyme_PROPERTY = "CongTyMe";
    private Enterprise enterprise;

    public EnterpriseParent(boolean lazy) {
        super(lazy);
    }

    public EnterpriseParent(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    public EnterpriseParent() {

        list = enterpriseBN.getAllEnterprise();

    }

    @Override
    protected Node[] createNodes(Object key) {
        final Enterprise enterprise1 = (Enterprise) key;
        Node result = new AbstractNode(new EnterpriseChildren(enterprise1), Lookups.singleton(enterprise1)) {

            @Override
            protected Sheet createSheet() {
                Sheet sheet = Sheet.createDefault();
                Sheet.Set set = Sheet.createPropertiesSet();

                Property giamDocProperty = new PropertySupport.ReadOnly<String>(Giamdoc_PROPERTY, String.class, "Giám đốc", "aaa") {

                    @Override
                    public String getValue() throws IllegalAccessException, InvocationTargetException {
                        return enterprise1.getDirector();
                    }
                    
                    @Override
                    public PropertyEditor getPropertyEditor() {
                        return new PropertyEditorSupport();
                    }
                };
                set.put(giamDocProperty);
                Property congTyMeProperty =
                        new PropertySupport.ReadOnly<String>(Congtyme_PROPERTY, String.class, "Công Ty mẹ", "bbb") {

                            @Override
                            public String getValue() throws IllegalAccessException, InvocationTargetException {
                                return enterprise1.getEnterpriseParent();
                            }
                            
                    @Override
                    public PropertyEditor getPropertyEditor() {
                        return new PropertyEditorSupport();
                    }
                        };
                set.put(congTyMeProperty);
                sheet.put(set);
                return sheet;
            }
        };
        result.setDisplayName(enterprise1.getEnterpriseName());
        return new Node[]{result};
    }

    @Override
    protected void addNotify() {
        super.addNotify();

        Vector instr = new Vector();
        for (Enterprise bean : list) {
            if (bean.getEnterpriseParent().toString().trim().length() == 0) {
                instr.addElement(bean);
            }
        }

        Enterprise[] enterprises = new Enterprise[instr.size()];
        for (int i = 0; i < instr.size(); i++) {
            enterprises[i] = (Enterprise) instr.elementAt(i);
        }
        setKeys(enterprises);
    }
}

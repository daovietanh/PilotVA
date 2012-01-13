/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.tree.ui.enterprise.thuchi;

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
import org.openide.nodes.PropertySupport;
import org.openide.nodes.Sheet;
import org.openide.util.Lookup;
import org.openide.util.lookup.Lookups;
import vn.com.hkt.finance.spi.CalculateSPI;

/**
 *
 * @author longnt
 */
public class EnterpriseChildren extends Children.Keys {

    private Enterprise enterprise;
    List<Enterprise> list = new ArrayList<Enterprise>();
    private IEnterpriseBN enterpriseBN = Lookup.getDefault().lookup(IEnterpriseBN.class);
    public static String Giamdoc_PROPERTY = "Thu";
    public static String Congtyme_PROPERTY = "Chi";
    private CalculateSPI calculateSPI;

    public EnterpriseChildren(boolean lazy) {
        super(lazy);
    }

    public EnterpriseChildren(Enterprise enterprise) {
        this.enterprise = enterprise;
        list = enterpriseBN.getAllEnterprise();
        calculateSPI = new CalculateSPI();
    }

    @Override
    protected Node[] createNodes(Object key) {

        final Enterprise enterprise1 = (Enterprise) key;
        Node result;
        result = new AbstractNode(new EnterpriseChildren(enterprise1), Lookups.singleton(enterprise1)) {

            @Override
            protected Sheet createSheet() {
                Sheet sheet = Sheet.createDefault();
                Sheet.Set set = Sheet.createPropertiesSet();

                Property giamDocProperty = new PropertySupport.ReadOnly<String>(Giamdoc_PROPERTY, String.class, "Thu", "aaa") {

                    @Override
                    public String getValue() throws IllegalAccessException, InvocationTargetException {
                        return String.valueOf(calculateSPI.calculateSumImportByEnterprise(enterprise1));
                    }

                    @Override
                    public PropertyEditor getPropertyEditor() {
                        return new PropertyEditorSupport();
                    }
                };
                set.put(giamDocProperty);
                Property congTyMeProperty =
                        new PropertySupport.ReadOnly<String>(Congtyme_PROPERTY, String.class, "Chi", "bbb") {

                            @Override
                            public String getValue() throws IllegalAccessException, InvocationTargetException {
                                return String.valueOf(calculateSPI.calculateSumExportByEnterprise(enterprise1));
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
        list = enterpriseBN.getAllEnterprise();
        super.addNotify();
        Vector instr = new Vector();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getEnterpriseParent().equals(enterprise.getEnterpriseName())) {
                Enterprise enterprise1 = new Enterprise();
                enterprise1.setEnterpriseName(list.get(i).getEnterpriseName());
                enterprise1.setDirector(list.get(i).getDirector());
                enterprise1.setEnterpriseParent(list.get(i).getEnterpriseParent());
                instr.addElement(enterprise1);
            }

        }

        Enterprise[] enterprises = new Enterprise[instr.size()];
        for (int i = 0; i < instr.size(); i++) {
            enterprises[i] = (Enterprise) instr.elementAt(i);
        }
        setKeys(enterprises);

    }
}

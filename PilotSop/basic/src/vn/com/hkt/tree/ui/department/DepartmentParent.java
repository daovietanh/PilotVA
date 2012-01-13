/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.tree.ui.department;

import java.beans.PropertyEditor;
import java.beans.PropertyEditorSupport;
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
import vn.com.hkt.basic.api.IDepartmentBN;
import vn.com.hkt.pilot.entities.Department;
import vn.com.hkt.pilot.entities.Enterprise;

/**
 *
 * @author longnt
 */
public class DepartmentParent extends Children.Keys {

    private List<Department> list = new ArrayList<Department>();
    private IDepartmentBN departmentBN = Lookup.getDefault().lookup(IDepartmentBN.class);
    public static String Giamdoc_PROPERTY = "TruongPhong";
    public static String Congtyme_PROPERTY = "CongTy";
    private Enterprise enterprise;

    public DepartmentParent(boolean lazy) {
        super(lazy);
    }

    public DepartmentParent(Enterprise enterprise) {
        this.enterprise = enterprise;

    }

    @Override
    protected Node[] createNodes(Object key) {
        final Department department1 = (Department) key;
        Node result = new AbstractNode(new DepartmentChildren(department1, enterprise), Lookups.singleton(department1)) {

            @Override
            protected Sheet createSheet() {
                Sheet sheet = Sheet.createDefault();
                Sheet.Set set = Sheet.createPropertiesSet();

                Property giamDocProperty = new PropertySupport.ReadOnly<String>(Giamdoc_PROPERTY, String.class, "Trưởng phòng", "aaa") {

                    @Override
                    public String getValue() throws IllegalAccessException, InvocationTargetException {
                        return department1.getPersonID();
                    }

                    @Override
                    public PropertyEditor getPropertyEditor() {
                        return new PropertyEditorSupport();
                    }
                };
                set.put(giamDocProperty);
                Property congTyMeProperty =
                        new PropertySupport.ReadOnly<String>(Congtyme_PROPERTY, String.class, "Công ty", "bbb") {

                            @Override
                            public String getValue() throws IllegalAccessException, InvocationTargetException {
                                return department1.getEnterpriseID();
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
        result.setDisplayName(department1.getDepartmentName());
        return new Node[]{result};
    }

    @Override
    protected void addNotify() {
        super.addNotify();
        if (enterprise != null) {
            list = departmentBN.filterDepartmentByEnterprise(enterprise);
            Vector instr = new Vector();
            for (Department bean : list) {
                if (bean.getDepartmentParent().toString().trim().length() == 0) {
                    instr.addElement(bean);
                }
            }

            Department[] departments = new Department[instr.size()];
            for (int i = 0; i < instr.size(); i++) {
                departments[i] = (Department) instr.elementAt(i);
            }
            setKeys(departments);
        }

    }
}

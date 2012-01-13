/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.tree.ui.department;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;
import org.openide.nodes.PropertySupport;
import org.openide.nodes.Sheet;
import org.openide.util.Lookup;
import vn.com.hkt.pilot.entities.Department;

/**
 *
 * @author longnt
 */
public class DepartmentNode extends AbstractNode {

    public static String Giamdoc_PROPERTY = "TruongPhong";
    public static String Congtyme_PROPERTY = "CongTy";
    private Department department;

    public DepartmentNode(Department department) throws IntrospectionException {
        super(Children.LEAF, Lookup.getDefault());
        this.department = department;
        setDisplayName(department.getDepartmentName());
    }

    @Override
    protected Sheet createSheet() {
        Sheet sheet = Sheet.createDefault();
        Sheet.Set set = Sheet.createPropertiesSet();
         
        Property tweetDateProperty = new PropertySupport.ReadOnly<String>(Giamdoc_PROPERTY, String.class, "Trưởng phòng", "aaa") {

            @Override
            public String getValue() throws IllegalAccessException, InvocationTargetException {
                return department.getPersonID();
            }
        };
        set.put(tweetDateProperty);
        Property tweetAuthorProperty =
                new PropertySupport.ReadOnly<String>(Congtyme_PROPERTY, String.class, "Công ty", "bbb") {

                    @Override
                    public String getValue() throws IllegalAccessException, InvocationTargetException {
                        return department.getEnterpriseID();
                    }
                };
               set.put(tweetAuthorProperty);
        sheet.put(set);
        return sheet;
    }
}

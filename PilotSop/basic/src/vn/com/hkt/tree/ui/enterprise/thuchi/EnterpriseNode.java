/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.tree.ui.enterprise.thuchi;

import vn.com.hkt.pilot.entities.Enterprise;
import java.beans.IntrospectionException;
import java.beans.PropertyEditor;
import java.beans.PropertyEditorSupport;
import java.lang.reflect.InvocationTargetException;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.BeanNode;
import org.openide.nodes.Children;
import org.openide.nodes.PropertySupport;
import org.openide.nodes.Sheet;
import org.openide.util.Exceptions;
import org.openide.util.Lookup;
import vn.com.hkt.finance.spi.CalculateSPI;

/**
 *
 * @author longnt
 */
public class EnterpriseNode extends AbstractNode {

    public static String Giamdoc_PROPERTY = "Thu";
    public static String Congtyme_PROPERTY = "Chi";
    private Enterprise enterprise;
    private CalculateSPI calculateSPI;

    public EnterpriseNode(Enterprise enterprise) throws IntrospectionException {
        super(Children.LEAF, Lookup.getDefault());
        this.enterprise = enterprise;
        setDisplayName(enterprise.getEnterpriseName());
        calculateSPI = new CalculateSPI();
    }

    @Override
    protected Sheet createSheet() {
        Sheet sheet = Sheet.createDefault();
        Sheet.Set set = Sheet.createPropertiesSet();
         
        Property tweetDateProperty = new PropertySupport.ReadOnly<String>(Giamdoc_PROPERTY, String.class, "Thu", "aaa") {

            @Override
            public String getValue() throws IllegalAccessException, InvocationTargetException {
                return String.valueOf(calculateSPI.calculateSumImportByEnterprise(enterprise));
            }
            
                    @Override
                    public PropertyEditor getPropertyEditor() {
                        return new PropertyEditorSupport();
                    }
        };
        set.put(tweetDateProperty);
        Property tweetAuthorProperty =
                new PropertySupport.ReadOnly<String>(Congtyme_PROPERTY, String.class, "Chi", "bbb") {

                    @Override
                    public String getValue() throws IllegalAccessException, InvocationTargetException {
                        return String.valueOf(calculateSPI.calculateSumExportByEnterprise(enterprise));
                    }
                    
                    @Override
                    public PropertyEditor getPropertyEditor() {
                        return new PropertyEditorSupport();
                    }
                };
               set.put(tweetAuthorProperty);
        sheet.put(set);
        return sheet;
    }
}

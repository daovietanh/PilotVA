/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.tree.ui.product;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;
import org.openide.nodes.PropertySupport;
import org.openide.nodes.Sheet;
import org.openide.util.Lookup;
import vn.com.hkt.pilot.entities.Product;

/**
 *
 * @author longnt
 */
public class ProductNode extends AbstractNode {

    public static String Giamdoc_PROPERTY = "TruongPhong";
    public static String Congtyme_PROPERTY = "CongTy";
    private Product product;

    public ProductNode(Product product) throws IntrospectionException {
        super(Children.LEAF, Lookup.getDefault());
        this.product = product;
        setDisplayName(product.getProductName());
    }

    @Override
    protected Sheet createSheet() {
        Sheet sheet = Sheet.createDefault();
        Sheet.Set set = Sheet.createPropertiesSet();
         
        Property tweetDateProperty = new PropertySupport.ReadOnly<String>(Giamdoc_PROPERTY, String.class, "Trưởng phòng", "aaa") {

            @Override
            public String getValue() throws IllegalAccessException, InvocationTargetException {
                return product.getPersonID();
            }
        };
        set.put(tweetDateProperty);
        Property tweetAuthorProperty =
                new PropertySupport.ReadOnly<String>(Congtyme_PROPERTY, String.class, "Công ty", "bbb") {

                    @Override
                    public String getValue() throws IllegalAccessException, InvocationTargetException {
                        return product.getEnterpriseID();
                    }
                };
               set.put(tweetAuthorProperty);
        sheet.put(set);
        return sheet;
    }
}

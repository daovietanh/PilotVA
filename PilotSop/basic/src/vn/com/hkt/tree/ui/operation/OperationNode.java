/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.tree.ui.operation;

import vn.com.hkt.pilot.entities.Operation;
import vn.com.hkt.basic.api.IOperationBN;
import java.beans.IntrospectionException;
import java.beans.PropertyEditor;
import java.beans.PropertyEditorSupport;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;
import org.openide.nodes.PropertySupport;
import org.openide.nodes.Sheet;
import org.openide.util.Lookup;

/**
 *
 * @author longnt
 */
public class OperationNode extends AbstractNode {

    private Operation operation;
    public static String Thu_PROPERTY = "Thu";
    public static String Chi_PROPERTY = "Chi";
    public static String LoiNhuan_PROPERTY = "LoiNhuan";
    private Sheet sheet = Sheet.createDefault();
    private Sheet.Set set = Sheet.createPropertiesSet();
    private Property ThuProperty;
    private Property ChiProperty;
    private IOperationBN operationBN = Lookup.getDefault().lookup(IOperationBN.class);
    private int ln;

    public OperationNode(Operation operation) throws IntrospectionException {
        super(Children.LEAF, Lookup.getDefault());
        this.operation = operation;
        createSheet();
        List<Operation> operation1 = operationBN.filterOperationsByName(operation.getOperationName());
        for (Operation beans : operation1) {
            if (beans.getClassification().equals("Chi")) {
                ln = operation.getSumPrice() * (-1);
                set.put(ChiProperty);
            }
            if (beans.getClassification().equals("Thu")) {
                ln = operation.getSumPrice();
                set.put(ThuProperty);
            }
        }
        sheet.put(set);
    }

    @Override
    protected Sheet createSheet() {

        // Tạo property thu cho Operation
        ThuProperty = new PropertySupport.ReadOnly<String>(Thu_PROPERTY, String.class, "Thu", "aaa") {

            @Override
            public String getValue() throws IllegalAccessException, InvocationTargetException {
                return String.valueOf(operation.getSumPrice());                   // trả về tổng Thu theo ngày
            }

            @Override
            public PropertyEditor getPropertyEditor() {
                return new PropertyEditorSupport();
            }
        };

        // Tạo property chi cho Operation
        ChiProperty = new PropertySupport.ReadOnly<String>(Chi_PROPERTY, String.class, "Chi", "bbb") {

            @Override
            public String getValue() throws IllegalAccessException, InvocationTargetException {

                return String.valueOf(operation.getSumPrice());                  // trả về tổng Chi theo ngày
            }

            @Override
            public PropertyEditor getPropertyEditor() {
                return new PropertyEditorSupport();
            }
        };

        // Tạo property lợi nhuận cho Operation
        Property loiNhuanProperty = new PropertySupport.ReadOnly<String>(LoiNhuan_PROPERTY, String.class, "Lợi nhuận", "bbb") {

            @Override
            public String getValue() throws IllegalAccessException, InvocationTargetException {
                return String.valueOf(ln);           // trả về lợi nhuận theo ngày
            }
             @Override
            public PropertyEditor getPropertyEditor() {
                return new PropertyEditorSupport();
            }
        };

        set.put(loiNhuanProperty);
        return sheet;
    }
}

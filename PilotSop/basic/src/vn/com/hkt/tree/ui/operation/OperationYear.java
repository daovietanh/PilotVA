/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.tree.ui.operation;

import java.beans.PropertyEditor;
import java.beans.PropertyEditorSupport;
import vn.com.hkt.finance.api.ICalculate;
import vn.com.hkt.pilot.entities.Enterprise;
import vn.com.hkt.pilot.entities.Operation;
import vn.com.hkt.basic.api.IOperationBN;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import org.openide.nodes.AbstractNode;
import org.openide.nodes.Children;
import org.openide.nodes.Node;
import org.openide.nodes.PropertySupport;
import org.openide.nodes.Sheet;
import org.openide.util.Lookup;
import org.openide.util.lookup.Lookups;

/**
 *
 * @author longnt
 */
public class OperationYear extends Children.Keys {

    private List<Operation> list;                        // tạo 1 list Operation
    private List<Operation> list1;                                                    // tạo 1 list để chứa các Operation tạo Node
    private IOperationBN operationBN = Lookup.getDefault().lookup(IOperationBN.class);
    private ICalculate calculate = Lookup.getDefault().lookup(ICalculate.class);
    public static String Thu_PROPERTY = "Thu";
    public static String Chi_PROPERTY = "Chi";
    public static String LoiNhuan_PROPERTY = "LoiNhuan";
    private Enterprise enterprise;

    public OperationYear(boolean lazy) {
        super(lazy);
    }

    public OperationYear(Enterprise e) {
        this.enterprise = e;
        addNotify();
    }

    @Override
    protected Node[] createNodes(Object key) {
        final Operation operation1 = (Operation) key;
        Node result = new AbstractNode(new OperationMonth(operation1, enterprise), Lookups.singleton(operation1)) {

            //  Enterprise enterprise = enterpriseBN.getEnterpriseByID("h01");
            @Override
            protected Sheet createSheet() {
                Sheet sheet = Sheet.createDefault();
                Sheet.Set set = Sheet.createPropertiesSet();
                Property thuProperty = new PropertySupport.ReadOnly<String>(Thu_PROPERTY, String.class, "Thu", "aaa") {

                    @Override
                    public String getValue() throws IllegalAccessException, InvocationTargetException {
                        return String.valueOf(calculate.calculateImportByYear(enterprise, operation1.getDateTime()));
                    }
                    
                    @Override
                    public PropertyEditor getPropertyEditor() {
                        return new PropertyEditorSupport();
                    }
                };
                set.put(thuProperty);
                Property chiProperty = new PropertySupport.ReadOnly<String>(Chi_PROPERTY, String.class, "Chi", "bbb") {

                    @Override
                    public String getValue() throws IllegalAccessException, InvocationTargetException {
                        return String.valueOf(calculate.calculateExportByYear(enterprise, operation1.getDateTime()));
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
                        int ln = calculate.calculateImportByYear(enterprise, operation1.getDateTime())
                                - calculate.calculateExportByYear(enterprise, operation1.getDateTime());
                        return String.valueOf(ln);  // trả về lợi nhuận theo ngày
                    }
                    
                    @Override
                    public PropertyEditor getPropertyEditor() {
                        return new PropertyEditorSupport();
                    }
                };
                set.put(chiProperty);
                set.put(loiNhuanProperty);
                sheet.put(set);
                return sheet;
            }
        };
        result.setDisplayName(operation1.getDateTime());
        return new Node[]{result};
    }

    @Override
    protected void addNotify() {
        super.addNotify();
        list = new ArrayList<Operation>();
        list1 = new ArrayList<Operation>();
        if (enterprise != null) {
            list = operationBN.getOperationByEnterprise(enterprise);                                       // lấy danh sách Operation từ CSDL

            int size = list.size();

            boolean flag = false;                                                       // Gán biến flag = false
            String str = list.get(0).getDateTime().substring(6, 10);
            // JOptionPane.showMessageDialog(null, str);
            Operation operation2 = new Operation();
            operation2.setDateTime(str);
            list1.add(operation2);

            for (int i = 1; i < size; i++) {
                int index = list1.size();
                if (!(list.get(i).getDateTime().substring(6, 10).equals(str))) {

                    for (int j = 0; j < index; j++) {
                        if (list.get(i).getDateTime().substring(6, 10).equals(list1.get(j).getDateTime())) {
                            flag = true;
                        }

                    }
                    if (!flag) {
                        Operation operation1 = new Operation();
                        operation1.setDateTime(list.get(i).getDateTime().substring(6, 10));
                        operation1.setOperationName(list.get(i).getOperationName());
                        list1.add(operation1);
                        str = list.get(i).getDateTime().substring(6, 10);
                    }
                }

            }

            Operation[] operations = new Operation[list1.size()];
            for (int i = 0; i < list1.size(); i++) {
                operations[i] = list1.get(i);
            }
            setKeys(operations);
        }

    }
}

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
public class OperationDay extends Children.Keys {

    private Operation operation;
    private List<Operation> list = new ArrayList<Operation>();
    private List<Operation> list1;
    private IOperationBN operationBN = Lookup.getDefault().lookup(IOperationBN.class);
    private ICalculate calculate = Lookup.getDefault().lookup(ICalculate.class);
    public static String Thu_PROPERTY = "Thu";
    public static String Chi_PROPERTY = "Chi";
    public static String LoiNhuan_PROPERTY = "LoiNhuan";
    private Enterprise enterprise;

    public OperationDay(Operation operation, Enterprise e) {
        this.operation = operation;
        this.enterprise = e;
        addNotify();
    }

    public OperationDay(boolean lazy) {
        super(lazy);
    }

    public OperationDay() {
    }

    @Override
    protected Node[] createNodes(Object key) {
        final Operation operation1 = (Operation) key;
        Node result = new AbstractNode(new OperationName(operation1, enterprise), Lookups.singleton(operation1)) {     // Tạo node

            // Enterprise enterprise = enterpriseBN.getEnterpriseByID("h01");
            @Override
            protected Sheet createSheet() {
                Sheet sheet = Sheet.createDefault();
                Sheet.Set set = Sheet.createPropertiesSet();

                // Tạo property thu cho Operation
                Property thuProperty = new PropertySupport.ReadOnly<String>(Thu_PROPERTY, String.class, "Thu", "aaa") {

                    @Override
                    public String getValue() throws IllegalAccessException, InvocationTargetException {
                        return String.valueOf(calculate.calculateImportByDate(enterprise, operation1.getDateTime()));   // trả về tổng Thu theo ngày
                    }
                    
                    @Override
                    public PropertyEditor getPropertyEditor() {
                        return new PropertyEditorSupport();
                    }
                };
                set.put(thuProperty);

                // Tạo property chi cho Operation
                Property chiProperty = new PropertySupport.ReadOnly<String>(Chi_PROPERTY, String.class, "Chi", "bbb") {

                    @Override
                    public String getValue() throws IllegalAccessException, InvocationTargetException {
                        return String.valueOf(calculate.calculateExportByDate(enterprise, operation1.getDateTime()));  // trả về tổng Chi theo ngày
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
                        int ln = calculate.calculateImportByDate(enterprise, operation1.getDateTime())
                                - calculate.calculateExportByDate(enterprise, operation1.getDateTime());
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
        result.setDisplayName(operation1.getDateTime());  // Set name cho node
        return new Node[]{result};
    }

    @Override
    protected void addNotify() {
        super.addNotify();
        list1 = new ArrayList<Operation>();
        if (enterprise != null) {
            list = operationBN.getOperationByEnterprise(enterprise);

            boolean flag = false;     // Khởi tạo flag
            String str = "";
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getDateTime().substring(3, 10).equals(operation.getDateTime()) // Kiểm tra xem
                        && list.get(i).getDateTime().substring(6, 10).equals(operation.getClassification())) {  // có đúng parent không
                    int index = list1.size();
                    if (!(list.get(i).getDateTime().substring(0, 10).equals(str))) {     // Kiểm tra xem có bị trùng ngày với nhau không
                        for (int j = 0; j < index; j++) {
                            if (list.get(i).getDateTime().substring(0, 10).equals(list1.get(j).getDateTime())) {     // Kiểm tra nếu bị
                                flag = true;                                            // trùng với ngày đã có trong danh sách thì bật flag lên
                            }
                        }
                        if (!flag) {    // Kiểm tra nếu flag = false thì thêm ngày vào danh sách tạo node
                            Operation operation1 = new Operation();
                            operation1.setDateTime(list.get(i).getDateTime());
                            operation1.setOperationName(list.get(i).getOperationName());
                            operation1.setSumPrice(list.get(i).getSumPrice());
                            operation1.setClassification(list.get(i).getClassification());
                            list1.add(operation1);
                            str = list.get(i).getDateTime().substring(0, 10);
                        }

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

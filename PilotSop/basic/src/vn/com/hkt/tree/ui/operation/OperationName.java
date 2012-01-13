/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.tree.ui.operation;

import vn.com.hkt.pilot.entities.Operation;
import vn.com.hkt.basic.api.IOperationBN;
import java.beans.IntrospectionException;
import java.util.ArrayList;
import java.util.List;
import org.openide.nodes.Children;
import org.openide.nodes.Node;
import org.openide.util.Exceptions;
import org.openide.util.Lookup;
import vn.com.hkt.pilot.entities.Enterprise;

/**
 *
 * @author longnt
 */
public class OperationName extends Children.Keys {

    private Operation operation;
    private List<Operation> list = new ArrayList<Operation>();
    private List<Operation> list1;
    private IOperationBN operationBN = Lookup.getDefault().lookup(IOperationBN.class);
    private Enterprise enterprise;

    public OperationName(boolean lazy) {
        super(lazy);
    }

    public OperationName(Operation operation, Enterprise e) {
        this.operation = operation;
        this.enterprise = e;
        addNotify();
    }

    public OperationName() {
    }

    @Override
    protected Node[] createNodes(Object key) {
        Operation operation1 = (Operation) key;
        Node result = null;
        try {
            result = new OperationNode(operation1);
        } catch (IntrospectionException ex) {
            Exceptions.printStackTrace(ex);
        }
        result.setDisplayName(operation1.getOperationName());
        return new Node[]{result};
    }

    @Override
    protected void addNotify() {
        super.addNotify();
        list1 = new ArrayList<Operation>();
        if (enterprise != null) {
            list = operationBN.getOperationByEnterprise(enterprise);

            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getDateTime().equals(operation.getDateTime())) {
                    Operation operation1 = new Operation();
                    operation1.setOperationName(list.get(i).getOperationName());
                    operation1.setSumPrice(list.get(i).getSumPrice());
                    list1.add(operation1);
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

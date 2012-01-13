/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.tree.ui.department.thuchi;

import java.beans.PropertyEditor;
import java.beans.PropertyEditorSupport;
import vn.com.hkt.pilot.entities.Department;
import vn.com.hkt.basic.api.IDepartmentBN;
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
import vn.com.hkt.finance.spi.CalculateSPI;
import vn.com.hkt.pilot.datetime.utils.DateTimeUtils;
import vn.com.hkt.pilot.entities.Enterprise;

/**
 *
 * @author longnt
 */
public class DepartmentParentTongQuan extends Children.Keys {

    private List<Department> list = new ArrayList<Department>();
    private IDepartmentBN departmentBN = Lookup.getDefault().lookup(IDepartmentBN.class);
    public static String ThuMonth1_PROPERTY = "ThuM1";
    public static String ChiMonth1_PROPERTY = "ChiM1";
    public static String Lai1_PROPERTY = "LaiM1";
    public static String ThuMonth2_PROPERTY = "ThuM2";
    public static String ChiMonth2_PROPERTY = "ChiM2";
    public static String Lai2_PROPERTY = "LaiM2";
    public static String ThuMonth3_PROPERTY = "ThuM3";
    public static String ChiMonth3_PROPERTY = "ChiM3";
    public static String Lai3_PROPERTY = "LaiM3";
    public static String ThuYear1_PROPERTY = "ThuY1";
    public static String ChiYear1_PROPERTY = "ChiY1";
    public static String LaiYear1_PROPERTY = "LaiY1";
    public static String ThuYear2_PROPERTY = "ThuY2";
    public static String ChiYear2_PROPERTY = "ChiY2";
    public static String LaiYear2_PROPERTY = "LaiY2";
    public static String ThuAll_PROPERTY = "ThuAll";
    public static String ChiAll_PROPERTY = "ChiAll";
    public static String LaiAll_PROPERTY = "LaiAll";
    private Department department;
    private Enterprise enterprise;
    private CalculateSPI calculateSPI;
    private DateTimeUtils dateTimeUtils;
    private String month1, month2, month3, year1, year2;

    public DepartmentParentTongQuan(boolean lazy) {
        super(lazy);
    }

    public DepartmentParentTongQuan(Department department, Enterprise enterprise) {
        this.department = department;
        this.enterprise = enterprise;
        if (enterprise != null) {
            list = departmentBN.filterDepartmentByEnterprise(enterprise);
        }
        calculateSPI = new CalculateSPI();
        dateTimeUtils = new DateTimeUtils();
        month1 = dateTimeUtils.getCurrentMonth() + "/" + dateTimeUtils.getCurrentYear();
        month2 = String.valueOf(dateTimeUtils.addMonth(-1)) + "/" + dateTimeUtils.addYearWithMonth(-1);
        month3 = String.valueOf(dateTimeUtils.addMonth(-2)) + "/" + dateTimeUtils.addYearWithMonth(-2);
        year1 = String.valueOf(dateTimeUtils.getCurrentYear());
        year2 = String.valueOf(dateTimeUtils.getCurrentYear() - 1);
    }

    @Override
    protected Node[] createNodes(Object key) {
        final Department department1 = (Department) key;
        Node result = new AbstractNode(new DepartmentChildrenTongQuan(department1, enterprise), Lookups.singleton(department1)) {

            @Override
            protected Sheet createSheet() {
                Sheet sheet = Sheet.createDefault();
                Sheet.Set set = Sheet.createPropertiesSet();

                Property thuMonth1Property = new PropertySupport.ReadOnly<String>(ThuMonth1_PROPERTY, String.class, "ThuM1", "aaa") {

                    @Override
                    public String getValue() throws IllegalAccessException, InvocationTargetException {
                        return String.valueOf(calculateSPI.calculateImportByMonthOfDepartment(enterprise, department1, month1));
                    }

                    @Override
                    public PropertyEditor getPropertyEditor() {
                        return new PropertyEditorSupport();
                    }
                };
                set.put(thuMonth1Property);
                Property chiMonth1Property =
                        new PropertySupport.ReadOnly<String>(ChiMonth1_PROPERTY, String.class, "ChiM1", "bbb") {

                            @Override
                            public String getValue() throws IllegalAccessException, InvocationTargetException {
                                return String.valueOf(calculateSPI.calculateExportByMonthOfDepartment(enterprise, department1, month1));
                            }

                            @Override
                            public PropertyEditor getPropertyEditor() {
                                return new PropertyEditorSupport();
                            }
                        };
                set.put(chiMonth1Property);
                Property thuMonth2Property =
                        new PropertySupport.ReadOnly<String>(ThuMonth2_PROPERTY, String.class, "ThuM2", "bbb") {

                            @Override
                            public String getValue() throws IllegalAccessException, InvocationTargetException {
                                return String.valueOf(calculateSPI.calculateImportByMonthOfDepartment(enterprise, department1, month2));
                            }

                            @Override
                            public PropertyEditor getPropertyEditor() {
                                return new PropertyEditorSupport();
                            }
                        };
                set.put(thuMonth2Property);
                Property chiMonth2Property =
                        new PropertySupport.ReadOnly<String>(ChiMonth2_PROPERTY, String.class, "ChiM2", "bbb") {

                            @Override
                            public String getValue() throws IllegalAccessException, InvocationTargetException {
                                return String.valueOf(calculateSPI.calculateExportByMonthOfDepartment(enterprise, department1, month2));
                            }

                            @Override
                            public PropertyEditor getPropertyEditor() {
                                return new PropertyEditorSupport();
                            }
                        };
                set.put(chiMonth2Property);
                Property thuMonth3Property =
                        new PropertySupport.ReadOnly<String>(ThuMonth3_PROPERTY, String.class, "ThuM3", "bbb") {

                            @Override
                            public String getValue() throws IllegalAccessException, InvocationTargetException {
                                return String.valueOf(calculateSPI.calculateImportByMonthOfDepartment(enterprise, department1, month3));
                            }

                            @Override
                            public PropertyEditor getPropertyEditor() {
                                return new PropertyEditorSupport();
                            }
                        };
                set.put(thuMonth3Property);
                Property chiMonth3Property =
                        new PropertySupport.ReadOnly<String>(ChiMonth3_PROPERTY, String.class, "ChiM3", "bbb") {

                            @Override
                            public String getValue() throws IllegalAccessException, InvocationTargetException {
                                return String.valueOf(calculateSPI.calculateExportByMonthOfDepartment(enterprise, department1, month3));
                            }

                            @Override
                            public PropertyEditor getPropertyEditor() {
                                return new PropertyEditorSupport();
                            }
                        };
                set.put(chiMonth3Property);
                Property laiMonth1Property =
                        new PropertySupport.ReadOnly<String>(Lai1_PROPERTY, String.class, "LaiM1", "bbb") {

                            @Override
                            public String getValue() throws IllegalAccessException, InvocationTargetException {
                                return String.valueOf(calculateSPI.calculateImportByMonthOfDepartment(enterprise, department1, month1) - calculateSPI.calculateExportByMonthOfDepartment(enterprise, department1, month1));
                            }

                            @Override
                            public PropertyEditor getPropertyEditor() {
                                return new PropertyEditorSupport();
                            }
                        };
                set.put(laiMonth1Property);
                Property laiMonth2Property =
                        new PropertySupport.ReadOnly<String>(Lai2_PROPERTY, String.class, "LaiM2", "bbb") {

                            @Override
                            public String getValue() throws IllegalAccessException, InvocationTargetException {
                                return String.valueOf(calculateSPI.calculateImportByMonthOfDepartment(enterprise, department1, month2) - calculateSPI.calculateExportByMonthOfDepartment(enterprise, department1, month2));
                            }

                            @Override
                            public PropertyEditor getPropertyEditor() {
                                return new PropertyEditorSupport();
                            }
                        };
                set.put(laiMonth2Property);
                Property lMaionth3Property =
                        new PropertySupport.ReadOnly<String>(Lai3_PROPERTY, String.class, "LaiM3", "bbb") {

                            @Override
                            public String getValue() throws IllegalAccessException, InvocationTargetException {
                                return String.valueOf(calculateSPI.calculateImportByMonthOfDepartment(enterprise, department1, month3) - calculateSPI.calculateExportByMonthOfDepartment(enterprise, department1, month3));
                            }

                            @Override
                            public PropertyEditor getPropertyEditor() {
                                return new PropertyEditorSupport();
                            }
                        };
                set.put(lMaionth3Property);
                Property thuYear1Property =
                        new PropertySupport.ReadOnly<String>(ThuYear1_PROPERTY, String.class, "ThuY1", "bbb") {

                            @Override
                            public String getValue() throws IllegalAccessException, InvocationTargetException {
                                return String.valueOf(calculateSPI.calculateImportByYearOfDepartment(enterprise, department1, year1));
                            }

                            @Override
                            public PropertyEditor getPropertyEditor() {
                                return new PropertyEditorSupport();
                            }
                        };
                set.put(thuYear1Property);
                Property chiYear1Property =
                        new PropertySupport.ReadOnly<String>(ChiYear1_PROPERTY, String.class, "ChiY1", "bbb") {

                            @Override
                            public String getValue() throws IllegalAccessException, InvocationTargetException {
                                return String.valueOf(calculateSPI.calculateExportByYearOfDepartment(enterprise, department1, year1));
                            }

                            @Override
                            public PropertyEditor getPropertyEditor() {
                                return new PropertyEditorSupport();
                            }
                        };
                set.put(chiYear1Property);
                Property laiYear1Property =
                        new PropertySupport.ReadOnly<String>(LaiYear1_PROPERTY, String.class, "LaiY1", "bbb") {

                            @Override
                            public String getValue() throws IllegalAccessException, InvocationTargetException {
                                return String.valueOf(calculateSPI.calculateImportByYearOfDepartment(enterprise, department1, year1) - calculateSPI.calculateExportByYearOfDepartment(enterprise, department1, year1));
                            }

                            @Override
                            public PropertyEditor getPropertyEditor() {
                                return new PropertyEditorSupport();
                            }
                        };
                set.put(laiYear1Property);

                Property thuYear2Property =
                        new PropertySupport.ReadOnly<String>(ThuYear2_PROPERTY, String.class, "ThuY2", "bbb") {

                            @Override
                            public String getValue() throws IllegalAccessException, InvocationTargetException {
                                return String.valueOf(calculateSPI.calculateImportByYearOfDepartment(enterprise, department1, year2));
                            }

                            @Override
                            public PropertyEditor getPropertyEditor() {
                                return new PropertyEditorSupport();
                            }
                        };
                set.put(thuYear2Property);
                Property chiYear2Property =
                        new PropertySupport.ReadOnly<String>(ChiYear2_PROPERTY, String.class, "ChiY2", "bbb") {

                            @Override
                            public String getValue() throws IllegalAccessException, InvocationTargetException {
                                return String.valueOf(calculateSPI.calculateExportByYearOfDepartment(enterprise, department1, year2));
                            }

                            @Override
                            public PropertyEditor getPropertyEditor() {
                                return new PropertyEditorSupport();
                            }
                        };
                set.put(chiYear2Property);
                Property laiYear2Property =
                        new PropertySupport.ReadOnly<String>(LaiYear2_PROPERTY, String.class, "LaiY2", "bbb") {

                            @Override
                            public String getValue() throws IllegalAccessException, InvocationTargetException {
                                return String.valueOf(calculateSPI.calculateImportByYearOfDepartment(enterprise, department1, year2) - calculateSPI.calculateExportByYearOfDepartment(enterprise, department1, year2));
                            }

                            @Override
                            public PropertyEditor getPropertyEditor() {
                                return new PropertyEditorSupport();
                            }
                        };
                set.put(laiYear2Property);
                Property thuAllProperty =
                        new PropertySupport.ReadOnly<String>(ThuAll_PROPERTY, String.class, "ThuAll", "bbb") {

                            @Override
                            public String getValue() throws IllegalAccessException, InvocationTargetException {
                                return String.valueOf(calculateSPI.calculateImportAllOfDepartment(enterprise, department1));
                            }

                            @Override
                            public PropertyEditor getPropertyEditor() {
                                return new PropertyEditorSupport();
                            }
                        };
                set.put(thuAllProperty);
                Property chiAllProperty =
                        new PropertySupport.ReadOnly<String>(ChiAll_PROPERTY, String.class, "ChiAll", "bbb") {

                            @Override
                            public String getValue() throws IllegalAccessException, InvocationTargetException {
                                return String.valueOf(calculateSPI.calculateExportAllOfDepartment(enterprise, department1));
                            }

                            @Override
                            public PropertyEditor getPropertyEditor() {
                                return new PropertyEditorSupport();
                            }
                        };
                set.put(chiAllProperty);
                Property laiAllProperty =
                        new PropertySupport.ReadOnly<String>(LaiAll_PROPERTY, String.class, "LaiAll", "bbb") {

                            @Override
                            public String getValue() throws IllegalAccessException, InvocationTargetException {
                                return String.valueOf(calculateSPI.calculateImportAllOfDepartment(enterprise, department1) - calculateSPI.calculateExportAllOfDepartment(enterprise, department1));
                            }

                            @Override
                            public PropertyEditor getPropertyEditor() {
                                return new PropertyEditorSupport();
                            }
                        };
                set.put(laiAllProperty);
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

        Vector instr = new Vector();
        for (Department bean : list) {
            if (bean.getDepartmentParent().toString().trim().length() == 0) {
                instr.addElement(bean);
            }
        }

        Department[] Departments = new Department[instr.size()];
        for (int i = 0; i < instr.size(); i++) {
            Departments[i] = (Department) instr.elementAt(i);
        }
        setKeys(Departments);
    }
}

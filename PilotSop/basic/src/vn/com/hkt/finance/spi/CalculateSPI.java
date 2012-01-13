/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.finance.spi;

import vn.com.hkt.finance.api.ICalculate;
import java.util.ArrayList;
import java.util.List;
import org.openide.util.Lookup;
import org.openide.util.lookup.ServiceProvider;
import vn.com.hkt.basic.api.IOperationBN;
import vn.com.hkt.pilot.datetime.utils.DateTimeConverter;
import vn.com.hkt.pilot.datetime.utils.DateTimeUtils;
import vn.com.hkt.pilot.entities.Department;
import vn.com.hkt.pilot.entities.Operation;
import vn.com.hkt.pilot.entities.Enterprise;
import vn.com.hkt.pilot.entities.Product;

/**
 *
 * @author khanguct
 */
@ServiceProvider(service = ICalculate.class)
public class CalculateSPI implements ICalculate {

    private IOperationBN operationBN;
    private String CLASSIFICATION_IMPORT = "Thu";
    private String CLASSIFICATION_EXPORT = "Chi";
    
    private DateTimeUtils dateTimeUtils = new DateTimeUtils();
    private DateTimeConverter dateTimeConverter = new DateTimeConverter();

    public CalculateSPI() {
        this.operationBN = Lookup.getDefault().lookup(IOperationBN.class);
    }

///////////////////////////////////// Cac Ham Trung Gian (protected) /////////////////////////////////////////////
    /**
     * Nghiep vu tinh tong tien giao dich nao do
     * trong ngay, thang, nam hoac thang, nam hoac nam
     * @param date
     * @return 
     */
    protected int calculateOperationByDate(Enterprise enter, String date, String classification) {

        int S = 0;
        List<Operation> list = new ArrayList<Operation>();
        list = operationBN.filterOperationByDate(date);
        if (!list.isEmpty()) {
            for (Operation bean : list) {
                if ((bean.getEnterpriseID().equals(enter.getEnterpriseName())) && (bean.getClassification().equals(classification))) {
                    S += bean.getSumPrice();
                }
            }
        }
        return S;
    }
    
    /**
     * 
     * Nghiep vu tinh thu, chi theo tuan
     * cua 1 Enterprise nao do
     * @param enter
     * @param classification
     * @param week
     * @param year
     * @return 
     */
    protected int calculateOperationByWeek(Enterprise enter, String classification, int week, int year) {
        int S=0;
        List<Operation> list = new ArrayList<Operation>();
        list = operationBN.getOperationByWeek(enter, week, year);
        if(!list.isEmpty()){
            for(Operation bean : list){
                if(bean.getClassification().equals(classification)){
                    S += bean.getSumPrice();
                }
            }
        }
        return S;
    }

    /**
     * Nghiep vu tinh tong tien giao dich nao do 
     * @param date
     * @return 
     */
    protected int calculateOperationByDepartment(Enterprise enter, Department department, String classification) {

        int S = 0;
        List<Operation> list = new ArrayList<Operation>();
        list = operationBN.getOperationByEnterprise(enter);
        if (!list.isEmpty()) {
            for (Operation bean : list) {
                if ((bean.getDepartmentID().equals(department.getDepartmentName())) && (bean.getClassification().equals(classification))) {
                    S += bean.getSumPrice();
                }
            }
        }
        return S;
    }

    /**
     * Nghiep vu tinh tong tien giao dich nao do
     * trong ngay, thang, nam hoac thang, nam hoac nam
     * @param date
     * @return 
     */
    protected int calculateOperationOfDepartmentByDate(Enterprise enter, Department department, String date, String classification) {

        int S = 0;
        List<Operation> list = new ArrayList<Operation>();
        list = operationBN.filterOperationByDate(date);
        if (!list.isEmpty()) {
            for (Operation bean : list) {
                if ((bean.getEnterpriseID().equals(enter.getEnterpriseName())) && (bean.getClassification().equals(classification))
                        && (bean.getDepartmentID().equals(department.getDepartmentName()))) {
                    S += bean.getSumPrice();
                }
            }
        }
        return S;
    }

    /**
     * Nghiep vu tinh tong tien giao dich nao do
     * trong ngay, thang, nam hoac thang, nam hoac nam
     * @param date
     * @return 
     */
    protected int calculateOperationOfProductByDate(Enterprise enter, Product product, String date, String classification) {

        int S = 0;
        List<Operation> list = new ArrayList<Operation>();
        list = operationBN.filterOperationByDate(date);
        if (!list.isEmpty()) {
            for (Operation bean : list) {
                if ((bean.getEnterpriseID().equals(enter.getEnterpriseName())) && (bean.getClassification().equals(classification))
                        && (bean.getProductID().equals(product.getProductName()))) {
                    S += bean.getSumPrice();
                }
            }
        }
        return S;
    }

    /**
     * Nghiep vu tinh tong tien giao dich nao do 
     * @param date
     * @return 
     */
    protected int calculateOperationByProduct(Enterprise enter, Product product, String classification) {

        int S = 0;
        List<Operation> list = new ArrayList<Operation>();
        list = operationBN.getOperationByEnterprise(enter);
        if (!list.isEmpty()) {
            for (Operation bean : list) {
                if ((bean.getProductID().equals(product.getProductName())) && (bean.getClassification().equals(classification))) {
                    S += bean.getSumPrice();
                }
            }
        }
        return S;
    }

///////////////////////////////////////// Tinh Toan Theo Enterprise ////////////////////////////////////////////////////   
    @Override
    public int calculateImportByDate(Enterprise enter, String date) {
        int S = 0;
        String income = this.CLASSIFICATION_IMPORT;
        S = calculateOperationByDate(enter, date, income);
        return S;
    }

    @Override
    public int calculateExportByDate(Enterprise enter, String date) {
        int S = 0;
        String outcome = this.CLASSIFICATION_EXPORT;
        S = calculateOperationByDate(enter, date, outcome);
        return S;
    }

    @Override
    public int calculateImportByWeek(Enterprise enter, int week, int year) {
        int S=0;
        S=calculateOperationByWeek(enter, CLASSIFICATION_IMPORT, week, year);
        return S;
    }

    @Override
    public int calculateExportByWeek(Enterprise enter, int week, int year) {
        int S=0;
        S=calculateOperationByWeek(enter, CLASSIFICATION_EXPORT, week, year);
        return S;
    }

    @Override
    public int calculateImportByMonth(Enterprise enter, String month) {
        int S = 0;
        String income = this.CLASSIFICATION_IMPORT;
        S = calculateOperationByDate(enter, month, income);
        return S;
    }

    @Override
    public int calculateExportByMonth(Enterprise enter, String month) {
        int S = 0;
        String outcome = this.CLASSIFICATION_EXPORT;
        S = calculateOperationByDate(enter, month, outcome);
        return S;
    }

    @Override
    public int calculateImportByYear(Enterprise enter, String year) {
        int S = 0;
        String income = this.CLASSIFICATION_IMPORT;
        S = calculateOperationByDate(enter, year, income);
        return S;
    }

    @Override
    public int calculateExportByYear(Enterprise enter, String year) {
        int S = 0;
        String outcome = this.CLASSIFICATION_EXPORT;
        S = calculateOperationByDate(enter, year, outcome);
        return S;
    }

    @Override
    public int calculateSumImport() {
        int S = 0;
        List<Operation> list = operationBN.getAllOperation();
        if (!list.isEmpty()) {
            for (Operation bean : list) {
                if (bean.getClassification().equals(this.CLASSIFICATION_IMPORT)) {
                    S += bean.getSumPrice();
                }
            }
        }
        return S;
    }

    @Override
    public int calculateSumExport() {
        int S = 0;
        List<Operation> list = operationBN.getAllOperation();
        if (!list.isEmpty()) {
            for (Operation bean : list) {
                if (bean.getClassification().equals(this.CLASSIFICATION_EXPORT)) {
                    S += bean.getSumPrice();
                }
            }
        }
        return S;
    }

    @Override
    public int calculateSumImportByEnterprise(Enterprise enterprise) {
        int S = 0;
        List<Operation> list = operationBN.getAllOperation();
        if (!list.isEmpty()) {
            for (Operation bean : list) {
                if ((bean.getClassification().equals(this.CLASSIFICATION_IMPORT))
                        && (bean.getEnterpriseID().equals(enterprise.getEnterpriseName()))) {
                    S += bean.getSumPrice();
                }
            }
        }
        return S;
    }

    @Override
    public int calculateSumExportByEnterprise(Enterprise enterprise) {
        int S = 0;
        List<Operation> list = operationBN.getAllOperation();
        if (!list.isEmpty()) {
            for (Operation bean : list) {
                if ((bean.getClassification().equals(this.CLASSIFICATION_EXPORT))
                        && (bean.getEnterpriseID().equals(enterprise.getEnterpriseName()))) {
                    S += bean.getSumPrice();
                }
            }
        }
        return S;
    }

///////////////////////////////////////// Ket Thuc Tinh Toan Theo Enterprise ////////////////////////////////////////////////////    
///////////////////////////////////////// Tinh Toan Theo Department ////////////////////////////////////////////////////
    @Override
    public int calculateImportByMonthOfDepartment(Enterprise enterprise, Department department, String date) {
        int S = 0;
        S = calculateOperationOfDepartmentByDate(enterprise, department, date, CLASSIFICATION_IMPORT);
        return S;
    }

    @Override
    public int calculateExportByMonthOfDepartment(Enterprise enterprise, Department department, String date) {
        int S = 0;
        S = calculateOperationOfDepartmentByDate(enterprise, department, date, CLASSIFICATION_EXPORT);
        return S;
    }

    @Override
    public int calculateImportByYearOfDepartment(Enterprise enterprise, Department department, String date) {
        int S = 0;
        S = calculateOperationOfDepartmentByDate(enterprise, department, date, CLASSIFICATION_IMPORT);
        return S;
    }

    @Override
    public int calculateExportByYearOfDepartment(Enterprise enterprise, Department department, String date) {
        int S = 0;
        S = calculateOperationOfDepartmentByDate(enterprise, department, date, CLASSIFICATION_EXPORT);
        return S;
    }

    @Override
    public int calculateImportAllOfDepartment(Enterprise enterprise, Department department) {
        int S = 0;
        S = calculateOperationByDepartment(enterprise, department, CLASSIFICATION_IMPORT);
        return S;
    }

    @Override
    public int calculateExportAllOfDepartment(Enterprise enterprise, Department department) {
        int S = 0;
        S = calculateOperationByDepartment(enterprise, department, CLASSIFICATION_EXPORT);
        return S;
    }

//////////////////////////////////////////////// Ket Thuc Tinh Toan Theo Department//////////////////////////////////////////////////////////////
////////////////////////////////// Tính toán theo Product ///////////////////////////////////////////////////////    
    @Override
    public int calculateImportByMonthOfProduct(Enterprise enterprise, Product product, String date) {
        int S = 0;
        S = calculateOperationOfProductByDate(enterprise, product, date, CLASSIFICATION_IMPORT);
        return S;
    }

    @Override
    public int calculateExportByMonthOfProduct(Enterprise enterprise, Product product, String date) {
        int S = 0;
        S = calculateOperationOfProductByDate(enterprise, product, date, CLASSIFICATION_EXPORT);
        return S;
    }

    @Override
    public int calculateImportByYearOfProduct(Enterprise enterprise, Product product, String date) {
        int S = 0;
        S = calculateOperationOfProductByDate(enterprise, product, date, CLASSIFICATION_IMPORT);
        return S;
    }

    @Override
    public int calculateExportByYearOfProduct(Enterprise enterprise, Product product, String date) {
        int S = 0;
        S = calculateOperationOfProductByDate(enterprise, product, date, CLASSIFICATION_EXPORT);
        return S;
    }

    @Override
    public int calculateImportAllOfProduct(Enterprise enterprise, Product product) {
        int S = 0;
        S = calculateOperationByProduct(enterprise, product, CLASSIFICATION_IMPORT);
        return S;
    }

    @Override
    public int calculateExportAllOfProduct(Enterprise enterprise, Product product) {
        int S = 0;
        S = calculateOperationByProduct(enterprise, product, CLASSIFICATION_EXPORT);
        return S;
    }
///////////////////////// Kết thúc tính toán theo Product ///////////////////////////////////////////////////////    
}
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.finance.api;

import vn.com.hkt.pilot.entities.Department;
import vn.com.hkt.pilot.entities.Enterprise;
import vn.com.hkt.pilot.entities.Product;


/**
 *
 * @author khanguct
 */
public interface ICalculate {
    
    /**
     * Nghiep vu tinh tong thu 
     * @param date
     * @param income
     * @return 
     */
    public int calculateSumImport();
    
     /**
     * Nghiep vu tinh tong chi 
     * @param date
     * @param income
     * @return 
     */
    public int calculateSumExport();
    
     /**
     * Nghiep vu tinh tong thu 
     * @param date
     * @param income
     * @return 
     */
    public int calculateSumImportByEnterprise(Enterprise enterprise);
    
     /**
     * Nghiep vu tinh tong chi 
     * @param date
     * @param income
     * @return 
     */
    public int calculateSumExportByEnterprise(Enterprise enterprise);
    
    /**
     * Nghiep vu tinh tong thu trong 1 ngay cua 1 thang,
     * 1 nam bat ky
     * @param date
     * @param income
     * @return 
     */
    public int calculateImportByDate(Enterprise enter, String date);
    
    /**
     * Nghiep vu tinh tong chi trong 1 ngay cua 1 thang,
     * 1 nam bat ky
     * @param date
     * @param income
     * @return 
     */
    public int calculateExportByDate(Enterprise enter, String date);
    
    /**
     * Nghiep vu tinh tong thu trong 1 thang cua
     * 1 nam bat ky
     * @param date
     * @param income
     * @return 
     */
    public int calculateImportByMonth(Enterprise enter, String month);
    
    /**
     * Nghiep vu tinh tong chi trong 1 thang cua
     * 1 nam bat ky
     * @param date
     * @param income
     * @return 
     */
    public int calculateExportByMonth(Enterprise enter, String month);
    
    /**
     * Nghiep vu tinh tong thu trong 1 tuan cua
     * 1 nam bat ky
     * @param date
     * @param income
     * @return 
     */
    public int calculateImportByWeek(Enterprise enter, int week, int year);
    
    /**
     * Nghiep vu tinh tong chi trong 1 tuan cua
     * 1 nam bat ky
     * @param date
     * @param income
     * @return 
     */
    public int calculateExportByWeek(Enterprise enter, int week, int year);
    
    /**
     * Nghiep vu tinh tong thu trong 1 thang cua
     * 1 nam bat ky
     * @param date
     * @param income
     * @return 
     */
    public int calculateImportByYear(Enterprise enter, String year);
    
    /**
     * Nghiep vu tinh tong chi trong 1 thang cua
     * 1 nam bat ky
     * @param date
     * @param income
     * @return 
     */
    public int calculateExportByYear(Enterprise enter, String year);
   
//////////////////////// Tính toán theo Department /////////////////////////////////    
    
    /**
     * Tinh tong thu cua 1 Department trong thang theo enterprise
     * @param enterprise
     * @param department
     * @param date
     * @return 
     */
    public int calculateImportByMonthOfDepartment(Enterprise enterprise, Department department, String date);
    
    /**
     * Tinh tong chi cua 1 Department trong thang theo enterprise
     * @param enterprise
     * @param department
     * @param date
     * @return 
     */
    public int calculateExportByMonthOfDepartment(Enterprise enterprise, Department department, String date);
    
    /**
     * Tinh tong thu cua 1 Department trong nam theo enterprise
     * @param enterprise
     * @param department
     * @param date
     * @return 
     */
    public int calculateImportByYearOfDepartment(Enterprise enterprise, Department department, String date);
    
    /**
     * Tinh tong chi cua 1 Department trong nam theo enterprise
     * @param enterprise
     * @param department
     * @param date
     * @return 
     */
    public int calculateExportByYearOfDepartment(Enterprise enterprise, Department department, String date);
    
    /**
     * Tinh tong thu cua 1 Department bat ky
     * @param enterprise
     * @param department
     * @return 
     */
    public int calculateImportAllOfDepartment(Enterprise enterprise, Department department);
    
    /**
     * Tinh tong chi cua 1 Department bat ky
     * @param enterprise
     * @param department
     * @return 
     */
    public int calculateExportAllOfDepartment(Enterprise enterprise, Department department);
    
////////////////////////////////////  Tính toán theo product /////////////////////////////////////////
    
    /**
     * Tinh tong thu cua 1 Product trong thang theo enterprise
     * @param enterprise
     * @param department
     * @param date
     * @return 
     */
    public int calculateImportByMonthOfProduct(Enterprise enterprise, Product product, String date);
    
    /**
     * Tinh tong chi cua 1 Department trong thang theo enterprise
     * @param enterprise
     * @param department
     * @param date
     * @return 
     */
    public int calculateExportByMonthOfProduct(Enterprise enterprise, Product product, String date);
    
    /**
     * Tinh tong thu cua 1 Department trong nam theo enterprise
     * @param enterprise
     * @param department
     * @param date
     * @return 
     */
    public int calculateImportByYearOfProduct(Enterprise enterprise, Product product, String date);
    
    /**
     * Tinh tong chi cua 1 Department trong nam theo enterprise
     * @param enterprise
     * @param department
     * @param date
     * @return 
     */
    public int calculateExportByYearOfProduct(Enterprise enterprise, Product product, String date);
    
    /**
     * Tinh tong thu cua 1 Department bat ky
     * @param enterprise
     * @param department
     * @return 
     */
    public int calculateImportAllOfProduct(Enterprise enterprise, Product product);
    
    /**
     * Tinh tong chi cua 1 Department bat ky
     * @param enterprise
     * @param department
     * @return 
     */
    public int calculateExportAllOfProduct(Enterprise enterprise, Product product);
    
    
    
}
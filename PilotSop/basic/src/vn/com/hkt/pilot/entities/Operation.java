/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.pilot.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author khanguct
 */
@Entity
public class Operation {

    @Id
    private String OperationID;
    private String OperationName;
    private String DateTime;
    private String ProductID; // San pham
    private String EnterpriseID; // Cong ty
    private String DepartmentID; // Bo phan
    private String PersonID; // Nguoi chiu trach nhiem
    private String Classification;// Phan Loai
    private int Number; // So luong
    private int UnitPrice; // Don gia
    private int SumPrice; // Tong gia
    private String calculationUnit;
    private String unitOfMeasure;

    public String getCalculationUnit() {
        return calculationUnit;
    }

    public void setCalculationUnit(String calculationUnit) {
        this.calculationUnit = calculationUnit;
    }

    public String getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(String unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

     /**
     * @return the OperationID
     */
    public String getOperationID() {
        return OperationID;
    }

    /**
     * @param OperationID the OperationID to set
     */
    public void setOperationID(String OperationID) {
        this.OperationID = OperationID;
    }

    /**
     * @return the OperationName
     */
    public String getOperationName() {
        return OperationName;
    }

    /**
     * @param OperationName the OperationName to set
     */
    public void setOperationName(String OperationName) {
        this.OperationName = OperationName;
    }
    /**
     * @return the DateTime
     */
    public String getDateTime() {
        return DateTime;
    }

    /**
     * @param DateTime the DateTime to set
     */
    public void setDateTime(String DateTime) {
        this.DateTime = DateTime;
    }

    /**
     * @return the ProductID
     */
    public String getProductID() {
        return ProductID;
    }

    /**
     * @param ProductID the ProductID to set
     */
    public void setProductID(String ProductID) {
        this.ProductID = ProductID;
    }

    /**
     * @return the EnterpriseID
     */
    public String getEnterpriseID() {
        return EnterpriseID;
    }

    /**
     * @param EnterpriseID the EnterpriseID to set
     */
    public void setEnterpriseID(String EnterpriseID) {
        this.EnterpriseID = EnterpriseID;
    }

    /**
     * @return the DepartmentID
     */
    public String getDepartmentID() {
        return DepartmentID;
    }

    /**
     * @param DepartmentID the DepartmentID to set
     */
    public void setDepartmentID(String DepartmentID) {
        this.DepartmentID = DepartmentID;
    }

    /**
     * @return the PersonID
     */
    public String getPersonID() {
        return PersonID;
    }

    /**
     * @param PersonID the PersonID to set
     */
    public void setPersonID(String PersonID) {
        this.PersonID = PersonID;
    }

    /**
     * @return the Classification
     */
    public String getClassification() {
        return Classification;
    }

    /**
     * @param Classification the Classification to set
     */
    public void setClassification(String Classification) {
        this.Classification = Classification;
    }

    /**
     * @return the Number
     */
    public int getNumber() {
        return Number;
    }

    /**
     * @param Number the Number to set
     */
    public void setNumber(int Number) {
        this.Number = Number;
    }

    /**
     * @return the UnitPrice
     */
    public int getUnitPrice() {
        return UnitPrice;
    }

    /**
     * @param UnitPrice the UnitPrice to set
     */
    public void setUnitPrice(int UnitPrice) {
        this.UnitPrice = UnitPrice;
    }

    /**
     * @return the SumPrice
     */
    public int getSumPrice() {
        return SumPrice;
    }

    /**
     * @param SumPrice the SumPrice to set
     */
    public void setSumPrice(int SumPrice) {
        this.SumPrice = SumPrice;
    }

    public Operation(String TransactionID, String TransactionName, String DateTime, String ProductID, String EnterpriseID, String DepartmentID, 
            String PersonID, String Classification, int Number, int UnitPrice, int SumPrice, String calculationUnit, String unitOfMeasure) {
        this.OperationID = TransactionID;
        this.OperationName = TransactionName;
        this.DateTime = DateTime;
        this.ProductID = ProductID;
        this.EnterpriseID = EnterpriseID;
        this.DepartmentID = DepartmentID;
        this.PersonID = PersonID;
        this.Classification = Classification;
        this.Number = Number;
        this.UnitPrice = UnitPrice;
        this.SumPrice = SumPrice;
        this.calculationUnit = calculationUnit;
        this.unitOfMeasure = unitOfMeasure;
    }

    public Operation() {
    }

    @Override
    public String toString() {
        return this.getOperationName();
    }

   
}

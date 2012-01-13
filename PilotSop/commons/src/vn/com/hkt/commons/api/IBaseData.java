/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.commons.api;

/**
 *
 * @author home
 */
public interface IBaseData {

    public boolean insertAccountIntoXML(
            String username,
            String password,
            String personID,
            String departmentID);

    public void insertAccountIntoDatabasefromXML();

    public boolean insertDepartmentIntoXML(
            String departmentID,
            String departmentName,
            String enterpriseID,
            String personID,
            String departmentParent);

    public void insertDepartmentIntoDatabasefromXML();

    public boolean insertEnterpriseIntoXML(
            String enterpriseID,
            String enterpriseName,
            String enterpriseParrent,
            String director);

    public void insertEnterpriseIntoDatabasefromXML();

    public boolean insertOperationIntoXML(
            String operationID,
            String operationName,
            String datetime,
            String productID,
            String enterpriseID,
            String departmentID,
            String personID,
            String classification,
            int number,
            int unitPrice,
            int sumPrice);

    public void insertOperationIntoDatabasefromXML();

    public boolean insertPersonIntoXML(
            String personID,
            String firstname,
            String lastname,
            String enterpriseID,
            String departmentName,
            String position);

    public void insertPersonIntoDatabasefromXML();

    public boolean insertProductIntoXML(
            String productID,
            String productName,
            String enterpriseID,
            String departmentID,
            String personID,
            String productGroups);

    public void insertProductIntoDatabasefromXML();

    public void deleteXMLFile();

    public void createXMLFile();
}

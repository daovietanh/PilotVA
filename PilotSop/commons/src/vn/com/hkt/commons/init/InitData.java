/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.commons.init;

import com.vn.hkt.core.Account;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import org.openide.util.Lookup;
import vn.com.hkt.commons.api.IBaseData;
import vn.com.hkt.pilot.entities.Department;
import vn.com.hkt.pilot.entities.Enterprise;
import vn.com.hkt.pilot.entities.Operation;
import vn.com.hkt.pilot.entities.Person;
import vn.com.hkt.pilot.entities.Product;

/**
 *
 * @author Admin
 */
public class InitData {

    private IBaseData data;
    private String fileExcel;

    public InitData() {
        this.data = Lookup.getDefault().lookup(IBaseData.class);
    }

    public void setPathFileExcel(String filePath) {
        this.fileExcel = filePath;
    }

    private List<String> readExcelColumn(String filePath, int indexSheet, int column, int start) {
        List<String> data = new ArrayList<String>();
        File file = new File(filePath);
        Workbook workbook = null;
        try {
            workbook = Workbook.getWorkbook(file);
            Sheet sheet = workbook.getSheet(indexSheet);
            String s;
            int i = start;
            while (true) {
                Cell cell = sheet.getCell(column, i);
                CellType cellType = cell.getType();
                s = cell.getContents();
                if (s == null) {
                    return data;
                }
                i++;
                data.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    private List<String> readExcelRow(String filePath, int indexSheet, int row, int start, int length) {
        List<String> data = new ArrayList<String>();
        File file = new File(filePath);
        Workbook workbook = null;
        try {
            workbook = Workbook.getWorkbook(file);
            Sheet sheet = workbook.getSheet(indexSheet);
            String s;
            for (int i = start; i < start + length; i++) {
                Cell cell = sheet.getCell(i, row);
                CellType cellType = cell.getType();
                s = cell.getContents();
                data.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    public void initAccount() {
        List<String> listUserName = readExcelColumn(fileExcel, 0, 0, 1);
        List<String> listPassword = readExcelColumn(fileExcel, 0, 1, 1);
        List<String> listPersonID = readExcelColumn(fileExcel, 0, 2, 1);
        List<String> listDepartmentID = readExcelColumn(fileExcel, 0, 3, 1);
        for (int i = 0; i < listUserName.size(); i++) {
            Account account = new Account();
            account.setUsername(listUserName.get(i));
            account.setPassword(listPassword.get(i));
            account.setPersonID(listPersonID.get(i));
            account.setDepartmentID(listDepartmentID.get(i));
            data.insertAccountIntoXML(account.getUsername(), account.getPassword(), account.getPersonID(), account.getDepartmentID());
            data.insertAccountIntoDatabasefromXML();
        }
    }

    public void initDepartment() {
        List<String> listDepartmentID = readExcelColumn(fileExcel, 1, 0, 1);
        List<String> listDepartmentName = readExcelColumn(fileExcel, 1, 1, 1);
        List<String> listEnterpriseID = readExcelColumn(fileExcel, 1, 2, 1);
        List<String> listPersonID = readExcelColumn(fileExcel, 1, 3, 1);
        List<String> listDepartmentParent = readExcelColumn(fileExcel, 1, 4, 1);
        for (int i = 0; i < listDepartmentID.size(); i++) {
            Department d = new Department();
            d.setDepartmentID(listDepartmentID.get(i));
            d.setDepartmentName(listDepartmentName.get(i));
            d.setEnterpriseID(listEnterpriseID.get(i));
            d.setPersonID(listPersonID.get(i));
            d.setDepartmentParent(listDepartmentParent.get(i));
            data.insertDepartmentIntoXML(d.getDepartmentID(), d.getDepartmentName(), d.getEnterpriseID(), d.getPersonID(), d.getDepartmentParent());
            data.insertDepartmentIntoDatabasefromXML();
        }
    }

    public void initEnterprise() {
        List<String> listEnterpriseID = readExcelColumn(fileExcel, 2, 0, 1);
        List<String> listEnterpriseName = readExcelColumn(fileExcel, 2, 1, 1);
        List<String> listEnterpriseParrent = readExcelColumn(fileExcel, 2, 2, 1);
        List<String> listDirector = readExcelColumn(fileExcel, 2, 3, 1);
        for (int i = 0; i < listEnterpriseID.size(); i++) {
            Enterprise e = new Enterprise();
            e.setEnterpriseID(listEnterpriseID.get(i));
            e.setEnterpriseName(listEnterpriseName.get(i));
            e.setEnterpriseParent(listEnterpriseParrent.get(i));
            e.setDirector(listDirector.get(i));
            data.insertEnterpriseIntoXML(e.getEnterpriseID(), e.getEnterpriseName(), e.getEnterpriseParent(), e.getDirector());
            data.insertEnterpriseIntoDatabasefromXML();
        }
    }

    public void initOperation() {
        List<String> listOperationID = readExcelColumn(fileExcel, 3, 0, 1);
        List<String> listOperationName = readExcelColumn(fileExcel, 3, 1, 1);
        List<String> listDateTime = readExcelColumn(fileExcel, 3, 2, 1);
        List<String> listProductID = readExcelColumn(fileExcel, 3, 3, 1);
        List<String> listEnterpriseID = readExcelColumn(fileExcel, 3, 4, 1);
        List<String> listDepartmentID = readExcelColumn(fileExcel, 3, 5, 1);
        List<String> listPersonID = readExcelColumn(fileExcel, 3, 6, 1);
        List<String> listClassification = readExcelColumn(fileExcel, 3, 7, 1);
        List<String> listNumber = readExcelColumn(fileExcel, 3, 8, 1);
        List<String> listUnitPrice = readExcelColumn(fileExcel, 3, 9, 1);
        List<String> listSumPrice = readExcelColumn(fileExcel, 3, 10, 1);
        for (int i = 0; i < listOperationID.size(); i++) {
            Operation opp = new Operation();
            opp.setOperationID(listOperationID.get(i));
            opp.setOperationName(listOperationName.get(i));
            opp.setDateTime(listDateTime.get(i));
            opp.setProductID(listProductID.get(i));
            opp.setEnterpriseID(listEnterpriseID.get(i));
            opp.setDepartmentID(listDepartmentID.get(i));
            opp.setPersonID(listPersonID.get(i));
            opp.setClassification(listClassification.get(i));
            opp.setNumber(Integer.parseInt(listNumber.get(i)));
            opp.setUnitPrice(Integer.parseInt(listUnitPrice.get(i)));
            opp.setSumPrice(Integer.parseInt(listSumPrice.get(i)));
            data.insertOperationIntoXML(
                    opp.getOperationID(),
                    opp.getOperationName(),
                    opp.getDateTime(),
                    opp.getProductID(),
                    opp.getEnterpriseID(),
                    opp.getDepartmentID(),
                    opp.getPersonID(),
                    opp.getClassification(),
                    opp.getNumber(),
                    opp.getUnitPrice(),
                    opp.getSumPrice());
            data.insertOperationIntoDatabasefromXML();
        }
    }

    public void initPerson() {
        List<String> listPersonID = readExcelColumn(fileExcel, 4, 0, 1);
        List<String> listFirstName = readExcelColumn(fileExcel, 4, 1, 1);
        List<String> listLastName = readExcelColumn(fileExcel, 4, 2, 1);
        List<String> listEnterpriseID = readExcelColumn(fileExcel, 4, 3, 1);
        List<String> listDepartmentName = readExcelColumn(fileExcel, 4, 4, 1);
        List<String> listPosition = readExcelColumn(fileExcel, 4, 5, 1);
        for (int i = 0; i < listPersonID.size(); i++) {
            Person p = new Person();
            p.setPersonID(listPersonID.get(i));
            p.setFirstName(listFirstName.get(i));
            p.setLastName(listLastName.get(i));
            p.setEnterpriseID(listEnterpriseID.get(i));
            p.setDepartmentName(listDepartmentName.get(i));
            p.setPosition(listPosition.get(i));
            data.insertPersonIntoXML(
                    p.getPersonID(),
                    p.getFirstName(),
                    p.getLastName(),
                    p.getEnterpriseID(),
                    p.getDepartmentName(),
                    p.getPosition());
            data.insertPersonIntoDatabasefromXML();
        }
    }

    public void initProduct() {
        List<String> listProductID = readExcelColumn(fileExcel, 5, 0, 1);
        List<String> listProductName = readExcelColumn(fileExcel, 5, 1, 1);
        List<String> listEnterpriseID = readExcelColumn(fileExcel, 5, 2, 1);
        List<String> listDepartmentID = readExcelColumn(fileExcel, 4, 2, 1);
        List<String> listPersonID = readExcelColumn(fileExcel, 4, 4, 1);
        List<String> listProductGroups = readExcelColumn(fileExcel, 4, 5, 1);
        for (int i = 0; i < listProductID.size(); i++) {
            Product p = new Product();
            p.setProductID(listProductID.get(i));
            p.setProductName(listProductName.get(i));
            p.setEnterpriseID(listEnterpriseID.get(i));
            p.setDepartmentID(listDepartmentID.get(i));
            p.setPersonID(listPersonID.get(i));
            p.setProductgroups(listProductGroups.get(i));
            data.insertProductIntoXML(
                    p.getProductID(),
                    p.getProductName(),
                    p.getEnterpriseID(),
                    p.getDepartmentID(),
                    p.getPersonID(),
                    p.getProductgroups());
            data.insertProductIntoDatabasefromXML();
        }
    }
}

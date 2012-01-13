/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.commons.spi;

import com.vn.hkt.core.Account;
import com.vn.hkt.generic.api.IGenericAPI;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.openide.util.Lookup;
import org.openide.util.lookup.ServiceProvider;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import vn.com.hkt.commons.api.IBaseData;
import vn.com.hkt.pilot.entities.Department;
import vn.com.hkt.pilot.entities.Enterprise;
import vn.com.hkt.pilot.entities.Operation;
import vn.com.hkt.pilot.entities.Person;
import vn.com.hkt.pilot.entities.Product;

/**
 *
 * @author home
 */
@ServiceProvider(service = IBaseData.class)
public class CreateBaseData implements IBaseData {

    DateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ssSSS");
    Calendar c = Calendar.getInstance();
    String filename = "DataInit" + dateFormat.format(c.getTime()) + ".xml";
    File file = new File(filename);
    private IGenericAPI aPI;

    public CreateBaseData() {
        this.aPI = Lookup.getDefault().lookup(IGenericAPI.class);
    }

    @Override
    public boolean insertAccountIntoXML(String username, String password, String personID, String departmentID) {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document document = builder.parse(file);
            Element account = document.createElement("Account");
            Element user = document.createElement("UserName");
            user.setTextContent(username);
            Element pass = document.createElement("Password");
            pass.setTextContent(password);
            Element pID = document.createElement("PersonID");
            pID.setTextContent(personID);
            Element dID = document.createElement("DepartmentID");
            dID.setTextContent(departmentID);

            account.appendChild(user);
            account.appendChild(pass);
            account.appendChild(pID);
            account.appendChild(dID);
            Element root = document.getDocumentElement();
            root.appendChild(account);

            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            transformer.transform(new DOMSource(document), new StreamResult(file));
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public void insertAccountIntoDatabasefromXML() {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document document = builder.parse(file);
            NodeList nodeList = document.getElementsByTagName("Account");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                NodeList childNodes = node.getChildNodes();
                Node user = childNodes.item(1);
                Node pass = childNodes.item(3);
                Node pID = childNodes.item(5);
                Node dID = childNodes.item(7);
                Account a = new Account();
                a.setUsername(user.getTextContent());
                a.setPassword(pass.getTextContent());
                a.setPersonID(pID.getTextContent());
                a.setDepartmentID(dID.getTextContent());
                aPI.insertData(a);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public boolean insertDepartmentIntoXML(
            String departmentID,
            String departmentName,
            String enterpriseID,
            String personID,
            String departmentParent) {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document document = builder.parse(file);
            Element department = document.createElement("Department");
            Element dID = document.createElement("DepartmentID");
            dID.setTextContent(departmentID);
            Element dName = document.createElement("DepartmentName");
            dName.setTextContent(departmentName);
            Element eID = document.createElement("EnterpriseID");
            eID.setTextContent(enterpriseID);
            Element pID = document.createElement("PersonID");
            pID.setTextContent(personID);
            Element dParrent = document.createElement("DepartmentParent");
            dParrent.setTextContent(departmentParent);

            department.appendChild(dID);
            department.appendChild(dName);
            department.appendChild(eID);
            department.appendChild(pID);
            department.appendChild(dParrent);
            Element root = document.getDocumentElement();
            root.appendChild(department);

            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            transformer.transform(new DOMSource(document), new StreamResult(file));
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public void insertDepartmentIntoDatabasefromXML() {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document document = builder.parse(file);
            NodeList nodeList = document.getElementsByTagName("Department");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                NodeList childNodes = node.getChildNodes();
                Node dID = childNodes.item(1);
                Node dName = childNodes.item(3);
                Node eID = childNodes.item(5);
                Node pID = childNodes.item(7);
                Node dParrent = childNodes.item(9);
                Department d = new Department();
                d.setDepartmentID(dID.getTextContent());
                d.setDepartmentName(dName.getTextContent());
                d.setEnterpriseID(eID.getTextContent());
                d.setPersonID(pID.getTextContent());
                d.setDepartmentParent(dParrent.getTextContent());
                aPI.insertData(d);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public boolean insertEnterpriseIntoXML(
            String enterpriseID,
            String enterpriseName,
            String enterpriseParrent,
            String director) {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document document = builder.parse(file);
            Element enterprise = document.createElement("Enterprise");
            Element eID = document.createElement("EnterpriseID");
            eID.setTextContent(enterpriseID);
            Element eName = document.createElement("EnterpriseName");
            eName.setTextContent(enterpriseName);
            Element eParrent = document.createElement("EnterpriseParrent");
            eParrent.setTextContent(enterpriseParrent);
            Element boss = document.createElement("Director");
            boss.setTextContent(director);

            enterprise.appendChild(eID);
            enterprise.appendChild(eName);
            enterprise.appendChild(eParrent);
            enterprise.appendChild(boss);
            Element root = document.getDocumentElement();
            root.appendChild(enterprise);

            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            transformer.transform(new DOMSource(document), new StreamResult(file));
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public void insertEnterpriseIntoDatabasefromXML() {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document document = builder.parse(file);
            NodeList nodeList = document.getElementsByTagName("Enterprise");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                NodeList childNodes = node.getChildNodes();
                Node eID = childNodes.item(1);
                Node eName = childNodes.item(3);
                Node eParrent = childNodes.item(5);
                Node director = childNodes.item(7);
                Enterprise e = new Enterprise();
                e.setEnterpriseID(eID.getTextContent());
                e.setEnterpriseName(eName.getTextContent());
                e.setEnterpriseParent(eParrent.getTextContent());
                e.setDirector(director.getTextContent());
                aPI.insertData(e);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
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
            int sumPrice) {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document document = builder.parse(file);
            Element operation = document.createElement("Operation");
            Element oID = document.createElement("OperationID");
            oID.setTextContent(operationID);
            Element oName = document.createElement("OperationName");
            oName.setTextContent(operationName);
            Element dt = document.createElement("DateTime");
            dt.setTextContent(datetime);
            Element proID = document.createElement("ProductID");
            proID.setTextContent(productID);
            Element eID = document.createElement("EnterpriseID");
            eID.setTextContent(enterpriseID);
            Element dID = document.createElement("DepartmentID");
            dID.setTextContent(departmentID);
            Element perID = document.createElement("PersonID");
            perID.setTextContent(personID);
            Element clsf = document.createElement("Classification");
            clsf.setTextContent(classification);
            Element num = document.createElement("Number");
            num.setTextContent(Integer.toString(number));
            Element uPrice = document.createElement("UnitPrice");
            uPrice.setTextContent(Integer.toString(unitPrice));
            Element sPrice = document.createElement("SumPrice");
            sPrice.setTextContent(Integer.toString(sumPrice));

            operation.appendChild(oID);
            operation.appendChild(oName);
            operation.appendChild(dt);
            operation.appendChild(proID);
            operation.appendChild(eID);
            operation.appendChild(dID);
            operation.appendChild(perID);
            operation.appendChild(clsf);
            operation.appendChild(num);
            operation.appendChild(uPrice);
            operation.appendChild(sPrice);
            Element root = document.getDocumentElement();
            root.appendChild(operation);

            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            transformer.transform(new DOMSource(document), new StreamResult(file));
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public void insertOperationIntoDatabasefromXML() {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document document = builder.parse(file);
            NodeList nodeList = document.getElementsByTagName("Operation");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                NodeList childNodes = node.getChildNodes();
                Node operationID = childNodes.item(1);
                Node operationName = childNodes.item(3);
                Node datetime = childNodes.item(5);
                Node productID = childNodes.item(7);
                Node enterpriseID = childNodes.item(9);
                Node departmentID = childNodes.item(11);
                Node personID = childNodes.item(13);
                Node classification = childNodes.item(15);
                Node number = childNodes.item(17);
                Node unitPrice = childNodes.item(19);
                Node sumPrice = childNodes.item(21);
                Operation op = new Operation();
                op.setOperationID(operationID.getTextContent());
                op.setOperationName(operationName.getTextContent());
                op.setDateTime(datetime.getTextContent());
                op.setProductID(productID.getTextContent());
                op.setEnterpriseID(enterpriseID.getTextContent());
                op.setDepartmentID(departmentID.getTextContent());
                op.setPersonID(personID.getTextContent());
                op.setClassification(classification.getTextContent());
                op.setNumber(Integer.parseInt(number.getTextContent()));
                op.setUnitPrice(Integer.parseInt(unitPrice.getTextContent()));
                op.setSumPrice(Integer.parseInt(sumPrice.getTextContent()));
                aPI.insertData(op);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public boolean insertPersonIntoXML(
            String personID,
            String firstname,
            String lastname,
            String enterpriseID,
            String departmentName,
            String position) {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document document = builder.parse(file);
            Element person = document.createElement("Person");
            Element perID = document.createElement("PersonID");
            perID.setTextContent(personID);
            Element fname = document.createElement("FirstName");
            fname.setTextContent(firstname);
            Element lname = document.createElement("LastName");
            lname.setTextContent(lastname);
            Element eID = document.createElement("EnterpriseID");
            eID.setTextContent(enterpriseID);
            Element dName = document.createElement("DepartmentName");
            dName.setTextContent(departmentName);
            Element pos = document.createElement("Position");
            pos.setTextContent(position);

            person.appendChild(perID);
            person.appendChild(fname);
            person.appendChild(lname);
            person.appendChild(eID);
            person.appendChild(dName);
            person.appendChild(pos);
            Element root = document.getDocumentElement();
            root.appendChild(person);

            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            transformer.transform(new DOMSource(document), new StreamResult(file));
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public void insertPersonIntoDatabasefromXML() {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document document = builder.parse(file);
            NodeList nodeList = document.getElementsByTagName("Person");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                NodeList childNodes = node.getChildNodes();
                Node personID = childNodes.item(1);
                Node firstname = childNodes.item(3);
                Node lastname = childNodes.item(5);
                Node enterpriseID = childNodes.item(7);
                Node departmentName = childNodes.item(9);
                Node position = childNodes.item(11);
                Person p = new Person();
                p.setPersonID(personID.getTextContent());
                p.setFirstName(firstname.getTextContent());
                p.setLastName(lastname.getTextContent());
                p.setEnterpriseID(enterpriseID.getTextContent());
                p.setDepartmentName(departmentName.getTextContent());
                p.setPosition(position.getTextContent());
                aPI.insertData(p);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public boolean insertProductIntoXML(
            String productID,
            String productName,
            String enterpriseID,
            String departmentID,
            String personID,
            String productGroups) {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document document = builder.parse(file);
            Element product = document.createElement("Product");
            Element proID = document.createElement("ProductID");
            proID.setTextContent(productID);
            Element proName = document.createElement("ProductName");
            proName.setTextContent(productName);
            Element eID = document.createElement("EnterpriseID");
            eID.setTextContent(enterpriseID);
            Element dID = document.createElement("DepartmentID");
            dID.setTextContent(departmentID);
            Element perID = document.createElement("PersonID");
            perID.setTextContent(enterpriseID);
            Element proGroup = document.createElement("ProductGroups");
            proGroup.setTextContent(productGroups);

            product.appendChild(proID);
            product.appendChild(proName);
            product.appendChild(eID);
            product.appendChild(dID);
            product.appendChild(perID);
            product.appendChild(proGroup);
            Element root = document.getDocumentElement();
            root.appendChild(product);

            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            transformer.transform(new DOMSource(document), new StreamResult(file));
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public void insertProductIntoDatabasefromXML() {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document document = builder.parse(file);
            NodeList nodeList = document.getElementsByTagName("Product");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                NodeList childNodes = node.getChildNodes();
                Node productID = childNodes.item(1);
                Node productName = childNodes.item(3);
                Node enterpriseID = childNodes.item(5);
                Node departmentID = childNodes.item(7);
                Node personID = childNodes.item(9);
                Node productGroups = childNodes.item(11);
                Product p = new Product();
                p.setProductID(productID.getTextContent());
                p.setProductName(productName.getTextContent());
                p.setEnterpriseID(enterpriseID.getTextContent());
                p.setDepartmentID(departmentID.getTextContent());
                p.setPersonID(personID.getTextContent());
                p.setProductgroups(productGroups.getTextContent());
                aPI.insertData(p);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteXMLFile() {
        file.delete();
    }

    @Override
    public void createXMLFile() {
        try {
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
            writer.write("\n");
            writer.write("<root>");
            writer.write("</root>");
            writer.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.hrm.person.dao;

import vn.com.hkt.pilot.entities.Department;
import vn.com.hkt.pilot.entities.Enterprise;
import vn.com.hkt.pilot.entities.Person;
import com.vn.hkt.generic.api.IGenericAPI;
import java.util.ArrayList;
import java.util.List;
import org.openide.util.Lookup;
import org.openide.util.lookup.ServiceProvider;
import vn.com.hkt.basic.api.IPersonBN;

/**
 *
 * @author khanguct
 */
@ServiceProvider(service=IPersonBN.class)
public class PersonBN implements IPersonBN{
    
    private IGenericAPI mydao;

    public PersonBN() {
        
        mydao = Lookup.getDefault().lookup(IGenericAPI.class);
    }

    @Override
    public boolean insertPerson(Person person) {
       if (mydao.insertData(person)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean updatePerson(Person person) {
       if(mydao.updateData(person)){
           return true;
       }
       return false;
    }

    @Override
    public boolean deletePerson(Person person) {
          if (mydao.deleteData(Person.class, person.getPersonID())) {
            return true;
        }
        return false;
    }

    @Override
    public List<Person> getAllPerson() {
        List<Person> list = new ArrayList<Person>();
        List<Object> obs = new ArrayList<Object>();
        obs = mydao.getAllData(Person.class);
        if(!obs.isEmpty()){
            int i;
            for(i=0;i<obs.size();i++){
                 list.add( (Person)obs.get(i));                              
            }
        }
        return list;
    }

    @Override
    public Person getPersonByID(String id) {
        return (Person) mydao.getByID(Person.class, id);
    }

    @Override
    public List<Person> filterPersonByID(String id) {
         List<Object> list = new ArrayList<Object>();
        List<Person> result = new ArrayList<Person>();
        list = mydao.filterByCondition(Person.class, "PersonID", id);
        if (!list.isEmpty()) {
            int i;
            for (i = 0; i < list.size(); i++) {
                result.add((Person) list.get(i));
            }
        }
        return result;
    }

    @Override
    public List<Person> filterPersonByName(String name) {
         List<Object> list = new ArrayList<Object>();
        List<Person> result = new ArrayList<Person>();
        list = mydao.filterByCondition(Person.class, "FirstName", name);
        if (!list.isEmpty()) {
            int i;
            for (i = 0; i < list.size(); i++) {
                result.add((Person) list.get(i));
            }
        }
        return result;
    }

    @Override
    public List<Person> filterPersonByLastName(String name) {
           List<Object> list = new ArrayList<Object>();
        List<Person> result = new ArrayList<Person>();
        list = mydao.filterByCondition(Person.class, "LastName", name);
        if (!list.isEmpty()) {
            int i;
            for (i = 0; i < list.size(); i++) {
                result.add((Person) list.get(i));
            }
        }
        return result;
    }

    @Override
    public List<Person> filterPersonByEnterprise(Enterprise enterprise) {
        List<Person> list = new ArrayList<Person>();
        List<Person> list1 = new ArrayList<Person>();
        list1 = getAllPerson();
        if(!list1.isEmpty()){
            for(Person bean : list1){
                if(bean.getEnterpriseID().equals(enterprise.getEnterpriseID())){
                    list.add(bean);
                }
            }
        }
        return list;
    }

    @Override
    public List<Person> filterPersonByDepartment(Enterprise enterprise, Department department) {
        List<Person> list = new ArrayList<Person>();
        List<Person> list1 = new ArrayList<Person>();
        list1 = filterPersonByEnterprise(enterprise);
        if(!list1.isEmpty()){
            for(Person bean : list1){
                if(bean.getDepartmentName().equals(department.getDepartmentName())){
                    list.add(bean);
                }
            }
        }
        return list;
    }
    
}

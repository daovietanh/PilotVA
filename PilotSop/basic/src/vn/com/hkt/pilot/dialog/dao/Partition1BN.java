/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.pilot.dialog.dao;

import com.vn.hkt.generic.api.IGenericAPI;
import java.util.ArrayList;
import java.util.List;
import org.openide.util.Lookup;
import org.openide.util.lookup.ServiceProvider;
import vn.com.hkt.pilot.dialog.api.IPartition1BN;
import vn.com.hkt.pilot.entities.Country;
import vn.com.hkt.pilot.entities.Enterprise;
import vn.com.hkt.pilot.entities.Partition1;

/**
 *
 * @author duong
 */
@ServiceProvider(service = IPartition1BN.class)
public class Partition1BN implements IPartition1BN {

    private IGenericAPI mydao;

    public Partition1BN() {

        mydao = Lookup.getDefault().lookup(IGenericAPI.class);

    }

    @Override
    public boolean insertPartition1(Partition1 partition1) {
        if (mydao.insertData(partition1)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean updatePartition1(Partition1 partition1) {
        if (mydao.updateData(partition1)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean deletePartition1(Partition1 partition1) {
        if (mydao.deleteData(Partition1.class, partition1.getIdPartition1())) {
            return true;
        }
        return false;

    }

    @Override
    public List<Partition1> getAllPartition1() {
        List<Partition1> list = new ArrayList<Partition1>();
        List<Object> obs = new ArrayList<Object>();
        obs = mydao.getAllData(Partition1.class);
        if (!obs.isEmpty()) {
            int i;
            for (i = 0; i < obs.size(); i++) {
                list.add((Partition1) obs.get(i));
            }
        }
        return list;
    }

    @Override
    public Partition1 getPartition1ID(String id) {
        return (Partition1) mydao.getByID(Partition1.class, id);
    }

    @Override
    public List<Partition1> filterPartition1ByID(String id) {
        List<Partition1> result = new ArrayList<Partition1>();
        List<Object> list = new ArrayList<Object>();
        list = mydao.filterByCondition(Enterprise.class, "idPartition1", id);
        if (!list.isEmpty()) {
            int i;
            for (i = 0; i < list.size(); i++) {
                result.add((Partition1) list.get(i));
            }
        }
        return result;
    }

    @Override
    public List<Partition1> filterPartition1ByName(String name) {
        List<Partition1> result = new ArrayList<Partition1>();
        List<Object> list = new ArrayList<Object>();
        list = mydao.filterByCondition(Enterprise.class, "namePartition1", name);
        if (!list.isEmpty()) {
            int i;
            for (i = 0; i < list.size(); i++) {
                result.add((Partition1) list.get(i));
            }
        }
        return result;
    }
//Lấy tên vùng theo tên quốc gia

    @Override
    public List<Partition1> getPartition1ByCountry(Country country) {
        List<Partition1> list = new ArrayList<Partition1>();
        List<Partition1> list1 = mydao.getAllData(Partition1.class);
        if (!list1.isEmpty()) {
            for (Partition1 bean : list1) {
                if (bean.getIdCountry().equals(country.getIdCountry())) {
                    list.add(bean);
                }
            }
        }
        return list;
    }
}

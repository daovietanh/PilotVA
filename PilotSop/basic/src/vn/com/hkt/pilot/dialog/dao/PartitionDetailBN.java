/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.pilot.dialog.dao;

import com.vn.hkt.generic.api.IGenericAPI;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import org.openide.util.Lookup;
import org.openide.util.lookup.ServiceProvider;
import vn.com.hkt.pilot.dialog.api.IPartitionDetail;
import vn.com.hkt.pilot.entities.Partition1;
import vn.com.hkt.pilot.entities.PartitionDetail;

/**
 *
 * @author duong
 */
@ServiceProvider(service = IPartitionDetail.class)
public class PartitionDetailBN implements IPartitionDetail {

    private IGenericAPI mydao;

    public PartitionDetailBN() {

        mydao = Lookup.getDefault().lookup(IGenericAPI.class);

    }

    @Override
    public boolean insertPartitionDetail(PartitionDetail partitionDetail) {
        if (mydao.insertData(partitionDetail)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean updatePartitionDetail(PartitionDetail partitionDetail) {
        if (mydao.updateData(partitionDetail)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean deletePartitionDetail(PartitionDetail partitionDetail) {
        if (mydao.deleteData(PartitionDetail.class, partitionDetail.getIdPartitionDetail())) {
            return true;
        }
        return false;

    }

    @Override
    public List<PartitionDetail> getAllPartitionDetail() {
        List<PartitionDetail> list = new ArrayList<PartitionDetail>();
        List<Object> obs = new ArrayList<Object>();
        obs = mydao.getAllData(PartitionDetail.class);
        if (!obs.isEmpty()) {
            int i;
            for (i = 0; i < obs.size(); i++) {
                list.add((PartitionDetail) obs.get(i));
            }
        }
        return list;
    }

    @Override
    public PartitionDetail getPartitionDetailID(String id) {
         return (PartitionDetail) mydao.getByID(PartitionDetail.class, id);
    }

    @Override
    public List<PartitionDetail> filterPartitionDetailByID(String id) {
       List<PartitionDetail> list = new ArrayList<PartitionDetail>();
        List<Object> obs = new ArrayList<Object>();
        obs = mydao.filterByCondition(PartitionDetail.class,"idPartitionDetail", id);
        if (!obs.isEmpty()) {
            int i;
            for (i = 0; i < obs.size(); i++) {
                list.add((PartitionDetail) obs.get(i));
            }
        }
        return list;
    }

    @Override
    public List<PartitionDetail> filterPartitionDetailByName(String name) {
       List<PartitionDetail> list = new ArrayList<PartitionDetail>();
        List<Object> obs = new ArrayList<Object>();
        obs = mydao.filterByCondition(PartitionDetail.class,"namePartitionDetail", name);
        if (!obs.isEmpty()) {
            int i;
            for (i = 0; i < obs.size(); i++) {
                list.add((PartitionDetail) obs.get(i));
            }
        }
        return list;
    }
//Lấy danh sách vùng 2 theo vùng 1
    @Override
    public List<PartitionDetail> getPartitionDetailByPartition(Partition1 partition1) {
        List<PartitionDetail> list = new ArrayList<PartitionDetail>();
         List<PartitionDetail> list1 = mydao.getAllData(PartitionDetail.class);
          if (!list1.isEmpty()) {
            for (PartitionDetail bean : list1) {
                if (bean.getIdPartition1().equals(partition1.getIdPartition1())) {
                    list.add(bean);
                }
            }
        }
         return list;
    }
}

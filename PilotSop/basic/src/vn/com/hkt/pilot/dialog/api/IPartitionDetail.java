/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.pilot.dialog.api;

import java.util.List;
import vn.com.hkt.pilot.entities.Partition1;
import vn.com.hkt.pilot.entities.PartitionDetail;

/**
 *
 * @author duong
 */
public interface IPartitionDetail {

    public boolean insertPartitionDetail(PartitionDetail partitionDetail);

    public boolean updatePartitionDetail(PartitionDetail partitionDetail);

    public boolean deletePartitionDetail(PartitionDetail partitionDetail);

    public List<PartitionDetail> getAllPartitionDetail();

    public PartitionDetail getPartitionDetailID(String id);

    public List<PartitionDetail> filterPartitionDetailByID(String id);

    public List<PartitionDetail> filterPartitionDetailByName(String name);
    
      public List<PartitionDetail> getPartitionDetailByPartition(Partition1 partition1);
}

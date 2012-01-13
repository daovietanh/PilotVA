/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.pilot.dialog.api;

import java.util.List;
import vn.com.hkt.pilot.entities.Country;
import vn.com.hkt.pilot.entities.Partition1;

/**
 *
 * @author duong
 */
public interface IPartition1BN {

    public boolean insertPartition1(Partition1 partition1);

    public boolean updatePartition1(Partition1 partition1);

    public boolean deletePartition1(Partition1 partition1);

    public List<Partition1> getAllPartition1();

    public Partition1 getPartition1ID(String id);

    public List<Partition1> filterPartition1ByID(String id);

    public List<Partition1> filterPartition1ByName(String name);
    
     public List<Partition1> getPartition1ByCountry(Country country);
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.basic.api;

import vn.com.hkt.pilot.entities.Enterprise;
import java.util.List;

/**
 *
 * @author khanguct
 */
public interface IEnterpriseBN {

    public boolean insertEnterprise(Enterprise enterprise);

    public boolean updateEnterprise(Enterprise enterprise);

    public boolean deleteEnterprise(Enterprise enterprise);

    public List<Enterprise> getAllEnterprise();

    public Enterprise getEnterpriseByID(String id);

    public List<Enterprise> filterEnterpriseByID(String id);

    public List<Enterprise> filterEnterpriseByName(String name);
    
    public List<Enterprise> filterEnterpriseByChild(Enterprise enterprise);
}

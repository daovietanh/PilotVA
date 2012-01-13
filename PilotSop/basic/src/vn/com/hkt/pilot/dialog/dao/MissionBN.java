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
import vn.com.hkt.pilot.dialog.api.IMission;
import vn.com.hkt.pilot.entities.Mission;

/**
 *
 * @author khanguct
 */
@ServiceProvider(service=IMission.class)
public class MissionBN implements IMission{

    private IGenericAPI mydao;

    public MissionBN() {
        mydao = Lookup.getDefault().lookup(IGenericAPI.class);
    }
    
    
    
    @Override
    public boolean insertMission(Mission mission) {
        if (mydao.insertData(mission)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean updateMission(Mission mission) {
        if (mydao.updateData(mission)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteMission(Mission mission) {
         if (mydao.deleteData(Mission.class, mission.getMissionID())) {
            return true;
        }
        return false;
    }

    @Override
    public List<Mission> getAllMission() {
        List<Mission> list = new ArrayList<Mission>();
        List<Object> obs = new ArrayList<Object>();
        obs = mydao.getAllData(Mission.class);
        if (!obs.isEmpty()) {
            int i;
            for (i = 0; i < obs.size(); i++) {
                list.add((Mission) obs.get(i));
            }
        }
        return list;
    }

    @Override
    public Mission getMissionById(String id) {
        return (Mission) mydao.getByID(Mission.class, id);
    }

    @Override
    public List<Mission> filterMissionByID(String id) {
        List<Object> list = new ArrayList<Object>();
        List<Mission> result = new ArrayList<Mission>();
        list = mydao.filterByCondition(Mission.class, "missionID", id);
        if (!list.isEmpty()) {
            int i;
            for (i = 0; i < list.size(); i++) {
                result.add((Mission) list.get(i));
            }
        }
        return result;
    }

    @Override
    public List<Mission> filterMissionByName(String name) {
        List<Object> list = new ArrayList<Object>();
        List<Mission> result = new ArrayList<Mission>();
        list = mydao.filterByCondition(Mission.class, "missionName", name);
        if (!list.isEmpty()) {
            int i;
            for (i = 0; i < list.size(); i++) {
                result.add((Mission) list.get(i));
            }
        }
        return result;
    }
    
}

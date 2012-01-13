/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.pilot.dialog.api;

import java.util.List;
import vn.com.hkt.pilot.entities.Mission;

/**
 *
 * @author khanguct
 */
public interface IMission {
    public boolean insertMission(Mission mission);//thêm một chức vụ

    public boolean updateMission(Mission mission);// chỉnh sửa chức vụ

    public boolean deleteMission(Mission mission);// xóa 1 chức vụ     

    public List<Mission> getAllMission();// lấy tất cả chức vụ

    public Mission getMissionById(String id);// lấy chức vụ theo id
 
    public List<Mission> filterMissionByID(String id);

    public List<Mission> filterMissionByName(String name);  
}

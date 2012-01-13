/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.pilot.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author khanguct
 */
@Entity
public class Mission {
    @Id
    private String missionID; // Mã chức vụ
    private String missionName; // Tên chức vụ

    public Mission() {
    }

    public Mission(String missionID, String missionName) {
        this.missionID = missionID;
        this.missionName = missionName;
    }

    public String getMissionID() {
        return missionID;
    }

    public void setMissionID(String missionID) {
        this.missionID = missionID;
    }

    public String getMissionName() {
        return missionName;
    }

    public void setMissionName(String missionName) {
        this.missionName = missionName;
    }

    
    @Override
    public String toString() {
        return missionName;
    }
    
}

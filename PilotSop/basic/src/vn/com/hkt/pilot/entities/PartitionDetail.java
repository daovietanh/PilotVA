/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.pilot.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author duong
 */
@Entity
public class PartitionDetail {

    @Id
    private String idPartitionDetail; // mã vùng chi tiet 
    private String namePartionDetail;    //tên vùng chi tiet
    private String idPartition1; //Mã quốc gia

    /**
     * @return the idPartitionDetail
     */
    public String getIdPartitionDetail() {
        return idPartitionDetail;
    }

    /**
     * @param idPartitionDetail the idPartitionDetail to set
     */
    public void setIdPartitionDetail(String idPartitionDetail) {
        this.idPartitionDetail = idPartitionDetail;
    }

    /**
     * @return the namePartionDetail
     */
    public String getNamePartionDetail() {
        return namePartionDetail;
    }

    /**
     * @param namePartionDetail the namePartionDetail to set
     */
    public void setNamePartionDetail(String namePartionDetail) {
        this.namePartionDetail = namePartionDetail;
    }

    /**
     * @return the idPartition
     */
    public String getIdPartition1() {
        return idPartition1;
    }

    /**
     * @param idPartition the idPartition to set
     */
    public void setIdPartition1(String idPartition1) {
        this.idPartition1 = idPartition1;
    }

    public PartitionDetail(String idPartitionDetail, String namePartionDetail, String idPartition1) {
        this.idPartitionDetail = idPartitionDetail;
        this.namePartionDetail = namePartionDetail;
        this.idPartition1 = idPartition1;
    }
     public PartitionDetail(){
         super();
     }

    @Override
    public String toString() {
        return namePartionDetail;
    }
     
}

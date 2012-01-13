/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.pilot.dialog.api;

import java.util.List;
import vn.com.hkt.pilot.entities.City;
import vn.com.hkt.pilot.entities.PartitionDetail;

/**
 *
 * @author duong
 */
public interface ICityBN {

    public boolean insertCity(City city);//thêm một thành phố

    public boolean updateCity(City city);// chỉnh sửa thành phố

    public boolean deleteCity(City city);// xóa 1 thành phố       

    public List<City> getAllCity();// lấy tất cả thành phố

    public City getCityById(String id);// lấy thành phố thep mã id
 
    public List<City> filterCityByID(String id);

    public List<City> filterCityByName(String name);   
    
     public City getCityByPartitionDetail(PartitionDetail partitionDetail);
}

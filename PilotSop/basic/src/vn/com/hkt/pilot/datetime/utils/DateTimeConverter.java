/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.pilot.datetime.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author khanguct
 */
public class DateTimeConverter {

    private Calendar calendar;
    private DateFormat dateFormat;
    private Date date = null;

    protected void setup(String dateConvert) {
        dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            date = (Date) dateFormat.parse(dateConvert);
        } catch (ParseException e) {
        }
        calendar = Calendar.getInstance();
        calendar.setTime(date);
    }

    public DateTimeConverter() {
    }

    public DateTimeConverter(Calendar calendar, DateFormat dateFormat) {
        this.calendar = calendar;
        this.dateFormat = dateFormat;
    }
    
    public int getDay(String date){
        int day = 0;
        setup(date);
        day = calendar.get(Calendar.DATE);
        return day;
    }
    
    public int getMonth(String date){
        int m = 0;
        setup(date);
        m = calendar.get(Calendar.MONTH);
        return m;
    }
    
    public int getYear(String date){
        int y = 0;
        setup(date);
        y = calendar.get(Calendar.YEAR);
        return y;
    }
    
    /**
     * Tổng số tuần trong 1 năm
     * Nhập vào dd/MM/yyyy
     * @param date
     * @return 
     */
    public int getTotalWeekOfYear(String date) {
        int week = 0;
        setup(date);
        week = calendar.getActualMaximum((Calendar.WEEK_OF_YEAR));
        return week;
    }
    
    /**
     * Tong so tuan trong thang
     * nhap vao dd/MM/yyyy
     * @param date
     * @return 
     */
    public int getTotalWeekOfMonth(String date){
        int week = 0;
        setup(date);
        week = calendar.getActualMaximum(Calendar.WEEK_OF_MONTH);
        return week;
    }
    
    /**
     * Tuan thu may trong thang
     * nhap vao dd/MM/yyyy
     * @param date
     * @return 
     */
    public int getWeekOfMonth(String date){
        int week = 0;
        setup(date);
        week = calendar.get(Calendar.WEEK_OF_MONTH);
        return week;
    }

    /**
     * Tuan thu may trong nam
     * nhap vao dd/MM/yyyy
     * @param date
     * @return 
     */
    public int getWeekOfYear(String date) {
        int week = 0;
        setup(date);
        week = calendar.get((Calendar.WEEK_OF_YEAR));
        return week;
    }
    
    /**
     * Tong so ngay trong nam
     * nhap vao dd/MM/yyyy
     * @param date
     * @return 
     */
    public int getTotalDayOfYear(String date) {
        int days = 0;
        setup(date);
        days = calendar.getActualMaximum((Calendar.DAY_OF_YEAR));
        return days;
    }
    
    /**
     * Tong so ngay trong thang
     * nhap vao dd/MM/yyyy
     * @param date
     * @return 
     */
    public int getTotalDayOfMonth(String date) {
        int days = 0;
        setup(date);
        days = calendar.getActualMaximum((Calendar.DAY_OF_MONTH));
        return days;
    }
    
    
}

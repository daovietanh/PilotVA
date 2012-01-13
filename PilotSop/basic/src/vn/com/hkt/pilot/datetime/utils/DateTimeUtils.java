/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.pilot.datetime.utils;

import java.util.Calendar;

/**
 *
 * @author khanguct
 */
public class DateTimeUtils {

    public DateTimeUtils() {
    }

    public DateTimeUtils(Calendar calendar) {
        this.calendar = calendar;
    }
    
    private Calendar calendar;
    
    public int getCurrentYear(){
        int y = 0;
        this.calendar = Calendar.getInstance();
        y = calendar.get(Calendar.YEAR);
        return y;
    }
    
    public int getCurrentMonth(){
        int m = 0;
        this.calendar = Calendar.getInstance();
        m = calendar.get(Calendar.MONTH) + 1;
        return m;
    }
    
    public int getCurrentDay(){
        int d = 0;
        this.calendar = Calendar.getInstance();
        d = calendar.get(Calendar.DATE);
        return d;
    }
    
    public String getCurrentDate(){
        String date = "";
        this.calendar = Calendar.getInstance();
        date = String.valueOf(calendar.get(Calendar.DATE)) + "/" + String.valueOf(getCurrentMonth()) + 
                "/" + String.valueOf(getCurrentYear());
        return date;
    }
    
    /**
     * Tổng số tuần trong năm của hệ thống
     * @return 
     */
    public int getTotalWeekOfYear() {
        int week = 0;
        calendar = Calendar.getInstance();
        week = calendar.getActualMaximum((Calendar.WEEK_OF_YEAR));
        return week;
    }
    
    /**
     * Tổng số tuần trong tháng của hệ thống
     * @return 
     */
    public int getTotalWeekOfMonth(){
        int week = 0;
        calendar = Calendar.getInstance();
        week = calendar.getActualMaximum((Calendar.WEEK_OF_MONTH));
        return week;
    }
    
    /**
     * Tổng số ngày trong tháng của hệ thống
     * @return 
     */
    public int getTotalDayOfMonth(){
        int day = 0;
        calendar = Calendar.getInstance();
        day = calendar.getActualMaximum((Calendar.DAY_OF_MONTH));
        return day;
    }
    
    /**
     * Tang, giam thang hien tai i don vi
     * @param i
     * @return 
     */
    public int addMonth(int i){
        int m = 0;
        calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, i);
        m = calendar.get(Calendar.MONTH) + 1;
        return m;
    }
    
    /**
     * Tang, giam nam hien tai i don vi
     * @param i
     * @return 
     */
    public int addYear(int i){
        int y = 0;
        calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, i);
        y = calendar.get(Calendar.YEAR);
        return y;
    }
    
    /**
     * Tang, giam nam hien tai theo thang
     * @param i
     * @return 
     */
    public int addYearWithMonth(int i){
        int y = 0;
        calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, i);
        y = calendar.get(Calendar.YEAR);
        return y;
    }
    
    public int getPreYear(){
        int y = 0;
        this.calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, -1);
        y = calendar.get(Calendar.YEAR);
        return y;
    }
    
}

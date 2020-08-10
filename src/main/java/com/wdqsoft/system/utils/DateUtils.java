package com.wdqsoft.system.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    /**
     *  比较过去某个时间与当前相差多少
     * @param bgtime
     * @return
     *  -1 超过三十分钟 ，-2  异常
     * @throws ParseException
     */
    public static String dateToStamp(String bgtime)  {
        try {
            long nd = 1000 * 24 * 60 * 60;
            long nh = 1000 * 60 * 60;
            long nm = 1000 * 60;
            String pattern="yyyy-MM-dd HH:mm:ss";
            SimpleDateFormat simpleFormat = new SimpleDateFormat(pattern);
            long from;

            from = simpleFormat.parse(bgtime).getTime();

            long to = simpleFormat.parse(getCurrentDateYYYYMMDD(pattern)).getTime();
            long hour =(to - from) % nd / nh;
            long minute =(to - from) % nd % nh/nm;
            double hours=(double)hour;
            double minutes=(double)minute;
            int a=(int)hours; //小时
            int b=(int)minutes;  //分钟
//	        if(b<30){
            if(b<30){
                return String.valueOf(b);
            }
//	        return a+"时"+b+"分";

            return "-1";
        } catch (ParseException e) {
            e.printStackTrace();
            return "-2";
        }
    }

    /**
     比较两个时间相差多少分钟*
     * @param bgtime
     * @param edtime
     * @return
     * @throws ParseException
     */
    public static String dateToStamp(String bgtime, String edtime) throws ParseException {
        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long from = simpleFormat.parse(bgtime).getTime();
        long to = simpleFormat.parse(edtime).getTime();
        long hour =(to - from) % nd / nh;
        long minute =(to - from) % nd % nh/nm;
        double hours=(double)hour;
        double minutes=(double)minute;
        int a=(int)hours; //小时
        int b=(int)minutes;  //分钟
        if(b<30){
            return b+"分";
        }
//        return a+"时"+b+"分";
        return "true";
    }
    /**
     * 使用用户格式提取字符串日期
     *
     * @param strDate 日期字符串
     * @param pattern 日期格式
     * @return
     */

    public static Date parse(String strDate, String pattern) {

        if (DateUtils.isEmpty(strDate)) {
            return null;
        }
        try {
            SimpleDateFormat df = new SimpleDateFormat(pattern);
            return df.parse(strDate);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public static Date parse(String strDate) {

        if (DateUtils.isEmpty(strDate)) {
            return null;
        }
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            return df.parse(strDate);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    /**
     * //格式化时间日期
     * @param date
     * @return
     */
    public static String getDateformat(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }
    public static String dateformat(Date date,String pattern) {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(date);
    }
    public static Date dateformat2(Date date,String pattern) {
        try {
            SimpleDateFormat format = new SimpleDateFormat(pattern);
            return format.parse( format.format(date));
        }catch (Exception e){
            return date;
        }


    }
    /**
     * 自定义
     * //格式化时间日期
     * @param date
     * @return
     */
    public static String getDateformat(Date date,String pattern) {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(date);
    }
    /**
     * 获取今天日期
     * @return
     */
    public static String getCurrentDateYYYYMMDDhhmm() {
        String pattern = "yyyy-MM-dd HH:mm";
        SimpleDateFormat fo = new SimpleDateFormat(pattern);
        return fo.format(new Date());
    }
    /**
     * 获取今天日期
     * @return
     */
    public static String getCurrentDateYYYYMMDD() {
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat fo = new SimpleDateFormat(pattern);
        return fo.format(new Date());
    }
    /**
     * 获取今天日期
     * @pattern  自定义时间格式  默认 yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String getCurrentDateYYYYMMDD(String pattern) {
//        String pattern = "yyyy-MM-dd";
        if(null==pattern||"".equals(pattern)){
            pattern="yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat fo = new SimpleDateFormat(pattern);
        return fo.format(new Date());
    }

    public static boolean isEmpty(String str) {
        if (str == null || "".equals(str) || "null".equalsIgnoreCase(str)) {
            return true;
        }
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c != ' ' && c != '\t' && c != '\r' && c != '\n') {
                return false;
            }
        }
        return true;
    }
    public static String GetNowDate(){
        String temp_str="";
        Date dt = new Date();
        //最后的aa表示“上午”或“下午”    HH表示24小时制    如果换成hh表示12小时制
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        temp_str=sdf.format(dt);
        return temp_str;
    }
    public static String GetNowDateYYYYMMDD(){
        String temp_str="";
        Date dt = new Date();
        //最后的aa表示“上午”或“下午”    HH表示24小时制    如果换成hh表示12小时制
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        temp_str=sdf.format(dt);
        return temp_str;
    }
    public static String returnDate(Long dateStr){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");
        date.setTime(dateStr);
        System.out.println(sdf.format(date));
        return sdf.format(date);
    }

    public static String dateLong2String(String dateLong){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");
        date.setTime(Long.valueOf(dateLong));
//        System.out.println(sdf.format(date));
        return sdf.format(date);
    }
    public static String dateLong2String(String dateLong,String pattern){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");
        date.setTime(Long.valueOf(dateLong));
//        System.out.println(sdf.format(date));
        return sdf.format(date);
    }
}

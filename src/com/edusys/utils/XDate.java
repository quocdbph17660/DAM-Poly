/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edusys.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Ciuz
 */
public class XDate {
    private static SimpleDateFormat sdf = new SimpleDateFormat();
    public static Date toDate(String date, String pattern){
        try {
            sdf.applyPattern(pattern);
            return sdf.parse(date);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static String toString(Date date,String pattern){
        sdf.applyPattern(pattern);
        return sdf.format(date);
    }
    public static Date addDay(Date date,long days){
        date.setTime(date.getTime()+days*24*60*60*1000);
        return date;
    }
}

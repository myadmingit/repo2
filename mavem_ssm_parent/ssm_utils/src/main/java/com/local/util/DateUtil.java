package com.local.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static String dateString(Date date,String patt){
        SimpleDateFormat sdf = new SimpleDateFormat(patt);
        String format = sdf.format(date);
        return format;
    }
    public static Date stringDate(String date,String patt) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(patt);
        Date parse = sdf.parse(date);
        return parse;
    }
}

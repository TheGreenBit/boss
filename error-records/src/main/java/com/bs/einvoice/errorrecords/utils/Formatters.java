package com.bs.einvoice.errorrecords.utils;

import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Formatters {

    private static final ThreadLocal<Map<String, SimpleDateFormat>> FORMAT_THREAD_LOCAL = new ThreadLocal<Map<String, SimpleDateFormat>>() {
        @Override
        protected Map<String, SimpleDateFormat> initialValue() {
            HashMap<String, SimpleDateFormat> map = new HashMap<String, SimpleDateFormat>(8);
            map.put(yMd_Hms, new SimpleDateFormat(yMd_Hms));
            map.put(_yMd, new SimpleDateFormat(_yMd));
            map.put(yMdHms, new SimpleDateFormat(yMdHms));
            map.put(yMd, new SimpleDateFormat(yMd));
            map.put(_Hms, new SimpleDateFormat(_Hms));
            map.put(Hms, new SimpleDateFormat(Hms));
            return map;
        }
    };

    public static final String yMd_Hms = "yyyy-MM-dd HH:mm:ss";
    public static final String _yMd = "yyyy-MM-dd";
    public static final String yMdHms = "yyyyMMddHHmmss";
    public static final String yMd = "yyyyMMdd";
    public static final String _Hms = "HH:mm:ss";
    public static final String Hms = "HHmmss";

    public static String format(Date date) {
        return format(date, yMd_Hms);
    }

    public static String format(Date date, String format) {
        return getIfNotExistCreate(format).format(date);
    }

    public static Date parse(String date) throws ParseException {
        return parse(date, yMd_Hms);
    }

    public static Date parse(String date, String format) throws ParseException {
        return getIfNotExistCreate(format).parse(date);
    }

    private static SimpleDateFormat getIfNotExistCreate(String format) {
        if (StringUtils.isEmpty(format)) {
            throw new IllegalArgumentException("格式化参数不能为空！");
        }

        format = format.trim();

        Map<String, SimpleDateFormat> dateFormatMap = FORMAT_THREAD_LOCAL.get();
        SimpleDateFormat simpleDateFormat = dateFormatMap.get(format);
        if (simpleDateFormat != null) {
            return simpleDateFormat;
        }

        simpleDateFormat = new SimpleDateFormat(format);
        dateFormatMap.put(format, simpleDateFormat);

        return simpleDateFormat;
    }
}

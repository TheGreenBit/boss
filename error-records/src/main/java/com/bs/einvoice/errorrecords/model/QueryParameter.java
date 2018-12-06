package com.bs.einvoice.errorrecords.model;

import com.bs.einvoice.errorrecords.utils.Formatters;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.Callable;

public class QueryParameter implements Serializable {

    private String start;

    private String end;


    public String getStart() {
        return start;
    }

    public Date getBeginDate() throws ParseException {
        if (StringUtils.isNotEmpty(start)) {
            return Formatters.parse(start);
        }

        Calendar instance = Calendar.getInstance();
        instance.set(Calendar.HOUR_OF_DAY, 0);
        instance.set(Calendar.MINUTE, 0);
        instance.set(Calendar.SECOND, 0);
        instance.add(Calendar.DAY_OF_YEAR, -1);
        return instance.getTime();
    }

    public Date getEndDate() throws ParseException {
        if (StringUtils.isNotEmpty(end)) {
            return Formatters.parse(end);
        }
        return new Date();
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }
}

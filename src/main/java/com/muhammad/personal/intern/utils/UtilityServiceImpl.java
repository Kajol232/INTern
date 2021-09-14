package com.muhammad.personal.intern.utils;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;

@Service
public class UtilityServiceImpl implements IUtilityService{
    @Override
    public int dobConversion(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH) + 1;
        int d = c.get(Calendar.DATE);
        LocalDate l1 = LocalDate.of(year, month, d);
        LocalDate now1 = LocalDate.now();
        Period diff1 = Period.between(l1, now1);

        return diff1.getYears();
    }
}

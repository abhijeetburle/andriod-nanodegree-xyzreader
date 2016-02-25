package com.example.xyzreader.util;

import com.example.xyzreader.data.ArticleLoader;

import java.util.concurrent.TimeUnit;

/**
 * Created by abhijeet.burle on 2016/02/24.
 */
public class FormatterUtil {
    public static String formatDateToTimeEllapsed(long pastDate){
        long diff = System.currentTimeMillis()-pastDate;
        long daysPassed = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
        if(daysPassed>0){
            if(daysPassed<7) {
                return daysPassed+"d";
            }else if(((int)daysPassed/7)<52){
                return ((int)(daysPassed/7))+"w";
            } else{
                return ((int)((daysPassed/7)/52))+"y";
            }
        }else{
            long hoursPassed = TimeUnit.HOURS.convert(diff, TimeUnit.MILLISECONDS);
            if(hoursPassed>0){
                return hoursPassed+"h";
            }else{
                long minPassed = TimeUnit.MINUTES.convert(diff, TimeUnit.MILLISECONDS);
                if(minPassed>0) {
                    return minPassed + "m";
                }else{
                    long secPassed = TimeUnit.SECONDS.convert(diff, TimeUnit.MILLISECONDS);
                    return secPassed + "s";
                }
            }
        }
    }
}

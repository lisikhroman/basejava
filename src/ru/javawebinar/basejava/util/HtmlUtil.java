package ru.javawebinar.basejava.util;

import ru.javawebinar.basejava.model.Experience;

public class HtmlUtil {
    public static boolean isEmpty(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static String formatDates(Experience.Period period) {
        return DateUtil.format(period.getBeginPeriod()) + " - " + DateUtil.format(period.getEndPeriod());
    }

}

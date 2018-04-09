package tools;

import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import jxl.format.Colour;

public class Utils {
    public static Colour getNearestColour(String strColor) {
        if (strColor == null || "".equals(strColor)) {
            return Colour.BLACK;
        }
        Color cl = Color.decode(strColor);
        Colour color = null;
        Colour[] colors = Colour.getAllColours();
        if ((colors != null) && (colors.length > 0)) {
            Colour crtColor = null;
            int[] rgb = null;
            int diff = 0;
            int minDiff = 999;
            for (int i = 0; i < colors.length; i++) {
                crtColor = colors[i];
                rgb = new int[3];
                rgb[0] = crtColor.getDefaultRGB().getRed();
                rgb[1] = crtColor.getDefaultRGB().getGreen();
                rgb[2] = crtColor.getDefaultRGB().getBlue();

                diff = Math.abs(rgb[0] - cl.getRed())
                        + Math.abs(rgb[1] - cl.getGreen())
                        + Math.abs(rgb[2] - cl.getBlue());
                if (diff < minDiff) {
                    minDiff = diff;
                    color = crtColor;
                }
            }
        }
        if (color == null)
            color = Colour.BLACK;
        return color;
    }

    public static String dateToString(Date date, String format) {
        if (format == null || "".equals(format)) {
            format = "yyyy-MM-dd";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        if (date == null) {
            date = new Date();
        }
        return sdf.format(date);
    }

    public static Date stringToDate(String date, String format) throws Exception {
        if (date == null || "".equals(date)) {
            return new Date();
        }
        if (format == null || "".equals(format)) {
            format = "yyyy-MM-dd";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.parse(date);
    }

    public static void main(String[] args) {
        System.out.println((new Long(100)).intValue());
    }

    public static String getNumberFormat(Long intValue) {
        // TODO Auto-generated method stub
        if (intValue == null) {
            return "#.##";
        } else if (intValue == 0) {
            return "#";
        } else {
            String s = "#.";
            for (int i = 0; i < intValue; i++) {
                s += "#";
            }
            return s;
        }
    }

    /**
     * 返回当前时间
     *
     * @return 以字符串的形式返回当前时间
     */
    public static String getCurrentTime() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(date);
    }

    /**
     * 返回当前日期
     *
     * @return 以日期的形式返回当前日期
     */
    public static Date getCurrentDate() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String nowdate = dateFormat.format(date);
        try {
            date = dateFormat.parse(nowdate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date;
    }

    /**
     * 返回当前日期
     *
     * @return 以字符串的形式返回当前日期
     */
    public static String getCurrentDateToString() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(date);
    }

    /**
     * 返回指定日期
     *
     * @return 以字符串的形式返回指定日期
     */
    public static String getOtherDate(Date date, int i) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_MONTH, i);
        return dateFormat.format(cal.getTime());
    }

    /**
     * 返回指定日期月/日
     *
     * @return 以字符串的形式返回指定日期
     */
    public static String getOtherMonDate(Date date, int i) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("M-dd");
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_MONTH, i);
        return dateFormat.format(cal.getTime());
    }

}
package com.hb.common.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @Author: David
 * @Description: 用于参数转换的工具
 * @Date: Created in 2017/11/28
 */
public class Utils {

    private static Object Server;
    private static String QRfromGoogle;
    private static String default_pattern = "yyyy-MM-dd HH:mm:ss";

    /**
     * 把对象转换成字符串
     *
     * @param obj
     * @return String 转换成字符串,若对象为null,则返回空字符串.
     */
    public static String toString(Object obj) {
        if (obj == null)
            return "";

        return obj.toString();
    }

    /**
     * 把对象转换为int数值.
     *
     * @param obj 包含数字的对象.
     * @return int 转换后的数值,对不能转换的对象返回0。
     */
    public static int toInt(Object obj) {
        int a = 0;
        try {
            if (obj != null)
                a = Integer.parseInt(obj.toString());
        } catch (Exception e) {

        }
        return a;
    }

    /**
     * 获取当前时间 yyyyMMddHHmmss
     *
     * @return String
     */
    public static String getCurrTime() {
        Date now = new Date();
        SimpleDateFormat outFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String s = outFormat.format(now);
        return s;
    }

    /**
     * 获取当前日期 yyyyMMdd
     *
     * @param date
     * @return String
     */
    public static String formatDate(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        String strDate = formatter.format(date);
        return strDate;
    }

    /**
     * 取出一个指定长度大小的随机正整数.
     *
     * @param length int 设定所取出随机数的长度。length小于11
     * @return int 返回生成的随机数。
     */
    public static int buildRandom(int length) {
        int num = 1;
        double random = Math.random();
        if (random < 0.1) {
            random = random + 0.1;
        }
        for (int i = 0; i < length; i++) {
            num = num * 10;
        }
        return (int) ((random * num));
    }

    /**
     * 获取编码字符集
     *
     * @param request
     * @param response
     * @return String
     */

    public static String getCharacterEncoding(HttpServletRequest request,
                                              HttpServletResponse response) {

        if (null == request || null == response) {
            return "gbk";
        }

        String enc = request.getCharacterEncoding();
        if (null == enc || "".equals(enc)) {
            enc = response.getCharacterEncoding();
        }

        if (null == enc || "".equals(enc)) {
            enc = "gbk";
        }

        return enc;
    }

    public static String URLencode(String content) {

        String URLencode;

        URLencode = replace(Server.equals(content), "+", "%20");

        return URLencode;
    }

    private static String replace(boolean equals, String string, String string2) {

        return null;
    }

    /**
     * 获取unix时间，从1970-01-01 00:00:00开始的秒数
     *
     * @param date
     * @return long
     */
    public static long getUnixTime(Date date) {
        if (null == date) {
            return 0;
        }

        return date.getTime() / 1000;
    }

    public static String QRfromGoogle(String chl) {
        int widhtHeight = 300;
        String EC_level = "L";
        int margin = 0;
        String QRfromGoogle;
        chl = URLencode(chl);

        QRfromGoogle = "http://chart.apis.google.com/chart?chs=" + widhtHeight + "x" + widhtHeight + "&cht=qr&chld=" + EC_level + "|" + margin + "&chl=" + chl;

        return QRfromGoogle;
    }

    /**
     * 时间转换成字符串
     *
     * @param date       时间
     * @param formatType 格式化类型
     * @return String
     */
    public static String date2String(Date date, String formatType) {
        SimpleDateFormat sdf = new SimpleDateFormat(formatType);
        return sdf.format(date);
    }

    /**
     * 字符串转换日期
     *
     * @param time
     * @return
     */
    public static Date parse(String time) {
        try {
            return new SimpleDateFormat(default_pattern).parse(time);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 元转分
     *
     * @param yuan
     * @return
     */
    public static String yuan2Cent(String yuan) {
        double y = Double.parseDouble(yuan);
        y *= 100d;
        return (int) y + "";
    }

    /**
     * 功能:得到某时间单位,在某个时间段内往后或往前推某个时间段的日期 日期格式：yyyy--MM--dd unit:Y,M,D
     *
     * @param baseDate 起始日期
     * @param interval 时间间隔
     * @param unit     时间间隔单位，可以为 Y（年）、M（月）、D（天）
     * @return Date
     */
    public static Date calDate(Date baseDate, int interval, String unit) {
        Date returnDate = null;

        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(baseDate);

        if (unit.equals("Y")) {
            gregorianCalendar.add(Calendar.YEAR, interval);
        }
        if (unit.equals("M")) {
            gregorianCalendar.add(Calendar.MONTH, interval);
        }
        if (unit.equals("D")) {
            gregorianCalendar.add(Calendar.DATE, interval);

        }
        if (unit.equals("H")) {
            gregorianCalendar.add(Calendar.HOUR, interval);
        }
        if (unit.equals("m")) {
            gregorianCalendar.add(Calendar.MINUTE, interval);

        }
        if (unit.equals("s")) {
            gregorianCalendar.add(Calendar.SECOND, interval);
        }
        returnDate = gregorianCalendar.getTime();

        return returnDate;
    }
}
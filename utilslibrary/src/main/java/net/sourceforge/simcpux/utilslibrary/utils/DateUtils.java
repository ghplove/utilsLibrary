package net.sourceforge.simcpux.utilslibrary.utils;

import android.text.TextUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by huiping.guo on 17/6/27.
 */

public class DateUtils {
    public static final String FORMATER_Y = "yyyy";
    public static final String FORMATER_M = "MM";
    public static final String FORMATER_D = "dd";
    public static final String FORMATER_HM = "HH:mm";
    public static final String FORMATER_HMS = "HH:mm:ss";
    public static final String FORMATER_MD = "MM-dd";
    public static final String FORMATER_YM = "yyyy-MM";
    public static final String FORMATER_YMD = "yyyy-MM-dd";
    public static final String FORMATER_MD_HM = "MM-dd HH:mm";
    public static final String FORMATER_YMD_HM = "yyyy-MM-dd HH:mm";
    public static final String FORMATER_YMD_HMS = "yyyy-MM-dd HH:mm:ss";
    public static final String FORMATER_YMDSTR = "yyyy年MM月dd日";

    public static final SimpleDateFormat df_y = new SimpleDateFormat(FORMATER_Y);
    public static final SimpleDateFormat df_m = new SimpleDateFormat(FORMATER_M);
    public static final SimpleDateFormat df_d = new SimpleDateFormat(FORMATER_D);
    public static final SimpleDateFormat df_hm = new SimpleDateFormat(FORMATER_HM);
    public static final SimpleDateFormat df_hms = new SimpleDateFormat(FORMATER_HMS);
    public static final SimpleDateFormat df_md = new SimpleDateFormat(FORMATER_MD);
    public static final SimpleDateFormat df_ym = new SimpleDateFormat(FORMATER_YM);
    public static final SimpleDateFormat df_ymd = new SimpleDateFormat(FORMATER_YMD);
    public static final SimpleDateFormat df_md_hm = new SimpleDateFormat(FORMATER_MD_HM);
    public static final SimpleDateFormat df_ymd_hm = new SimpleDateFormat(FORMATER_YMD_HM);
    public static final SimpleDateFormat df_ymd_hms = new SimpleDateFormat(FORMATER_YMD_HMS);
    public static final SimpleDateFormat df_ymd_str = new SimpleDateFormat(FORMATER_YMDSTR);

    public static final int MINUTE60 = 3600;
    public static final int MINUTE = 60;
    public static final int TEN = 10;
    public static final int TOMORROW = 1;
    public static final int YESTERDAY = -1;
    public static final long SECOND_IN_MILLIS = 1000;
    public static final long MINUTE_IN_MILLIS = 60 * SECOND_IN_MILLIS;

    /**
     * 获取基准日的前后偏移毫秒
     *
     * @param count 偏移数量
     * @param date  基准日期
     * @return Date
     */
    public static Date addMilliseconds(Date date, int count) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MILLISECOND, count);
        return calendar.getTime();
    }

    public static long millisecondsBetweenDates(Date newDate, Date oldDate) {
        return (newDate.getTime() - oldDate.getTime());
    }

    /**
     * 时间转换
     * @param dateStr
     * @param startSF
     * @param endSF
     * @return
     */
    public static String DateNomal(String dateStr, SimpleDateFormat startSF, SimpleDateFormat endSF) {
        try {
            Date date = startSF.parse(dateStr);
            return endSF.format(date.getTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 格式化日期
     */
    public static String getFormatDate(Date date, String formatString) {
        SimpleDateFormat df = new SimpleDateFormat(formatString);
        return df.format(date);
    }

    public static Date getDate(String format) {
        Date date = null;
        try {
            return df_ymd_hms.parse(format);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * yyyy-MM-dd
     */
    public static String DateYMD(Date date) {
        return getFormatDate(date, FORMATER_YMD);
    }

    /**
     * yyyy-MM-dd HH:mm:ss
     * yyyy-MM-dd HH:mm
     */
    public static String DateYMDHM(String dateStr) {
        try {
            Date date = df_ymd_hms.parse(dateStr);
            return df_ymd_hm.format(date.getTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * yyyy-MM-dd HH:mm:ss
     * yyyy-MM-dd
     */
    public static String DateYMD(String dateStr) {
        try {
            Date date = df_ymd_hms.parse(dateStr);
            return df_ymd.format(date.getTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }


    /**
     * yyyy-MM-dd HH:mm:ss
     * yyyy-MM
     */
    public static String DateYM(String dateStr) {
        try {
            Date date = df_ymd_hms.parse(dateStr);
            return df_ym.format(date.getTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
    /**
     * yyyy-MM-dd HH:mm:ss
     * MM-dd
     */
    public static String DateMD(String dateStr) {
        try {
            Date date = df_ymd_hms.parse(dateStr);
            return df_md.format(date.getTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * yyyy-MM-dd HH:mm:ss
     * MM-dd HH:mm
     */
    public static String DateMDHM(String dateStr) {
        try {
            Date date = df_ymd_hms.parse(dateStr);
            return df_md_hm.format(date.getTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * yyyy-MM-dd HH:mm:ss
     * HH:mm:ss
     */
    public static String DateHMS(String dateStr) {
        try {
            Date date = df_ymd_hms.parse(dateStr);
            return df_hms.format(date.getTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * yyyy-MM-dd HH:mm:ss
     * HH:mm
     */
    public static String DateHM(String dateStr) {
        try {
            Date date = df_ymd_hms.parse(dateStr);
            return df_hm.format(date.getTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * yyyy年MM月dd日
     */
    public static String DateYMDSTR(String dateStr) {
        try {
            Date date = df_ymd_hms.parse(dateStr);
            return df_ymd_str.format(date.getTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 描述：获取表示当前日期时间的字符串.
     *
     * @param format 格式化字符串，如："yyyy-MM-dd HH:mm:ss"
     * @return String String类型的当前日期时间
     */
    public static String getCurrentDate(String format) {
        String curDateTime = null;
        try {
            SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat(format);
            Calendar c = new GregorianCalendar();
            curDateTime = mSimpleDateFormat.format(c.getTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return curDateTime;

    }


    /**
     * 时间差
     */
    public static long getDistanceTime(String dateOne, String dateTwo) {
        long timeOne = getDate(dateOne).getTime();
        long timeTwo = getDate(dateTwo).getTime();
        long diff;
        if (timeOne < timeTwo) {
            diff = timeTwo - timeOne;
        } else {
            diff = timeOne - timeTwo;
        }
        return diff / SECOND_IN_MILLIS;
    }


    /**
     * 格式化'秒
     */
    public static String formatSeconds(Long useSecond) {
        int minute = (int) (useSecond / MINUTE);
        String result = "";
        if (minute != 0) {
            result = minute + "'";
        }
        int second = (int) (useSecond - minute * MINUTE);
        result = result + second + "''";
        return result;
    }

    /**
     * 格式化日期
     */
    public static String format(long time, String formatString) {
        SimpleDateFormat df = new SimpleDateFormat(formatString);
        Date date = new Date();
        date.setTime(time);
        return df.format(date);
    }

    /**
     * 昨天
     */
    public static Date yesterday() {
        return addDay(YESTERDAY);
    }

    /**
     * 明天
     */
    public static Date tomorrow() {
        return addDay(TOMORROW);
    }

    /**
     * 现在
     */
    public static Date now() {
        return new Date(System.currentTimeMillis());
    }

    /**
     * 按日加
     */
    public static Date addDay(int value) {
        Calendar now = Calendar.getInstance();
        now.add(Calendar.DAY_OF_YEAR, value);
        return now.getTime();
    }

    /**
     * 获取年月日时分秒
     */
    public static String getYMDHMS() {
        StringBuffer current = new StringBuffer();
        current.append("本机时间:");
        current.append(DateUtils.year() + "年");

        String month = "";
        if (DateUtils.month() < TEN) {
            month = "0" + DateUtils.month() + "月";
        } else {
            month = DateUtils.month() + "月";
        }
        current.append(month);

        String day = "";
        if (DateUtils.day() < TEN) {
            day = "0" + DateUtils.day() + "日";
        } else {
            day = DateUtils.day() + "日";
        }
        current.append(day);

        String hour = "";
        if (DateUtils.hour() < TEN) {
            hour = "0" + DateUtils.hour() + "时";
        } else {
            hour = DateUtils.hour() + "时";
        }
        current.append(hour);

        String minute = "";
        if (DateUtils.minute() < TEN) {
            minute = "0" + DateUtils.minute() + "分";
        } else {
            minute = DateUtils.minute() + "分";
        }
        current.append(minute);

        String second = "";
        if (DateUtils.second() < TEN) {
            second = "0" + DateUtils.second() + "秒";
        } else {
            second = DateUtils.second() + "秒";
        }
        current.append(second);

        return current.toString();
    }

    /**
     * 年份
     */
    public static int year() {
        Calendar now = Calendar.getInstance();
        return now.get(Calendar.YEAR);
    }

    /**
     * 月份
     */
    public static int month() {
        Calendar now = Calendar.getInstance();
        return now.get(Calendar.MONTH) + 1;
    }

    /**
     * 日(号)
     */
    public static int day() {
        Calendar now = Calendar.getInstance();
        return now.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 小时(点)
     */
    public static int hour() {
        Calendar now = Calendar.getInstance();
        return now.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * 分钟
     */
    public static int minute() {
        Calendar now = Calendar.getInstance();
        return now.get(Calendar.MINUTE);
    }

    /**
     * 秒
     */
    public static int second() {
        Calendar now = Calendar.getInstance();
        return now.get(Calendar.SECOND);
    }

    /**
     * 时间差long
     */
    public static long getTime(String allowTime, String now) {
        long diff = 0;
        try {
            Date dt = df_ymd_hms.parse(allowTime);
            Date nowDate = df_ymd_hms.parse(now);
            diff = dt.getTime() - nowDate.getTime();

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return diff;
    }

    /**
     * 时间戳
     */
    public static long getDateLong(String date) {
        long diff = 0;
        try {
            Date nowDate = df_ymd_hms.parse(date);
            diff = nowDate.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return diff;
    }


    /**
     * 计算秒数
     */
    public static final long millisToSeconds(long timeMillis) {
        return timeMillis / SECOND_IN_MILLIS;
    }

    /**
     * 获得微秒数
     */
    public static final long secondsToMillis(long timeSeconds) {
        return timeSeconds * SECOND_IN_MILLIS;
    }

    /**
     * 比对时间
     */
    public static boolean timeCompare(String time, String quitTime) {
        boolean isBefore = false;
        try {
            Date now = df_ymd_hms.parse(time);
            Date quit = df_ymd_hms.parse(quitTime);
            if (now.compareTo(quit) <= 0) {
                isBefore = true;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return isBefore;
    }
    /**
     * 比对时间
     */
    public static boolean timeCompare(String time, String quitTime,SimpleDateFormat format) {
        boolean isBefore = false;
        try {
            Date now = format.parse(time);
            Date quit = format.parse(quitTime);
            if (now.compareTo(quit) <= 0) {
                isBefore = true;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return isBefore;
    }

    /**
     * 获取2个日期之间的天数
     */
    public static int daysBetween(Date now, Date returnDate) {
        Calendar cNow = Calendar.getInstance();
        Calendar cReturnDate = Calendar.getInstance();
        cNow.setTime(now);
        cReturnDate.setTime(returnDate);
        setTimeToMidnight(cNow);
        setTimeToMidnight(cReturnDate);
        long todayMs = cNow.getTimeInMillis();
        long returnMs = cReturnDate.getTimeInMillis();
        long intervalMs = todayMs - returnMs;
        return millisecondsToDays(intervalMs);
    }
    /**
     * 获取2个日期的月数之差
     */
    public static int monthesBetween(Date now, Date returnDate) {
        Calendar cNow = Calendar.getInstance();
        Calendar cReturnDate = Calendar.getInstance();
        cNow.setTime(now);
        cReturnDate.setTime(returnDate);
        setTimeToMidnight(cNow);
        setTimeToMidnight(cReturnDate);
        int yearNow=cNow.get(Calendar.YEAR);
        int yearReturn=cReturnDate.get(Calendar.YEAR);
        int intervalYear=yearNow-yearReturn;
        int todayMs = cNow.get(Calendar.MONTH);
        int returnMs = cReturnDate.get(Calendar.MONTH);
        int intervalMs = todayMs - returnMs;
        intervalMs+=intervalYear*12;
        return intervalMs;
    }

    /**
     * 获取2个日期的月数之差
     */
    public static int getMonthSpace(String date1, String date2)
            throws ParseException {

        int result = 0;
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();

        c1.setTime(df_ymd.parse(date1));
        c2.setTime(df_ymd.parse(date2));

        result = c2.get(Calendar.MONTH) - c1.get(Calendar.MONTH);

        return result == 0 ? 1 : Math.abs(result);

    }


    public static int millisecondsToDays(long intervalMs) {
        return (int) (intervalMs / (1000 * 86400));
    }

    public static void setTimeToMidnight(Calendar calendar) {
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
    }

    /**
     * 将毫秒转为日期格式
     *
     * @param timeMilli 毫秒值
     * @param format    格式化字符串
     */
    public static String aTimeMilli2Date(SimpleDateFormat format, long timeMilli) {
        String date;
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timeMilli);
        if (format==null) {
            date = df_ymd.format(calendar.getTime());
        } else {
            date = format.format(calendar.getTime());
        }
        if (!TextUtils.isEmpty(date)) {
            date = timeMilli + "";
        }
        return date;
    }

    public static String milli2Date(String format,long timemilli){
        if(TextUtils.isEmpty(format)){
            return "";
        }
        SimpleDateFormat df = new SimpleDateFormat(format);
        Date date=new Date(timemilli);
        try {
        } catch (Exception ex) {
        }
        return df.format(date);
    }

    /**
     * 毫秒转时分
     *
     * */

    public static String getHourMinutes(long ms) {
        Integer ss = 1000;
        Integer mi = ss * 60;
        Integer hh = mi * 60;

        Long hour = ms / hh;
        Long minute = (ms  - hour * hh) / mi;
        Long second = (ms  - hour * hh - minute * mi) / ss;
        Long milliSecond = ms -  hour * hh - minute * mi - second * ss;

        StringBuffer sb = new StringBuffer();
        if(hour > 0) {
            sb.append(hour+"小时");
        }
        if(minute > 0) {
            sb.append(minute+"分");
        }
        return sb.toString();

    }

    public static Long String2LongDate(String date){
        Long time = 0L;
        try {
            if(date != null)
                time = df_ymd.parse(date).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return time;
    }

    public static String formatTime(String date) {
        if(date!=null){
            date = date.substring(date.indexOf("-")+1);
        }
        return date;
    }
}

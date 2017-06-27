package net.sourceforge.simcpux.utilslibrary.utils;

import android.text.TextUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * Created by huiping.guo on 17/6/27.
 */

public class NumberUtils {

    public static final String DEFAULT_RATE_STR = "0.00";
    public static final String DEFAULT_RATE_STR_1 = "0.0";
    public static final String DEFAULT_RATE_STR_2 = "0.00";
    public static final String DEFAULT_RATE_STR_3 = "0.000";
    public static final String DEFAULT_RATE_STR_4 = "0.0000";
    public static final String DEFAULT_ZERO = "0";
    public static final String DEFAULT_HUNDRED = "100";
    public static final String DEFAULT_TEN_THOUSAND = "10000";
    public static final String DEFAULT_MILLION = "1000000";
    public static final String MONEY_FORMATE_STR = ",###,##0.00";

    public static final DecimalFormat moneydf = new DecimalFormat(MONEY_FORMATE_STR);

    public static final BigDecimal TEN_THOUSAND =new BigDecimal("10000");
    public static final BigDecimal MINLLION = new BigDecimal("1000000");

    public static String getMoneyNoPoint(BigDecimal dec) {
        if (dec == null) return DEFAULT_RATE_STR;
        String amountString= moneydf.format(dec);
        if (amountString.endsWith(".00")) {
            amountString = amountString.substring(0, amountString.length() - 3);
        }
        return amountString;

    }

    public static String getMoneyFormat(BigDecimal money, boolean isRoundDown) {
        if (money == null) return DEFAULT_RATE_STR;
        if (isRoundDown) {
            moneydf.setRoundingMode(RoundingMode.DOWN);
        }
        return moneydf.format(money);
    }

    public static String getMoneyFormatStr(BigDecimal money) {
        return getMoneyFormat(money, false);
    }

    public static String getMoneyFormatUp(BigDecimal money) {
        if (money == null) return DEFAULT_RATE_STR;
        moneydf.setRoundingMode(RoundingMode.HALF_UP);
        return moneydf.format(money);
    }

    public static String getFormatStr(BigDecimal decimal, String formatStr){
        if(decimal==null){
            return DEFAULT_RATE_STR;
        }
        DecimalFormat format=new DecimalFormat(formatStr);
        return format.format(decimal);
    }

    /**
     * 将金额转成以万为单位，去除小数
     */
    public static String getAmount(BigDecimal detail) {
        return getAmount(detail,true);
    }

    /**
     * 将金额转成以万为单位，保留2位小数
     */
    public static String getAmount(BigDecimal detail, boolean isSplite){
        if (detail == null) return null;
        String amountString = null;
        if(isLarger(BigDecimal.ZERO,detail)){
            return "0.00";
        }
        BigDecimal wAmount = div(detail, new BigDecimal(DEFAULT_TEN_THOUSAND));
        amountString = moneydf.format(wAmount);
        if (amountString.endsWith(".00") && isSplite) {
            amountString = amountString.substring(0, amountString.length() - 3);
        }
        return amountString;
    }

    /**
     * 除以100保留2位小数
     */
    public static BigDecimal getRate(BigDecimal detail){
        if (detail == null) return null;
        return round(detail.multiply(new BigDecimal(DEFAULT_HUNDRED)), 2);

    }

    /**
     * 取数组最大值
     */
    public static BigDecimal getLargerOne(BigDecimal[] details){
        int largerIndex=0;
        for (int i=1;i<details.length;i++){
            if (isLarger(details[largerIndex],details[i])){
            }else{
                largerIndex=i;
            }
        }
        return details[largerIndex];
    }

    public static String getRate(BigDecimal decimal,String formate){
        if (decimal == null) return formate;
        DecimalFormat df = new DecimalFormat(formate);
        String rate = df.format(decimal);
        return rate;
    }

    public static String getRate(double decimal,String formate){
        DecimalFormat df = new DecimalFormat(formate);
        String rate = df.format(decimal);
        return rate;
    }

    /**
     * 格式化费率 保留1位小数
     */
    public static String getRateFormate1(double detail) {
        return getRate(new BigDecimal(detail),DEFAULT_RATE_STR_1);
    }

    /**
     * 格式化费率 保留1位小数
     */
    public static String getRateFormate1(BigDecimal detail) {
        return getRate(detail,DEFAULT_RATE_STR_1);
    }

    /**
     * 格式化费率 保留2位小数
     */
    public static String getRateFormate2(BigDecimal detail) {
        return getRate(detail, DEFAULT_RATE_STR_2);
    }
    /**
     * 格式化费率 保留2位小数
     */
    public static String getRateFormate2(double detail) {
        return getRate(detail, DEFAULT_RATE_STR_2);
    }

    /**
     * 格式化费率 保留3位小数
     */
    public static String getRateFormate3(BigDecimal detail) {
        return getRate(detail, DEFAULT_RATE_STR_3);
    }
    /**
     * 格式化费率 保留3位小数
     */
    public static String getRateFormate3(double detail) {
        return getRate(detail, DEFAULT_RATE_STR_3);
    }
    /**
     * 格式化费率 保留4位小数
     */
    public static String getRateFormate4(BigDecimal detail) {
        return getRate(detail,DEFAULT_RATE_STR_4);
    }
    /**
     * 格式化费率 保留4位小数
     */
    public static String getRateFormate4(double detail) {
        return getRate(new BigDecimal(detail),DEFAULT_RATE_STR_4);
    }

    /**
     * 格式化利率 取整数
     */
    public static String getNoPointDate(float detail) {
        String dtime = String.valueOf(detail);
        if (dtime.endsWith(".0")) {
            dtime = dtime.substring(0, dtime.length() - 2);
        }
        return dtime;
    }

    /**
     * 格式化金额 取 小数点前数字
     */
    public static String getMoneyFormatHead(BigDecimal money) {
        if (money == null) return DEFAULT_ZERO;
        String formatMoney = moneydf.format(money);
        int index = formatMoney.indexOf(".");
        String result = formatMoney.substring(0, index);
        return result;
    }

    /**
     * 格式化金额 取 小数点前数字
     */
    public static String getMoneyFormatHead(double money) {
        if (money == 0) return DEFAULT_ZERO;
        String formatMoney = moneydf.format(money);
        int index = formatMoney.indexOf(".");
        String result = formatMoney.substring(0, index);
        return result;
    }
    /**
     * 格式化金额 取 小数点后数字
     */
    public static String getMoneyFormatTail(BigDecimal money) {
        if (money == null) return DEFAULT_RATE_STR_2;
        String formatMoney = moneydf.format(money);
        int index = formatMoney.indexOf(".");
        String result = formatMoney.substring(index + 1, formatMoney.length());
        return result;
    }
    /**
     * 格式化利率 去掉%
     */
    public static String getDisplayRate(String rate) {
        if (null != rate) {
            return rate.replaceAll("%", "");
        } else {
            return "";
        }
    }

    /**
     *格式化利率 0.00％
     */
    public static String getAddPercentRate(BigDecimal rate){
        BigDecimal bd;
        bd=rate.multiply(new BigDecimal(100));
        return getRateFormate2(bd)+"%";
    }
    /**
     *格式化利率 0.00％
     */
    public static String getAddPercentRate(double rate){
        BigDecimal bd=new BigDecimal(rate).multiply(new BigDecimal(100));
        return getRateFormate2(bd)+"%";
    }
    /**
     *格式化利率 0.0％
     */
    public static String getAddPercentTwoRate(BigDecimal rate){
        BigDecimal bd;
        bd=rate.multiply(new BigDecimal(100));
        return getRateFormate1(bd)+"%";
    }
    /**
     * 格式化金额,大于10000 转为 万
     */
    public static String getMillionFormatStr(BigDecimal money) {
        if (money == null) return "0";
        String formatStr = "";
        if (money.compareTo(new BigDecimal(DEFAULT_TEN_THOUSAND)) != -1) {
            BigDecimal wAmount = div(money, new BigDecimal(DEFAULT_TEN_THOUSAND));
            formatStr = getMoneyNoPointStr(wAmount) + "万";
        } else {
            formatStr = getMoneyNoPointStr(money);
        }
        return formatStr;
    }

    /**
     * 格式化金额 取整数
     */
    public static String getMoneyNoPointStr(BigDecimal wAmount) {
        if (wAmount == null) return DEFAULT_RATE_STR_2;
        DecimalFormat df = new DecimalFormat();
        df.applyPattern(DEFAULT_RATE_STR_2);
        String amountString = df.format(wAmount);
        if (amountString.endsWith(".00")) {
            amountString = amountString.substring(0, amountString.length() - 3);
        }
        return amountString;
    }

    /**
     * 在使用BigDecimal时，如果使用double作为构造参数创建的对象会与实际数值有差异，
     * 创建BigDecimal对象时，建议使用String作为参数来创建。如果数据是double时，
     * 建议使用以下方法构建对象。
     * <p/>
     * double v=xx.xxxx;
     * BigDecimal value= new BigDecimal(Double.toString(v));
     */

    // 默认除法运算精度
    public static final int DEF_DIV_SCALE = 2;

    /**
     * 加法
     */
    public static BigDecimal add(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return add(b1, b2);
    }

    public static BigDecimal add(BigDecimal v1, BigDecimal v2) {
        return v1.add(v2);
    }

    /**
     * 减法
     */
    public static BigDecimal sub(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return sub(b1, b2);
    }

    public static BigDecimal sub(BigDecimal v1, BigDecimal v2) {
        return v1.subtract(v2);
    }

    /**
     * 乘法
     */
    public static BigDecimal mul(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return mul(b1, b2);
    }

    public static BigDecimal mul(BigDecimal v1, BigDecimal v2) {
        return v1.multiply(v2);
    }

    /**
     * 除法 默认保留DEF_DIV_SCALE位小数
     */
    public static BigDecimal div(double v1, double v2) {
        return div(v1, v2, DEF_DIV_SCALE);
    }

    public static BigDecimal div(BigDecimal v1, BigDecimal v2) {
        return div(v1, v2, DEF_DIV_SCALE);
    }

    /**
     * 除法 保留scale位小数
     */
    public static BigDecimal div(double v1, double v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP);
    }

    public static BigDecimal div(BigDecimal v1, BigDecimal v2, int scale) {
        if (isEqual(v2,BigDecimal.ZERO))
            return BigDecimal.ZERO;
        return v1.divide(v2, scale, BigDecimal.ROUND_HALF_UP);
    }

    public static BigDecimal divRoundDown(BigDecimal v1, BigDecimal v2, int scale) {
        return v1.divide(v2, scale, BigDecimal.ROUND_DOWN);
    }

    /**
     * 四舍五入
     */
    public static BigDecimal round(double v, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        BigDecimal b = new BigDecimal(Double.toString(v));
        BigDecimal one = new BigDecimal("1");
        return b.divide(one, scale, BigDecimal.ROUND_HALF_UP);
    }

    public static BigDecimal round(BigDecimal v, int scale) {
        BigDecimal one = new BigDecimal("1");
        return v.divide(one, scale, BigDecimal.ROUND_HALF_UP);
    }

    public static int roundToInt(BigDecimal v, int scale) {
        return round(v, scale).intValue();
    }

    /**
     * 截取
     */
    public static BigDecimal roundDown(BigDecimal v, int scale) {
        BigDecimal one = new BigDecimal("1");
        return v.divide(one, scale, BigDecimal.ROUND_DOWN);
    }
    /**
     * 截取
     */
    public static BigDecimal roundDown(String v, int scale) {
        BigDecimal one = new BigDecimal("1");
        return new BigDecimal(v).divide(one, scale, BigDecimal.ROUND_DOWN);
    }

    public static BigDecimal roundFloor(BigDecimal v,int mode,int scale){
        BigDecimal one = new BigDecimal("1");
        return v.divide(one, scale, mode);
    }

    /**
     * 截取
     * scale截取位置
     */

    public static String roundDownStr(BigDecimal v, int scale) {
        BigDecimal roundDown = roundDown(v, scale);
        return getMoneyFormatStr(roundDown);
    }

    /**
     * 获取最小值
     */

    public static BigDecimal min(BigDecimal v1, BigDecimal v2) {
        return v1.min(v2);
    }
    /**
     * 金额格式化
     */
    public static String strFormatMoneyStr(String str) {
        if (TextUtils.isEmpty(str)) {
            return DEFAULT_RATE_STR_2;
        } else {
            return moneydf.format(new BigDecimal(str));
        }
    }
    /**
     * 比对大小
     */
    public static boolean isLarger(String v1, String v2) {
        BigDecimal value1=new BigDecimal(v1);
        BigDecimal value2=new BigDecimal(v2);
        return isLarger(value1, value2);
    }
    /**
     * 比对大小
     */
    public static boolean isLarger(BigDecimal v1, BigDecimal v2) {
        return v1.compareTo(v2)>0;
    }
    /**
     * 比对大于等于
     */
    public static boolean isLargerEqual(String v1, String v2) {
        BigDecimal value1=new BigDecimal(v1);
        BigDecimal value2=new BigDecimal(v2);
        return value1.compareTo(value2)>=0;
    }
    /**
     * 比对大于等于
     */
    public static boolean isLargerEqual(BigDecimal v1, BigDecimal v2) {
        return v1.compareTo(v2)>=0;
    }
    /**
     * 比对相等
     */
    public static boolean isEqual(String v1, String v2) {
        BigDecimal value1=new BigDecimal(v1);
        BigDecimal value2=new BigDecimal(v2);
        return isEqual(value1, value2);
    }
    /**
     * 比对相等
     */
    public static boolean isEqual(BigDecimal v1, BigDecimal v2) {
        return v1.compareTo(v2)==0;
    }
    /**
     * 比对是否是整数倍
     */
    public static boolean isDividedevenly(String molecule,String denominator){
        BigDecimal v1=new BigDecimal(molecule);
        BigDecimal v2=new BigDecimal(denominator);
        BigDecimal remainder=v1.remainder(v2);
        return remainder.compareTo(BigDecimal.ZERO)==0;
    }
    /**
     * 格式化浮点数 >0 +
     */
    public static String formatFloat2(float num){
        if(num>0){
            return "+"+moneydf.format(num);
        }else{
            return moneydf.format(num);
        }
    }
    /**
     * 格式化浮点数
     */
    public static String formatFloatonly(float num){
        return moneydf.format(num);
    }
    /**
     * 格式化浮点数
     */
    public static String formatFloatonly(double num){
        return moneydf.format(num);
    }

    /**
     * 计算进度
     */
    public final static int getProgress(BigDecimal amount,BigDecimal investmentedAmount){
        if(amount.compareTo(new BigDecimal(0))!=0){
            int value = roundToInt(
                    investmentedAmount.multiply(
                            new BigDecimal("100")).divide(
                            amount, 0, BigDecimal.ROUND_DOWN),0);
            if(value>100){
                value=100;
            }
            return value;
        }else{
            return 0;
        }
    }

    /**
     * 保留一位小数
     * 大于1万，以万为单位，大于1亿，以亿为单位
     * @param readNum
     * @param status true 小数为0显示整数
     * @return
     */
    public static String getReadNumStr(BigDecimal readNum,boolean status){
        String readNumStr="";
        if(readNum.compareTo(new BigDecimal(10000))<0){
            readNumStr=readNum+"";
        }else if(readNum.compareTo(new BigDecimal(100000000))<0){
            BigDecimal str=divRoundDown(readNum,new BigDecimal(10000),1);
            if(status){
                String newStr=str.toString();
                if (newStr.endsWith(".0")) {
                    str=divRoundDown(str,BigDecimal.ONE,0);
                }
            }
            readNumStr=str+"万";
        }else{
            BigDecimal str=divRoundDown(readNum,new BigDecimal(100000000),1);
            if(status){
                String newStr=str.toString();
                if (newStr.endsWith(".0")) {
                    str=divRoundDown(str,BigDecimal.ONE,0);
                }
            }
            readNumStr=str+"亿";
        }
        return readNumStr;
    }

    /**
     * 超过百万，显示*,***万
     * @param number
     * @param point 保留位数
     * @param isWithWan 是否显示万字
     * @return
     */
    public static String getMillionNumStr(BigDecimal number,int point,boolean isWithWan){
        String readNumStr="";
        if(isLargerEqual(number, new BigDecimal(DEFAULT_MILLION))){
            BigDecimal str=divRoundDown(number,new BigDecimal(DEFAULT_TEN_THOUSAND),point);
            readNumStr=getMoneyFormat(str,true);
            if(isWithWan){
                readNumStr=readNumStr+"万";
            }
        }
        else{
            readNumStr=getMoneyFormat(number,true);
        }
        return readNumStr;
    }


    public static String getMinllion(BigDecimal amount,boolean isWithLab) {
        String readNumStr="";
        if(isLargerEqual(amount, new BigDecimal(DEFAULT_MILLION))){
            BigDecimal str=divRoundDown(amount,new BigDecimal(DEFAULT_MILLION),2);
            readNumStr=getMoneyFormat(str,true);
            if(isWithLab){
                readNumStr=readNumStr+"百万";
            }
        }
        else{
            readNumStr=getMoneyFormat(amount,true);
        }
        return readNumStr;
    }
}

package net.sourceforge.simcpux.utilslibrary.utils;

import android.text.TextUtils;

import org.json.JSONArray;
import org.json.JSONObject;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by huiping.guo on 17/6/27.
 */

public class StringUtils {
    /**
     * 是否为空
     */
    public static boolean isEmpty(String str) {
        return TextUtils.isEmpty(str);
    }

    /**
     * 是否不为空
     */
    public static boolean isNotEmpty(String str) {
        return !TextUtils.isEmpty(str);
    }

    /**
     * 是否为数字
     */
    public static boolean isNumeric(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        int sz = str.length();
        for (int i = 0; i < sz; i++) {
            if (Character.isDigit(str.charAt(i)) == false) {
                return false;
            }
        }
        return true;
    }

    /**
     * 分割字符串
     */
    public static String[] split(String src, String separator) {
        if (src == null || separator == null) {
            return null;
        }
        if (src.length() == 0 || separator.length() == 0) {
            String[] s = {src};
            return s;
        }
        java.util.Vector<String> v = new java.util.Vector<String>();
        int start = 0, end = 0;
        while ((end = src.indexOf(separator, start)) != -1) {
            v.addElement(src.substring(start, end));
            start = end + separator.length();
        }
        v.addElement(src.substring(start));
        int ilen = v.size();
        if (ilen < 1) {
            return null;
        }
        String[] arr = new String[ilen];
        for (int i = 0; i < ilen; i++) {
            arr[i] = v.elementAt(i).toString();
        }
        return arr;
    }

    /**
     * 是否是子字符串
     */
    public static boolean isSubString(String str, String subStr) {
        return str.indexOf(subStr) != -1;
    }

    public static void appendString(StringBuffer buff, String str) {
        if (isEmpty(str))
            str = "";
        buff.append(str);
    }

    /**
     * 字符串拼接
     */
    public static String appendString(String str1, String str2) {
        if (isEmpty(str1))
            str1 = "";
        StringBuffer strBuf = new StringBuffer(str1);
        appendString(strBuf, str2);
        return strBuf.toString();
    }

    /**
     * 截取字符串
     * boolean inEllipsis是判断截取后的字符串后面是否add...
     */
    public static String CutOutStr(String str, int cutoutNum, boolean inEllipsis) {
        if (str != null && str.length() > 0) {
            if (str.length() <= cutoutNum) {
                return str;
            } else {
                String newStr = str.substring(0, cutoutNum);
                if (inEllipsis) {
                    newStr = newStr + "...";
                    return newStr;
                }
                return newStr;
            }
        }
        return null;
    }

    public static boolean isNotBlank(Object object) {
        return !isBlank(object);
    }

    public static boolean isNull(Object object) {
        return object == null;
    }

    public static boolean isNotNull(Object object) {
        return !isNull(object);
    }

    public static boolean isBlank(Object object) {
        if (isNull(object))
            return true;
        if (object instanceof JSONArray) {
            JSONArray obj = (JSONArray) object;
            if (obj.length() == 0)
                return true;
        }
        if (object instanceof JSONObject) {
            JSONObject obj = (JSONObject) object;
            if (obj.length() == 0)
                return true;
        }
        if (object instanceof List) {
            List<?> obj = (List<?>) object;
            if (obj.size() == 0)
                return true;
        }
        if (object instanceof Map) {
            Map<?, ?> obj = (Map<?, ?>) object;
            if (obj.size() == 0)
                return true;
        }
        return isNull(object);
    }

    public static String str2MD5(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] b = md.digest(str.getBytes("utf-8"));
            return byte2HexStr(b);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    private static String byte2HexStr(byte[] b) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < b.length; ++i) {
            String s = Integer.toHexString(b[i] & 0xFF);
            if (s.length() == 1)
                sb.append("0");

            sb.append(s.toUpperCase());
        }
        return sb.toString();
    }

    public static List<String> getParameterKeys(Map<String, String> params) {
        List<String> keys = new ArrayList<String>();
        if (params != null && params.size() > 0) {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                keys.add(entry.getKey());
            }
        }
        return keys;
    }

    public static List<String> getParameterValues(Map<String, String> params) {
        List<String> keys = new ArrayList<String>();
        if (params != null && params.size() > 0) {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                keys.add(entry.getValue());
            }
        }
        return keys;
    }

    public static String getParameterKey(Map<String, String> params, String value) {
        String key = null;
        if (params != null && params.size() > 0) {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                if (entry.getValue().equals(value)) {
                    key = entry.getKey();
                    break;
                }
            }
        }
        return key;
    }
    public static String getParameterValue(Map<String, String> params, String key) {
        String value = null;
        if (params != null && params.size() > 0) {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                if (entry.getKey().equals(key)) {
                    value = entry.getValue();
                    break;
                }
            }
        }
        return value;
    }

    public static boolean hasParameter(Map<Integer, String> params, int key, String value) {
        boolean has;
        if (params != null && params.size() > 0 && value != null) {
            if (params.containsKey(key) && value.equals(params.get(key))) {
                has = true;
            } else {
                has = false;
            }
        } else {
            has = false;
        }
        return has;
    }


    /**
     * 判断数字
     */
    public static boolean isNumber(String str) {
        return str.matches("0(\\.\\d+$)+|^0$|^[1-9]\\d*(\\.\\d+$){0,1}");
    }

    /**
     * 判断是否为非负数
     */
    public static boolean isPositiveRationalNumber(String str) {
        return str.matches("^\\d+(\\.\\d+)?$");
    }

    /**
     * 正整数
     */
    public static boolean isPositiveNumber(String str) {
        return str.matches("^[1-9]\\d*$");
    }

    /**
     * 判断条件为，开头字母为1，长度为11位
     */
    public static boolean isPhoneNumber(String number) {
        return number.matches("^[1][0-9]{10}$");
    }

    public static boolean isPostNumber(String number) {
        return number.matches("^[0-9]{6}$");
    }

    /**
     * 整数部分不超过10位，小数点后2位
     */
    public static boolean is2EndNumber(String number) {
        return number.matches("^\\d{0,8}\\.{0,1}(\\d{1,2})?$");
    }

    /**
     * 数字字母验证
     */
    public static boolean isLoginName(String name){
        String userNameRegex="(?!^\\d[A-Za-z0-9]*$)^[A-Za-z0-9_-]{6,25}$";
        return name.matches(userNameRegex);
    }
    /**
     * 姓名验证
     */
    public static boolean isChineseName(String name){
        String chineseRegex = "^[\\u4E00-\\u9FA5\\uF900-\\uFA2D]+$";
        return name.matches(chineseRegex);
    }
    /**
     * 身份证号码验证
     */
    public static boolean isIdCard(String idCard){
        String idCardeNoRegex="(^\\d{18}$)|(^\\d{17}(\\d|X|x)$)";
        return idCard.matches(idCardeNoRegex);
    }
    /**
     *  银行卡号验证
     */
    public static boolean isBankNum(String bankNum){
        String cardNumRegex   ="^[0-9]{15,19}$";
        return bankNum.matches(cardNumRegex);
    }
    /**
     * 手机号验证
     */
    public static boolean isPhoneNum(String phoneNum){
        String phoneRegex   ="^[1][0-9]{10}$";
        return phoneNum.matches(phoneRegex);
    }

    /**
     * 去除所有空格
     */
    public static String nullSpaceStr(String str) {
        String nullSpaceStr = str.replace(" ", "");
        return nullSpaceStr;
    }

    /**
     * 校验str
     */
    public static boolean checkString(String source, String reg) {
        return source.matches(reg);
    }

    /**
     * 格式化身份证
     */
    public static String encryptIdCard(String idCard) {
        String formatString = null;
        try {
            formatString = idCard.substring(0, 6) + "********" + idCard.substring(idCard.length() - 4, idCard.length());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (null == formatString) {
            formatString = "";
        }

        return formatString;
    }

    /**
     * 格式化用户名
     */
    public static String encryptUserName(String userName) {
        String formatString = null;
        try {
            formatString = "*" + userName.substring(1, userName.length());

        } catch (Exception e) {
            e.printStackTrace();
        }
        if (null == formatString) {
            formatString = "";
        }

        return formatString;
    }

    /**
     * 手机号加密
     */
    public final static String encryptPhoneNum(String phoneNum) {
        String phoneNum1 = phoneNum.substring(0, 3);
        String pnoneNum2 = phoneNum.substring(phoneNum.length() - 4, phoneNum.length());
        String newPhoneNum = phoneNum1 + "****" + pnoneNum2;
        return newPhoneNum;
    }

    /**
     * 根据身份证获取性别
     */
    public static String getSexfromCard(String idCard){
        String sex = "";
        if(StringUtils.isEmpty(idCard)){
            return sex;
        }
        String sexValue = idCard.substring(idCard.length()-1,idCard.length());
        sex = (Integer.parseInt(sexValue) % 2 == 0) ? "女" :"男" ;
        return sex;
    }
}

package com.spring.aop.action.desensitization;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author calebman
 * @date 2018/8/18
 * @description 脱敏工具类
 */
public class DesensitizationUtil {
    static final String[] DEFAULT_SENSITIVE_ARR = new String[]{"sb", "2b"};


    public static <T> T desensitization(T t) {
        return desensitization(t, DEFAULT_SENSITIVE_ARR);
    }

    public static List<String> getSensitivesOfObj(Object obj) {
        return getSensitivesOfObj(obj, DEFAULT_SENSITIVE_ARR);
    }

    /**
     * 脱敏处理
     *
     * @param t            待脱敏对象
     * @param sensitiveArr 敏感词数组
     * @return 脱敏后的对象
     */
    public static <T> T desensitization(T t, String[] sensitiveArr) {
        if (t == null) {
            return null;
        }
        if (t instanceof String) {
            String objStr = t.toString();
            for (String sensitiveStr : sensitiveArr) {
                // 替换敏感词
                objStr = objStr.replaceAll("(?i)" + sensitiveStr, generatorStar(sensitiveStr.length()));
            }
            t = (T) objStr;
        }
        return t;
    }

    /**
     * 是否包含敏感词
     *
     * @param obj          待检测对象
     * @param sensitiveArr 敏感词数组
     * @return
     */
    public static List<String> getSensitivesOfObj(Object obj, String[] sensitiveArr) {
        List<String> sensitives = new ArrayList<>();
        if (obj == null) {
            return sensitives;
        }
        if (obj instanceof String) {
            String objStr = obj.toString();
            for (String sensitiveStr : sensitiveArr) {
                if (objStr.toLowerCase().indexOf(sensitiveStr) > -1) {
                    sensitives.add(sensitiveStr);
                    continue;
                }
            }
        }
        return sensitives;
    }

    /**
     * 生成指定长度的*号
     *
     * @param len 长度
     * @return *字符串
     */
    static String generatorStar(int len) {
        String s = "";
        for (int i = 0; i < len; i++) {
            s += "*";
        }
        return s;
    }

    public static void main(String[] args) {
        String s = "huangcongsbshige2bnishuonesb2b";
        s = desensitization(s);
        System.out.println("脱敏后 " + s);
    }
}

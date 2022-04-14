package com.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @program: spring5_demo1
 * @author: yoki
 * @create: 2022-04-10 11:39
 */
public class WebUtils {
    public static <T> T copyParamToBean(T bean, Map parameterMap) {
        try {
            BeanUtils.populate(bean, parameterMap);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return bean;
    }

    public static int parseInt(String strInt,int defaultValue){
        try {
            return Integer.parseInt(strInt);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return defaultValue;
    }

    public static double parseDouble(String strDouble,double defaultValue){
        try {
            return Double.parseDouble(strDouble);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return defaultValue;
    }
}

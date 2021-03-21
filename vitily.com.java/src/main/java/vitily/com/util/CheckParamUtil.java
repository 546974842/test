package vitily.com.util;

import vitily.com.annotation.BigDecimalRangeValidator;
import vitily.com.annotation.IntegerRangeValidator;
import vitily.com.annotation.RegexValidator;
import vitily.com.annotation.RequireValidator;
import vitily.com.consts.ResultStatus;
import vitily.com.other_entity.CustomerException;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.List;

/**
 * creator : whh-lether
 * date    : 2018/12/25 12:00
 * desc    :
 **/
public class CheckParamUtil {

    public static void checkParam(Object obj) throws Exception {
        //判断参数是否合法
        Class <?> clazz = obj.getClass();
        for (; clazz != Object.class; clazz = clazz.getSuperclass()) {
            Field[] field = clazz.getDeclaredFields();
            for (Field f : field) {
                f.setAccessible(true);
                Object ov = f.get(obj);
                boolean isNull = CommonUtil.isNull(ov);
                //先判断是否有必填项
                RequireValidator require = f.getAnnotation(RequireValidator.class);
                if (CommonUtil.isNotNull(require) && isNull) {
                    String _name = require.paramName();
                    if(StringUtil.isEmpty(_name)){
                        _name = f.getName();
                    }
                    throw new CustomerException("参数[" + _name + "]必填", ResultStatus.参数不全);
                }
                if(CommonUtil.isNull(ov)){
                    continue;
                }
                if (ov instanceof Integer) {
                    //获取属性值上的ApiIntegerParamCheck注解
                    boolean hasRange = f.isAnnotationPresent(IntegerRangeValidator.class);
                    if (!hasRange) {
                        continue;
                    }
                    IntegerRangeValidator range = f.getAnnotation(IntegerRangeValidator.class);
                    if (!isNull) {
                        Integer value = (Integer) ov;
                        int min = range.min();
                        int max = range.max();
                        if (value < min || value > max) {
                            throw new CustomerException("参数[" + f.getName() + "]范围的范围应为：{" + min + "," + max + "}", ResultStatus.参数不符合要求);
                        }
                    }
                }else if(ov instanceof BigDecimal){
                    //获取属性值上的ApiIntegerParamCheck注解
                    boolean hasRange = f.isAnnotationPresent(BigDecimalRangeValidator.class);
                    if (!hasRange) {
                        continue;
                    }
                    BigDecimalRangeValidator range = f.getAnnotation(BigDecimalRangeValidator.class);
                    if (!isNull) {
                        BigDecimal value = (BigDecimal) ov;
                        double min = range.min();
                        double max = range.max();
                        if (value.doubleValue() < min || value.doubleValue() > max) {
                            throw new CustomerException("参数[" + f.getName() + "]范围的范围应为：{" + min + "," + max + "}", ResultStatus.参数不符合要求);
                        }
                    }
                }else if (ov instanceof String) {
                    boolean hasRegex = f.isAnnotationPresent(RegexValidator.class);
                    if (!hasRegex) {
                        continue;
                    }
                    if (!isNull) {
                        RegexValidator regex = f.getAnnotation(RegexValidator.class);
                        if (!((String) ov).matches(regex.regexStr())) {
                            throw new CustomerException(String.format(regex.errorContent(),f.getName(),regex.regexStr()), ResultStatus.参数不符合要求);
                        }
                    }
                } else if (ov instanceof List) {//数组
                    List list = (List) ov;
                    for (Object o : list) {
                        checkParam(o);
                    }
                } else if (ov.getClass().getName().indexOf("vitily") > -1) {//自定义类型，采用循环参数方式进行检测
                    //checkParam(ov);
                }
            }
        }
    }
}

package com.fadedos.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description:TODO
 * @author: pengcheng
 * @date: 2021/1/21
 */
public class MyDateConverter implements Converter<String, Date> {
    private String pattern; //此处运用了DI思想

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    /*
            converter方法作用: String --->Date
                               SimpleDateFormate sdf = new SimpleDateFormate();
                              sdf.parse(String) --->Date

          param : source 代表的是配置文件中 日期字符串 <value>2008-09-28</value>

          return : 当把转换好的Date作为converter方法的返回值后,Spring自动的为birthday属性进行注入(赋值)
         */
    @Override
    public Date convert(String source) {
        Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            date = sdf.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}

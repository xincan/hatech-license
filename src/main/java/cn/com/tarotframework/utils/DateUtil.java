package cn.com.tarotframework.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.util.comparator.Comparators;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 日期处理类
 */
@Slf4j
public class DateUtil {


    public static LocalDateTime strToDateTime(String str) {
        str = str.replace("年", "-").replace("月", "-").replace("日","");
        LocalDateTime date = LocalDateTime.parse(str, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        return date;
    }


    public static void main(String[] args) {
        LocalDateTime a = strToDateTime("2021年10月26日 10:20:06");
        System.out.println(a);


    }

}

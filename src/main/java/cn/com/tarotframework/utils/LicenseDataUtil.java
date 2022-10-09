package cn.com.tarotframework.utils;

import cn.com.tarotframework.server.oak.dto.ExcelData;
import com.alibaba.fastjson2.JSONObject;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;


public class LicenseDataUtil {

    public static List<ExcelData> getExcelData(String url) {
        Map<String, List<ExcelData>> excel = EasyExcelUtil.readExcelByData(url, ExcelData.class);
        // 将excel表格数据转换成集合
        List<ExcelData> dataList = new ArrayList<>();
        excel.forEach((key, value) -> dataList.addAll(value));
        return dataList;
    }
    public static void main(String[] args) {

        List<ExcelData> lists = getExcelData("D:\\hatech-hour\\license调整2022-10-09.xlsx");
        lists.forEach(System.out::println);
        System.out.println(lists.size());

        System.out.println("----------------------------------------------------------------------------------------");

        List<ExcelData> aa = lists.stream().collect(
                Collectors.collectingAndThen(
                Collectors.toCollection( () -> new TreeSet<>(Comparator.comparing(ExcelData::getMacUrl))),  ArrayList::new
                ));

        aa.forEach(System.out::println);
        System.out.println(aa.size());


    }

}

package com.atguigu.demo.excel;

import com.alibaba.excel.EasyExcel;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: AndrewBar
 * @Date: Created in 14:47 2021/1/11
 */
public class TestEasyExcel {
    public static void main(String[] args) {
        //实现excel写的操作
        //1.设置写入文件夹的地址和excel文件名称
       // String fileName = "F:\\write.xlsx";

        //2.调用EasyExcel方法进行操作
        //write方法中两个参数
        //EasyExcel.write(fileName,DemoData.class).sheet("设备信息").doWrite(getData());

        String fileName = "F:\\write.xlsx";
        EasyExcel.read(fileName,DemoData.class,new ExcelListener()).sheet().doRead();
    }
    //创建一个方法返回list集合
    private static List<DemoData> getData(){
        ArrayList<DemoData> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            DemoData data = new DemoData();
            data.setSno(i);
            data.setSname("zcw"+i);
            list.add(data);
        }
        return list;
    }
}

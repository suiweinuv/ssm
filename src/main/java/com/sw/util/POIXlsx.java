package com.sw.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class POIXlsx {

    public static void createExcel() {
        String[] title = {"id", "name"};
        //创建工作簿
        XSSFWorkbook workbook = new XSSFWorkbook();
        //创建工作表
        XSSFSheet sheet = workbook.createSheet();
        //创建第一行
        XSSFRow row = sheet.createRow(0);
        //单元格
        XSSFCell cell = null;
        //插入第一行数据
        for (int i = 0; i < title.length; i++) {
            cell = row.createCell(i);
            cell.setCellValue(title[i]);
        }
        //追加数据
        for (int i = 1; i < 4; i++) {
            XSSFRow nextRow = sheet.createRow(i);
            XSSFCell cell2 = null;
            cell2 = nextRow.createCell(0);
            cell2.setCellValue(i + "");
            cell2 = nextRow.createCell(1);
            cell2.setCellValue("name" + i);
        }
        File file = new File("d:/poi.xlsx");
        try {
            file.createNewFile();
            FileOutputStream stream = FileUtils.openOutputStream(file);
            workbook.write(stream);
            stream.close();
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<List<String>> readExcel1() {
        File file = new File("d:/demo.xlsx");
        List<List<String>> list_all = new ArrayList<List<String>>();
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(FileUtils.openInputStream(file));
            //获取名称为sheet0的工作表
            //XSSFSheet sheet = workbook.getSheet("sheet0");
            //根据索引获取
            XSSFSheet sheet = workbook.getSheetAt(0);
            int firstRowNum = 0;
            //sheet页中最后一行行号
            int lastRowNum = sheet.getLastRowNum();

            for (int i = firstRowNum; i <= lastRowNum; i++) {
                XSSFRow row = sheet.getRow(i);
                int lastCellNum = row.getLastCellNum();
                List<String> list = new ArrayList<String>();
                for (int j = 0; j < lastCellNum; j++) {
                    XSSFCell cell = row.getCell(j);
                    String value;

                    if (cell==null){
                        value ="";
                    }else {
                        cell.setCellType(Cell.CELL_TYPE_STRING);
                        value = cell.getStringCellValue();
                    }
                    list.add(value);

                   // System.out.print(value + " ");
                }
                list_all.add(list);


            }

            //System.out.println(list_all.toString());


        } catch (Exception e) {
            e.printStackTrace();
        }
        return list_all;
    }

    public static HashSet<String> readywlx1() {
        File file = new File("d:/ywlx.xlsx");
        HashSet<String> hs = new HashSet<String>();
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(FileUtils.openInputStream(file));
            XSSFSheet sheet = workbook.getSheetAt(0);
            int lastRowNum = sheet.getLastRowNum();
            for (int i = 0; i <= lastRowNum; i++) {
                XSSFRow row = sheet.getRow(i);
                XSSFCell cell = row.getCell(0);
                if (cell!=null){

                    cell.setCellType(Cell.CELL_TYPE_STRING);
                    hs.add(cell.getStringCellValue());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(hs.toString());
        return hs;
    }
    public static HashMap<String,HashSet<String>> readywlx2() {
        HashSet<String> hs1= readywlx1();
        File file = new File("d:/ywlx.xlsx");


        HashMap<String,HashSet<String>> map = new HashMap<>();
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(FileUtils.openInputStream(file));
            XSSFSheet sheet = workbook.getSheetAt(0);
            int lastRowNum = sheet.getLastRowNum();
            for (String s:hs1) {
                HashSet<String> hs2 = new HashSet<String>();
                for (int i = 0; i <= lastRowNum; i++) {
                    XSSFRow row = sheet.getRow(i);
                    XSSFCell cell1 = row.getCell(0);
                    if (cell1!=null){
                        cell1.setCellType(Cell.CELL_TYPE_STRING);
                        String cell1Value = cell1.getStringCellValue();
                        XSSFCell cell2 = row.getCell(1);
                        if (cell1Value.equals(s)&&cell2!=null){
                            cell2.setCellType(Cell.CELL_TYPE_STRING);
                            hs2.add(cell2.getStringCellValue());
                            //System.out.println(hs2.toString());
                        }
                    }
                }
               // System.out.println("-----------------------------------");
                map.put(s,hs2);

                //System.out.println(list.toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(map.toString());
        return map;
    }
}

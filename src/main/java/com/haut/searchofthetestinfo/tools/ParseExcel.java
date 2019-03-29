package com.haut.searchofthetestinfo.tools;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.haut.searchofthetestinfo.po.InfoTest;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.poi.ss.usermodel.*;

import org.apache.poi.ss.usermodel.Workbook;
import org.junit.jupiter.api.Test;

public class ParseExcel {
    public ParseExcel() {
    }


    public List<InfoTest> getExcelData(String path) throws IOException{
        File xlsFile  =  new File(path);
        List<InfoTest> infoTests = new ArrayList<InfoTest>();

        Workbook workbook = null;
        try {
            workbook = WorkbookFactory.create(xlsFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 表个数。
        int numberOfSheets = workbook.getNumberOfSheets();

        // 遍历表。
        for (int i = 0; i < numberOfSheets; i++) {
            Sheet sheet = workbook.getSheetAt(i);

            // 行数。
            int rowNumbers = sheet.getLastRowNum() + 1;

            // Excel第一行。
            Row temp = sheet.getRow(0);
            if (temp == null) {
                continue;
            }

            int cells = temp.getPhysicalNumberOfCells();


            // 读数据。
            for (int row = 0; row < rowNumbers; row++) {
                Row r = sheet.getRow(row);

                if (row>=1){
                    InfoTest infoTest= new InfoTest();

                    infoTest.setTest_id(toInt(r.getCell(0).toString()));
                    infoTest.setPerson_id(toInt(r.getCell(1).toString()));
                    infoTest.setName((r.getCell(2).toString()));
                    infoTest.setMajorOfApply((r.getCell(3).toString()));
                    infoTest.setInstituteOfApply((r.getCell(4).toString()));
                    infoTest.setForeignLanguage(toInt(r.getCell(5).toString()));
                    infoTest.setFirstCourse(toInt(r.getCell(6).toString()));
                    infoTest.setSecondCourse(toInt(r.getCell(7).toString()));
                    infoTest.setTotal(toInt(r.getCell(8).toString()));
                    System.out.println(infoTest);
                    infoTests.add(infoTest);

                }
                // 换行。
                System.out.println();
            }

        }
        System.out.println(infoTests);
        return infoTests;


    }
    public static void main(String args[]) throws IOException {
        ParseExcel parseExcel = new ParseExcel();
        List<InfoTest> list = parseExcel.getExcelData("E:\\成绩查询系统录入模板.xlsx");
        parseExcel.addToDatabaseAll(list);

    }


    public int  addToDatabaseOne (InfoTest infoTest)throws IOException{
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();



//        InfoTest test = sqlSession.selectOne("com.haut.searchofthetestinfo.mapper.InfoTestMapper.findById","1");
        int i = sqlSession.insert("com.haut.searchofthetestinfo.mapper.InfoTestMapper.insert",infoTest);
        sqlSession.commit();
        sqlSession.close();

//        System.out.println(test);

        return i;
    }


    public int addToDatabaseAll(List<InfoTest> list) throws IOException{
        int i = 0;
        for (Iterator<InfoTest> iterator = list.iterator();iterator.hasNext();){
            int temp = addToDatabaseOne(iterator.next());
            i+=temp;
        }
        return i;
    }

    public String  toInt(String  s){
        Float aFloat = Float.parseFloat(s);
        Integer i =Math.round(aFloat);
        System.out.println(i.toString());
        return i.toString();
    }
}

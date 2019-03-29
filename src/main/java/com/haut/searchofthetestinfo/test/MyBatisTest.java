package com.haut.searchofthetestinfo.test;

import com.haut.searchofthetestinfo.po.InfoTest;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;


import java.io.InputStream;

public class MyBatisTest {

    public static void main(String args[])throws Exception{
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        InfoTest infoTest = new InfoTest();
        infoTest.setForeignLanguage("2");
        infoTest.setFirstCourse("2");
        infoTest.setInstituteOfApply("2");
        infoTest.setMajorOfApply("2");
        infoTest.setName("2");
        infoTest.setPerson_id("2");
        infoTest.setTest_id("3");
        infoTest.setTotal("2");
        infoTest.setSecondCourse("2");


//        InfoTest test = sqlSession.selectOne("com.haut.searchofthetestinfo.mapper.InfoTestMapper.findById","1");
        sqlSession.insert("com.haut.searchofthetestinfo.mapper.InfoTestMapper.insert",infoTest);
        sqlSession.commit();
        sqlSession.close();

//        System.out.println(test);
    }
}

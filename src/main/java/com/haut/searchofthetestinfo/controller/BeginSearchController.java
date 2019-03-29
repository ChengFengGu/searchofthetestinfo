package com.haut.searchofthetestinfo.controller;

import com.haut.searchofthetestinfo.po.InfoTest;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.InputStream;

@Controller
public class BeginSearchController {
    @RequestMapping(value = "/beginSearch", method= RequestMethod.POST)

    public String search(@RequestParam("test_id") String test_id, @RequestParam("person_id") String person_id, ModelMap map)  {
        System.out.println("这里执行了吗？");
        String person_idOfDatabase = person_id.toString();
        InfoTest infoTest = null;

        try {
            infoTest = this.searchByPersonID( person_idOfDatabase );

            map.addAttribute("person_id",person_id);
            map.addAttribute("test_id",infoTest.getTest_id());
            map.addAttribute("name",infoTest.getName());
            map.addAttribute("foreignLanguage",infoTest.getForeignLanguage());
            map.addAttribute("firstCourse",infoTest.getFirstCourse());
            map.addAttribute("secondCourse",infoTest.getSecondCourse());
            map.addAttribute("total",infoTest.getTotal());
        } catch (Exception e) {
            e.printStackTrace();
            map.addAttribute("success","无结果");
            return "success.html";
        }

        return "result.html";
    }

    @RequestMapping("templates")
    public String toTemplates(){
        return "";
    }

    public InfoTest searchByPersonID(String person_id)throws Exception{
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        InfoTest test = sqlSession.selectOne("com.haut.searchofthetestinfo.mapper.InfoTestMapper.findById",person_id);

        System.out.println(test);
        return test;
    }
}

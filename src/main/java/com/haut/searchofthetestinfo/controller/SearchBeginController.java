package com.haut.searchofthetestinfo.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.haut.searchofthetestinfo.po.InfoTest;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.InputStream;
import java.util.Map;

@Controller
public class SearchBeginController {



    @RequestMapping("search")
    public String toSearch(){
        return "search.html";
    }


//---------------------
//    作者：尼斯湖水鬼
//    来源：CSDN
//    原文：https://blog.csdn.net/qq_31001665/article/details/71075743
//    版权声明：本文为博主原创文章，转载请附上博文链接！
}

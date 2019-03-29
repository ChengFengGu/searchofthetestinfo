package com.haut.searchofthetestinfo.controller;


import com.haut.searchofthetestinfo.po.InfoTest;
import com.haut.searchofthetestinfo.tools.ParseExcel;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

@Controller
@RequestMapping("/uploadAndDownload")
public class UploadAndDownloadFileController {
    @RequestMapping("/index")
    public String index() {
        return "uploadAndDownload.html";
    }



    @RequestMapping(value = "/uploadFileAction", method = RequestMethod.POST)
    public String uploadFileAction(@RequestParam("uploadFile") MultipartFile uploadFile, @RequestParam("id") Long id, ModelMap modelMap) {
        InputStream fis = null;
        OutputStream outputStream = null;
        try {
            fis = uploadFile.getInputStream();


            String path = "E:\\"+uploadFile.getOriginalFilename();
//            outputStream = new FileOutputStream(ClassUtils.getDefaultClassLoader().getResource("UploadAndDownloadFileController.class").getPath()+uploadFile.getOriginalFilename());
            outputStream = new FileOutputStream(path);
            IOUtils.copy(fis,outputStream);

            ParseExcel parseExcel  = new ParseExcel();
            List<InfoTest> list = parseExcel.getExcelData(path);
            parseExcel.addToDatabaseAll(list);
            modelMap.addAttribute("success","上传成功");
            System.out.println("执行测试");
            return "success.html";
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(outputStream != null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        modelMap.addAttribute("sucess", "上传失败!");
        return "success.html";
    }



    @RequestMapping("downloadFileAction")
    public void downloadFileAction(HttpServletRequest request, HttpServletResponse response) {

        response.setCharacterEncoding(request.getCharacterEncoding());
        response.setContentType("application/octet-stream");
        FileInputStream fis = null;
        try {
            File file = new File("G:\\config.ini");
            fis = new FileInputStream(file);
            response.setHeader("Content-Disposition", "attachment; filename="+file.getName());
            IOUtils.copy(fis,response.getOutputStream());
            response.flushBuffer();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }



}

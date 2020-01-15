package com.hsbc.fluent.Controller;

import com.hsbc.fluent.Config.AppSettings;
import com.hsbc.fluent.Entity.FileEntity;
import com.hsbc.fluent.Service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Controller
public class RequestController {
    @Autowired
    public FileEntity file;
    @Autowired
    public FileService fileService;
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private FileEntity fileEntity;
    @Autowired
    private AppSettings appSettings;
    @RequestMapping("/index")
    public String locationRequest(ModelMap map){
       ArrayList<Object> list = new ArrayList<>();
       file.setId("1");
       file.setPath("/Link/a");
       file.setSize("200M");
       list.add(file);
       map.put("Paths",list);
       map.put("msg","List");
       return "index_1";
    }
    @RequestMapping("/upload")
    public void upload(@RequestParam String path){
        System.out.println(path);
    }
    @RequestMapping("/indexFile")
    public String  indexFile(ModelMap mm){
        String uploadpath = appSettings.getUploadpath();
        ArrayList<FileEntity> entities = fileService.FileEntityList(uploadpath);
        mm.put("fileList",entities);
        return "index_1";
    }

}

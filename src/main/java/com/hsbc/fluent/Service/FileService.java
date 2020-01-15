package com.hsbc.fluent.Service;

import com.hsbc.fluent.Entity.FileEntity;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;

@Service
public class FileService {
    public static FileEntity fileTransform(String uploadpath) {
        ArrayList<FileEntity> list = new ArrayList<>();
        File file = new File(uploadpath);
        FileEntity entity = new FileEntity();
        entity.setPath(file.getPath());
        entity.setName(file.getName());
        if (!file.isDirectory()){
            entity.setType("file");
        }else if (file.isDirectory()){
            entity.setType("solder");
        }
        return entity;
    }
    public static ArrayList<FileEntity> FileEntityList(String uploadpath){
        ArrayList<FileEntity> list = new ArrayList<>();
        FileEntity entity = fileTransform(uploadpath);
        if (entity.getType()=="solder"){
            File fileFeed =new File(entity.getPath());
            String[] fileContent = fileFeed.list();
            for (String relativePath:fileContent){
                FileEntity fileEntity = fileTransform(uploadpath + relativePath);
                list.add(fileEntity);
            }
        }
        return  list;
    }

}

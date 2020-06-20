package com.dj.webapi.api.impl;

import com.alibaba.fastjson.JSONObject;
import com.dj.webapi.api.service.FileService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
public class FileServiceImpl implements FileService {
    @Autowired
    private HttpServletRequest request;

    @Override
    public String uploadFile(MultipartFile zipFile) {
        String fileName = zipFile.getOriginalFilename();
        try {
            String targetFilePath = ResourceUtils.getURL("classpath:").getPath()+"static/files/uploadFiles/";
            File targetFilePathFile = new File(targetFilePath);
            if(!targetFilePathFile.exists()){
                targetFilePathFile.mkdirs();
            }

            File targetFile = new File(targetFilePath + File.separator + fileName);
            FileOutputStream fileOutputStream = null;
            try {
                fileOutputStream = new FileOutputStream(targetFile);
                IOUtils.copy(zipFile.getInputStream(), fileOutputStream);
            } catch (IOException e) {
                e.printStackTrace();
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("resultCode","1");
                jsonObject.put("resultMsg","上传文件失败");
                jsonObject.put("filePath","");
                return jsonObject.toJSONString();
            } finally {
                try {
                    if(fileOutputStream!=null) {
                        fileOutputStream.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("resultCode","0");
        jsonObject.put("resultMsg","上传文件成功");
        jsonObject.put("filePath","http://127.0.0.1:8080/files/uploadFiles/"+fileName);
        return jsonObject.toJSONString();
    }
}

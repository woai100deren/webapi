package com.dj.webapi.api.controller;

import com.dj.webapi.api.service.AFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class AFileController {
    @Autowired
    AFileService service;

    @RequestMapping(value = "/upload")
    public String uploadFile(@RequestParam("uploadFile") MultipartFile zipFile){
        return service.uploadFile(zipFile);
    }
}

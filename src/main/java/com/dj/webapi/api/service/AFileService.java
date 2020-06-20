package com.dj.webapi.api.service;

import org.springframework.web.multipart.MultipartFile;

public interface AFileService {
    public String uploadFile(MultipartFile zipFile);
}

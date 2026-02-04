package com.company.artist_album_api.storage;

import org.springframework.web.multipart.MultipartFile;

public interface FileStorageService {

    String upload(MultipartFile file, String bucket, String objectName);

    String generatePresignedUrl(String bucket, String objectName);
}
package com.company.artist_album_api.storage;

import io.minio.GetPresignedObjectUrlArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.http.Method;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.concurrent.TimeUnit;

@Service
public class MinioFileStorageService implements FileStorageService {

    private final MinioClient minioClient;

    public MinioFileStorageService(MinioClient minioClient) {
        this.minioClient = minioClient;
    }

    @Override
    public String upload(MultipartFile file, String bucket, String objectName) {
        try (InputStream inputStream = file.getInputStream()) {

            minioClient.putObject(
                    PutObjectArgs.builder()
                            .bucket(bucket)
                            .object(objectName)
                            .stream(inputStream, file.getSize(), -1)
                            .contentType(file.getContentType())
                            .build()
            );

            return objectName;

        } catch (Exception e) {
            throw new RuntimeException("Erro ao realizar upload no MinIO", e);
        }
    }

    @Override
    public String generatePresignedUrl(String bucket, String objectName) {
        try {
            return minioClient.getPresignedObjectUrl(
                    GetPresignedObjectUrlArgs.builder()
                            .method(Method.GET)
                            .bucket(bucket)
                            .object(objectName)
                            .expiry(1, TimeUnit.HOURS)
                            .build()
            );
        } catch (Exception e) {
            throw new RuntimeException("Erro ao gerar presigned URL", e);
        }
    }
}
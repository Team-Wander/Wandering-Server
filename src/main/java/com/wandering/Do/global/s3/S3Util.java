package com.wandering.Do.global.s3;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.wandering.Do.global.s3.exception.FileExtensionInvalidException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class S3Util {
    @Value("{cloud.aws.s3.bucket}")
    private String bucket;

    private final AmazonS3 amazonS3;

    public String imageUpload(MultipartFile image) {
        try {
            List<String> list = List.of("jpg", "jpeg", "png");

            String[] splitFile = image.getOriginalFilename().split("\\.");

            if (splitFile.length > 2)
                throw new FileExtensionInvalidException();

            String extension = splitFile[1].toLowerCase();

            if (list.stream().noneMatch(it -> it.equals(extension)))
                throw new FileExtensionInvalidException();

            return upload(image);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String upload(MultipartFile image) throws IOException {
        String profileName = bucket + "/" + UUID.randomUUID() + image.getOriginalFilename();
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentLength(image.getInputStream().available());
        amazonS3.putObject(bucket, profileName, image.getInputStream(), metadata);
        return amazonS3.getUrl(bucket, profileName).toString();
    }

    public void deleteImage(String url) {
        String key = url.split("com/")[1];
        amazonS3.deleteObject(bucket, key);
    }
}

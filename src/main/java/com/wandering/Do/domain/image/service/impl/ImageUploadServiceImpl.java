package com.wandering.Do.domain.image.service.impl;

import com.wandering.Do.domain.image.presentation.dto.res.ImageUploadRes;
import com.wandering.Do.domain.image.service.ImageUploadService;
import com.wandering.Do.domain.image.util.ImageConverter;
import com.wandering.Do.global.annotation.ServiceWithTransactional;
import com.wandering.Do.global.s3.S3Util;
import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@ServiceWithTransactional
@RequiredArgsConstructor
public class ImageUploadServiceImpl implements ImageUploadService {

    private final S3Util s3Util;
    private final ImageConverter imageConverter;

    public ImageUploadRes execute(MultipartFile image) {

        String img_url = s3Util.imageUpload(image);
        return imageConverter.toDto(img_url);    }
}

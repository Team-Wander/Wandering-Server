package com.wandering.Do.domain.image.service;

import com.wandering.Do.domain.image.presentation.dto.res.ImageUploadRes;
import org.springframework.web.multipart.MultipartFile;

public interface ImageUploadService {
    ImageUploadRes execute(MultipartFile image);
}

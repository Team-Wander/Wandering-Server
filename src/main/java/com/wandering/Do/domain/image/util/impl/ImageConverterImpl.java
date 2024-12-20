package com.wandering.Do.domain.image.util.impl;

import com.wandering.Do.domain.image.presentation.dto.res.ImageUploadRes;
import com.wandering.Do.domain.image.util.ImageConverter;
import org.springframework.stereotype.Component;

@Component
public class ImageConverterImpl implements ImageConverter {
    @Override
    public ImageUploadRes toDto(String url) {
        return ImageUploadRes.builder()
                .url(url)
                .build();
    }
}

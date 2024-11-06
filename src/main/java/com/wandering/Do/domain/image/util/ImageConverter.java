package com.wandering.Do.domain.image.util;

import com.wandering.Do.domain.image.presentation.dto.res.ImageUploadRes;

public interface ImageConverter {
    ImageUploadRes toDto(String url);
}

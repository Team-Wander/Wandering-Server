package com.wandering.Do.domain.image.presentation;

import com.wandering.Do.domain.image.presentation.dto.res.ImageUploadRes;
import com.wandering.Do.domain.image.service.ImageUploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/my")
public class ImageController {
    private final ImageUploadService imageUploadService;

    @PostMapping
    public ResponseEntity<ImageUploadRes> upload(@RequestPart MultipartFile image) {
        ImageUploadRes response = imageUploadService.execute(image);
        return ResponseEntity.ok(response);
    }
}

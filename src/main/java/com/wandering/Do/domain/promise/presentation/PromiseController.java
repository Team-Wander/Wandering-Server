package com.wandering.Do.domain.promise.presentation;

import com.wandering.Do.domain.promise.presentation.dto.req.PromiseWriteReqDto;
import com.wandering.Do.domain.promise.service.WriteBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/home")
public class PromiseController {

    private final WriteBoardService writeBoardService;

    @PostMapping
    public ResponseEntity<Void> write(@RequestBody PromiseWriteReqDto writeReqDto) {

        writeBoardService.execute(writeReqDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}

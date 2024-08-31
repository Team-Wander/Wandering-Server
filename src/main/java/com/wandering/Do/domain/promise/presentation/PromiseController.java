package com.wandering.Do.domain.promise.presentation;

import com.wandering.Do.domain.promise.presentation.dto.req.PromiseWriteReq;
import com.wandering.Do.domain.promise.presentation.dto.res.PromiseGetListRes;
import com.wandering.Do.domain.promise.presentation.dto.res.PromiseGetRes;
import com.wandering.Do.domain.promise.service.GetBoardListService;
import com.wandering.Do.domain.promise.service.GetBoardService;
import com.wandering.Do.domain.promise.service.WriteBoardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/home")
public class PromiseController {

    private final WriteBoardService writeBoardService;
    private final GetBoardListService getBoardListService;
    private final GetBoardService getBoardService;

    @PostMapping
    public ResponseEntity<Void> write(@RequestBody @Valid PromiseWriteReq writeReqDto) {
        writeBoardService.execute(writeReqDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @GetMapping
    public ResponseEntity<List<PromiseGetListRes>> getList(@RequestParam String spot) {
        List<PromiseGetListRes> getListRes = getBoardListService.execute(spot);
        return ResponseEntity.ok(getListRes);
    }
    @GetMapping("/{pro_id}")
    public ResponseEntity<PromiseGetRes> get(@PathVariable("pro_id") Long id) {
        PromiseGetRes getRes = getBoardService.execute(id);
        return ResponseEntity.ok(getRes);
    }
}

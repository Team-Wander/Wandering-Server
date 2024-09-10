package com.wandering.Do.domain.promise.presentation;

import com.wandering.Do.domain.promise.entity.Tag;
import com.wandering.Do.domain.promise.presentation.dto.req.PromiseWriteReq;
import com.wandering.Do.domain.promise.presentation.dto.res.FilteredSearch.PromiseResponse;
import com.wandering.Do.domain.promise.presentation.dto.res.PromiseGetListRes;
import com.wandering.Do.domain.promise.presentation.dto.res.PromiseGetRes;
import com.wandering.Do.domain.promise.service.*;
import com.wandering.Do.domain.user.entity.Gender;
import com.wandering.Do.domain.user.entity.Grade;
import com.wandering.Do.domain.promise.presentation.dto.req.ReportPromiseReq;
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


    private final WritePromiseService writePromiseService;
    private final GetPromiseListService getPromiseListService;
    private final GetPromiseService getPromiseService;
    private final ApplyReqService applyReqService;

    private final GetFilterSearchService getFilterSearchService;
    private final ReportPromiseService reportPromiseService;
  
    @PostMapping
    public ResponseEntity<Void> write(@RequestBody @Valid PromiseWriteReq writeReqDto) {
        writePromiseService.execute(writeReqDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @GetMapping
    public ResponseEntity<List<PromiseGetListRes>> getList(@RequestParam String spot) {
        List<PromiseGetListRes> getListRes = getPromiseListService.execute(spot);
        return ResponseEntity.ok(getListRes);
    }
    @GetMapping("/{pro_id}")
    public ResponseEntity<PromiseGetRes> get(@PathVariable("pro_id") Long id) {
        PromiseGetRes getRes = getPromiseService.execute(id);
        return ResponseEntity.ok(getRes);
    }
    @GetMapping("/filter")
    public ResponseEntity<PromiseResponse> filterSearchPromises(
            @RequestParam List<Tag> tag,
            @RequestParam List<Gender> gender,
            @RequestParam List<Grade> grade) {
        PromiseResponse response = getFilterSearchService.execute(tag, gender, grade);

        return ResponseEntity.ok(response);
    }
    @PostMapping("/{pro_id}/declare")
    public ResponseEntity<Void> declare(
            @PathVariable("pro_id") Long id,
            @RequestBody @Valid ReportPromiseReq reportPromiseReq) {
        reportPromiseService.execute(reportPromiseReq, id);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PostMapping("/{pro_id}")
    public ResponseEntity<Void> applyPromise(@PathVariable("pro_id") Long id) {
        applyReqService.execute(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}

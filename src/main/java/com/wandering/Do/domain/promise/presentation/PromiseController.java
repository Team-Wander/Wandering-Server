package com.wandering.Do.domain.promise.presentation;

import com.wandering.Do.domain.promise.entity.Tag;
import com.wandering.Do.domain.promise.presentation.dto.req.PromiseWriteReq;
import com.wandering.Do.domain.promise.presentation.dto.res.FilteredSearch.PromiseResponse;
import com.wandering.Do.domain.promise.presentation.dto.res.PromiseGetListRes;
import com.wandering.Do.domain.promise.presentation.dto.res.PromiseGetRes;
import com.wandering.Do.domain.promise.service.GetPromiseListService;
import com.wandering.Do.domain.promise.service.GetPromiseService;
import com.wandering.Do.domain.promise.service.GetFilterSearchService;
import com.wandering.Do.domain.promise.service.WritePromiseService;
import com.wandering.Do.domain.user.entity.Gender;
import com.wandering.Do.domain.user.entity.Grade;
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

    private final GetFilterSearchService getFilterSearchService;

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
    public ResponseEntity<PromiseResponse> searchPromises(
            @RequestParam(required = false) List<Tag> tag,
            @RequestParam(required = false) List<Gender> gender,
            @RequestParam(required = false) List<Grade> grade) {
        PromiseResponse response = getFilterSearchService.execute(tag, gender, grade);

        return ResponseEntity.ok(response);
    }
}

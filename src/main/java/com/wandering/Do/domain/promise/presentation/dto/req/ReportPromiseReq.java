package com.wandering.Do.domain.promise.presentation.dto.req;

import com.wandering.Do.domain.declare.Reason;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

@Getter
@Builder
public class ReportPromiseReq {
    @NonNull
    private Reason reason;

    @NonNull
    private String content;
}

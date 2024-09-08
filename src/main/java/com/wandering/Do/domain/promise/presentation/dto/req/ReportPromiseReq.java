package com.wandering.Do.domain.promise.presentation.dto.req;

import com.wandering.Do.domain.declare.Reason;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

@Getter
@Builder
public class ReportPromiseReq {
    @NonNull
    private Reason reason;

    @Size(max = 500)
    private String content;
}

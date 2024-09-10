package com.wandering.Do.domain.promise.presentation.dto.req;

import com.wandering.Do.domain.declare.Reason;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReportPromiseReq {
    @NotNull
    private Reason reason;

    @Size(max = 500)
    private String content;
}

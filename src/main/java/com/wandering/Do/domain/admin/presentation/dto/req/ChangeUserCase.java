package com.wandering.Do.domain.admin.presentation.dto.req;

import com.wandering.Do.domain.declare.Case;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChangeUserCase {
    private Case changeCase;
}

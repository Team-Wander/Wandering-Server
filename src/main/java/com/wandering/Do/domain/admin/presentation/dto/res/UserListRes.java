package com.wandering.Do.domain.admin.presentation.dto.res;

import com.wandering.Do.domain.declare.Case;
import com.wandering.Do.domain.user.entity.Gender;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
public class UserListRes {
    private UUID userId;
    private String name;
    private String school;
    private Gender gender;
    private String profile;
    private Case aCase;
}

package com.wandering.Do.domain.auth.presentation.dto.request;

import com.wandering.Do.domain.user.entity.Grade;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserInfoReq {
    private String school;
    private Grade grade;
    private String spot;
}

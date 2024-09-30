package com.wandering.Do.domain.user.presentation.dto.res;

import com.wandering.Do.domain.user.entity.Gender;
import com.wandering.Do.domain.user.entity.Grade;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
public class GetWhoApplyPromiseRes {
    private UUID user_id;
    private String user_name;
    private String user_school;
    private Gender user_gender;
    private Grade user_grade;
    private String image;
}

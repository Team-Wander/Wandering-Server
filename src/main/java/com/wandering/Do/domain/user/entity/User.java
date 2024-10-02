package com.wandering.Do.domain.user.entity;

import com.wandering.Do.domain.auth.presentation.dto.request.UserInfoReq;
import com.wandering.Do.domain.declare.Case;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(generator = "UUID4")
    private UUID id;

    private String image;

    private String name;

    private String school;

    private String email;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String mobile;

    private String birthYear;

    private String spot;

    @Enumerated(EnumType.STRING)
    private Authority authority;

    @Enumerated(EnumType.STRING)
    private Grade grade;

    @Enumerated(EnumType.STRING)
    private Case aCase;

    public void filOutInfo (UserInfoReq userInfoReq) {
        this.school = userInfoReq.getSchool();
        this.grade = userInfoReq.getGrade();
        this.spot = userInfoReq.getSpot();
    }
}

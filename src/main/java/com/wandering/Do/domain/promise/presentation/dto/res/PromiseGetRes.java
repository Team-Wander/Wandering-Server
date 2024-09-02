package com.wandering.Do.domain.promise.presentation.dto.res;

import com.wandering.Do.domain.promise.entity.SelGender;
import com.wandering.Do.domain.promise.entity.Tag;
import com.wandering.Do.domain.user.entity.Grade;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Builder
public class PromiseGetRes {
    // user info
    private String author;
    private String author_school;
    private Grade author_grade;
    private String author_gender;
    private String author_profile;

    // promise
    private Long id;
    private String title;
    private String content;
    private List<Grade> Grade;
    private SelGender Gender;
    private LocalDate date;
    private Integer maximum;
    private List<Tag> tag;
}

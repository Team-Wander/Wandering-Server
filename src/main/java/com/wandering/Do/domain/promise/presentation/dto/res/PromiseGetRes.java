package com.wandering.Do.domain.promise.presentation.dto.res;

import com.wandering.Do.domain.promise.entity.SelGender;
import com.wandering.Do.domain.promise.entity.Tag;
import com.wandering.Do.domain.user.entity.Grade;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Builder
public class PromiseGetRes {

    private Long id;

    private String author;

    private String title;

    private String content;

    private LocalDate date;

    private Integer maximum;

    private SelGender gender;

    private List<Grade> grade;

    private List<Tag> tag;
}

package com.wandering.Do.domain.promise.presentation.dto.res;

import com.wandering.Do.domain.promise.entity.Promise;
import com.wandering.Do.domain.promise.entity.SelGender;
import com.wandering.Do.domain.promise.entity.Tag;
import com.wandering.Do.domain.user.entity.Grade;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Builder
public class PromiseGetListRes {
    // user info
    private String author;
    private String author_school;
    private Grade author_grade;
    private String author_gender;

    // promise
    private Long id;
    private String title;
    private String content;
    private List<Grade> Grade;
    private SelGender Gender;
    private LocalDate date;
    private Integer maximum;
    private List<Tag> tag;

    public static PromiseGetListRes toDto(Promise promise) {

        return PromiseGetListRes.builder()
                //user info
                .author(promise.getUser().getName())
                .author_school(promise.getUser().getSchool())
                .author_grade(promise.getUser().getGrade())
                .author_gender(promise.getUser().getGender())
                // promise
                .id(promise.getId())
                .title(promise.getTitle())
                .content(promise.getContent())
                .Grade(promise.getGrade())
                .Gender(promise.getGender())
                .date(promise.getDate())
                .maximum(promise.getMaximum())
                .tag(promise.getTags())
                .build();
    }
}

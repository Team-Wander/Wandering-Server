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
    private Long id;

    private String author;

    private String title;

    private String content;

    private LocalDate date;

    private Integer maximum;

    private SelGender gender;

    private List<Grade> grade;

    private List<Tag> tag;

    public static PromiseGetListRes toDto(Promise promise) {

        return PromiseGetListRes.builder()
                .id(promise.getId())
                .title(promise.getTitle())
                .content(promise.getContent())
                .date(promise.getDate())
                .author(promise.getUser().getName())
                .maximum(promise.getMaximum())
                .gender(promise.getGender())
                .grade(promise.getGrade())
                .tag(promise.getTags())  // Promise 엔티티의 Tag 리스트를 그대로 전달
                .build();
    }
}

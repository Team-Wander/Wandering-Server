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
    private String userSchool;
    private Grade userGrade;
    private String userGender;

    // promise
    private Long id;
    private String title;
    private String content;
    private List<Grade> proGrade;
    private SelGender proGender;
    private LocalDate date;
    private Integer maximum;
    private List<Tag> tag;

    public static PromiseGetListRes toDto(Promise promise) {

        return PromiseGetListRes.builder()
                //user info
                .author(promise.getUser().getName())
                .userSchool(promise.getUser().getSchool())
                .userGrade(promise.getUser().getGrade())
                .userGender(promise.getUser().getGender())
                // promise
                .id(promise.getId())
                .title(promise.getTitle())
                .content(promise.getContent())
                .proGrade(promise.getGrade())
                .proGender(promise.getGender())
                .date(promise.getDate())
                .maximum(promise.getMaximum())
                .tag(promise.getTags())
                .build();
    }
}

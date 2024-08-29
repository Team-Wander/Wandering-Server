package com.wandering.Do.domain.promise.presentation.dto.res;

import com.wandering.Do.domain.promise.entity.Promise;
import com.wandering.Do.domain.promise.entity.Tag;
import com.wandering.Do.domain.user.entity.Grade;
import com.wandering.Do.domain.user.entity.User;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Builder
public class BoardGetListRes {
    private Long id;

    private String author;

    private String title;

    private String content;

    private LocalDate date;

    private Integer maximum;

    private Grade grade;

    private List<Tag> tag;

    public static BoardGetListRes toDto(Promise promise) {
        String authorName = (promise.getUser() != null) ? promise.getUser().getName() : "Unknown";

        return BoardGetListRes.builder()
                .id(promise.getId())
                .title(promise.getTitle())
                .content(promise.getContent())
                .date(promise.getDate())
                .author(authorName)
                .maximum(promise.getMaximum())
                .grade(promise.getGrade())
                .tag(promise.getTags())  // Promise 엔티티의 Tag 리스트를 그대로 전달
                .build();
    }
}

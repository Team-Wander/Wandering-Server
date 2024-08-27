package com.wandering.Do.domain.promise.presentation.dto.res;

import com.wandering.Do.domain.promise.entity.Promise;
import com.wandering.Do.domain.promise.entity.Tag;
import com.wandering.Do.domain.user.entity.User;
import com.wandering.Do.domain.user.util.UserUtil;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Builder
public class GetPromiseListResDto {
    private Long id;
    private String author;
    private String title;
    private String content;
    private LocalDate date;
    private Integer maximum;
    private List<Tag> tag;

    public static GetPromiseListResDto toDto(Promise promise, String author){
        return GetPromiseListResDto.builder()
                .id(promise.getId())
                .author(author)
                .title(promise.getTitle())
                .content(promise.getContent())
                .date(promise.getDate())
                .maximum(promise.getMaximum())
                .tag(promise.getTags())
                .build();
    }
}

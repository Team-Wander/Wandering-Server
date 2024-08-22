package com.wandering.Do.domain.promise.presentation.dto.req;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.wandering.Do.domain.promise.entity.Contact;
import com.wandering.Do.domain.promise.entity.Tag;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Getter
@NoArgsConstructor
public class PromiseWriteReqDto {

    @NotNull
    @Size(max = 30)
    private String title;

    @NotNull
    @Size(max = 300)
    private String content;

    private Contact contact;

    private LocalDate date;

    private String spot;

    private Integer maximum;

    @NotNull
    private List<Tag> tags;
}

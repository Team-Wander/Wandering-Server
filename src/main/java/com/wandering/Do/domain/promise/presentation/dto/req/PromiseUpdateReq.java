package com.wandering.Do.domain.promise.presentation.dto.req;


import com.wandering.Do.domain.promise.entity.Contact;
import com.wandering.Do.domain.user.entity.Gender;
import com.wandering.Do.domain.promise.entity.Tag;
import com.wandering.Do.domain.user.entity.Grade;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class PromiseUpdateReq {

    @NotNull
    @Size(max = 30)
    private String title;

    @NotNull
    @Size(max = 300)
    private String content;

    private Contact contact;

    private String spot;

    private Integer maximum;

    private List<Grade> grade;

    private Gender gender;

    private List<Tag> tags;
}

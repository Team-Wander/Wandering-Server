package com.wandering.Do.domain.admin.presentation.dto.res;

import com.wandering.Do.domain.declare.Reason;
import com.wandering.Do.domain.promise.entity.Contact;
import com.wandering.Do.domain.promise.entity.Tag;
import com.wandering.Do.domain.user.entity.Gender;
import com.wandering.Do.domain.user.entity.Grade;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Builder
public class ReportInfoRes {
    private String author;
    private String author_school;
    private Grade author_grade;
    private String author_gender;
    private Reason reason;
    private String content;
    private Long id;
    private String title;
    private List<Grade> grade;
    private Gender gender;
    private LocalDate date;
    private Integer maximum;
    private List<Tag> tag;
    private Contact contact;
}

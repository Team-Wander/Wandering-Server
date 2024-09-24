package com.wandering.Do.domain.promise.entity;

import com.wandering.Do.domain.user.entity.Gender;
import com.wandering.Do.domain.user.entity.Grade;
import com.wandering.Do.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Promise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    private LocalDate date;

    private String spot;

    private Integer maximum;

    @Embedded
    private Contact contact;

    @ElementCollection
    @CollectionTable(name = "tags", joinColumns = @JoinColumn(name = "promise_id"))
    @Enumerated(EnumType.STRING)
    private List<Tag> tags;

    @ElementCollection
    @CollectionTable(name = "grade", joinColumns = @JoinColumn(name = "promise_id"))
    @Enumerated(EnumType.STRING)
    private List<Grade> grade;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}

package com.wandering.Do.domain.promise.entity;

import com.wandering.Do.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

    private String data;

    private String spot;

    private Integer maximum;

    @Enumerated(EnumType.STRING)
    private List<Tag> tags;

    @Embedded
    private Contact contact;

    @Enumerated(EnumType.STRING)
    private Stats stats;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}

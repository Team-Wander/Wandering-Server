package com.wandering.Do.domain.promise.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Contact {
    private String instagram;
    private String discord;
    private String kakao;
    private String email;
}

package com.wandering.Do.domain.declare.entity;

import com.wandering.Do.domain.declare.Reason;
import com.wandering.Do.domain.promise.entity.Promise;
import com.wandering.Do.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Report {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @Enumerated(EnumType.STRING)
    private Reason reason;

    @JoinColumn(name = "promise_id")
    private Long promiseId;

    @JoinColumn(name = "user_id")
    private UUID userId;
}

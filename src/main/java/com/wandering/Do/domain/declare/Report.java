package com.wandering.Do.domain.declare;

import com.wandering.Do.domain.promise.entity.Promise;
import com.wandering.Do.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

    @ManyToOne
    @JoinColumn(name = "promise_id")
    private Promise promise;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}

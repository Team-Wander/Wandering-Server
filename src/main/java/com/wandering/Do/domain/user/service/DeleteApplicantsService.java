package com.wandering.Do.domain.user.service;

import java.util.UUID;

public interface DeleteApplicantsService {
    void execute(Long promiseId, UUID userId);
}

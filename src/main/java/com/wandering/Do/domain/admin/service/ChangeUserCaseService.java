package com.wandering.Do.domain.admin.service;

import com.wandering.Do.domain.admin.presentation.dto.req.ChangeUserCase;
import com.wandering.Do.domain.declare.Case;

import java.util.UUID;

public interface ChangeUserCaseService {
    void execute (UUID userId, ChangeUserCase changeUserCase);
}

package com.wandering.Do.domain.auth.service;

import jakarta.servlet.http.HttpServletRequest;

public interface LogoutService {
    void execute(HttpServletRequest request);
}

package com.wandering.Do.domain.admin.service;

import com.wandering.Do.domain.admin.presentation.dto.res.UserListRes;

import java.util.List;

public interface GetUserListService {
    List<UserListRes> execute();
}

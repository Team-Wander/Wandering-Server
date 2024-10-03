package com.wandering.Do.domain.admin.service;

import com.wandering.Do.domain.admin.presentation.dto.res.SearchUserInfoRes;

import java.util.List;

public interface SearchUserInfoService {
    List<SearchUserInfoRes> execute(String name);
}

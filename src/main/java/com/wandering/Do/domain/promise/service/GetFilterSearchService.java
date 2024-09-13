package com.wandering.Do.domain.promise.service;

import com.wandering.Do.domain.promise.entity.Tag;
import com.wandering.Do.domain.promise.presentation.dto.res.PromiseFilterSearchRes;
import com.wandering.Do.domain.user.entity.Gender;
import com.wandering.Do.domain.user.entity.Grade;

import java.util.List;

public interface GetFilterSearchService {
    PromiseFilterSearchRes execute(List<Tag> tag, List<Gender> gender, List<Grade> grade);
}

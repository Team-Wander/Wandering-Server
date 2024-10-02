package com.wandering.Do.domain.admin.util;

import com.wandering.Do.domain.admin.presentation.dto.res.ReportInfoRes;
import com.wandering.Do.domain.admin.presentation.dto.res.ReportListRes;
import com.wandering.Do.domain.admin.presentation.dto.res.UserListRes;
import com.wandering.Do.domain.declare.entity.Report;
import com.wandering.Do.domain.promise.entity.Promise;
import com.wandering.Do.domain.user.entity.User;

public interface AdminConverter {
    ReportListRes toListDto(Promise promise, Report report);

    ReportInfoRes toDto (Promise promise, Report report);

    UserListRes toUserDto(User user);
}

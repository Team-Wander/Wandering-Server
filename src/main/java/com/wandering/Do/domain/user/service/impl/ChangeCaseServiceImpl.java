package com.wandering.Do.domain.user.service.impl;

import com.wandering.Do.domain.declare.Case;
import com.wandering.Do.domain.user.entity.User;
import com.wandering.Do.domain.user.service.ChangeCaseService;
import com.wandering.Do.domain.user.util.UserUtil;
import com.wandering.Do.global.annotation.ServiceWithTransactional;
import lombok.RequiredArgsConstructor;

@ServiceWithTransactional
@RequiredArgsConstructor
public class ChangeCaseServiceImpl implements ChangeCaseService {

    private final UserUtil userUtil;

    public void execute() {
        User user = userUtil.getCurrentUser();

        if (user.getBan()== 0) {
            user.changeCase(Case.NORMAL, 0);
        } else user.deducted();
    }
}

package com.wandering.Do.domain.user.scheduler;

import com.wandering.Do.domain.user.service.ChangeCaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserCaseChangeScheduler {

    private final ChangeCaseService changeCaseService;

    @Scheduled(cron = "0 0 0 * * *", zone = "Asia/Seoul")
    public void run() {
        changeCaseService.execute();
    }
}

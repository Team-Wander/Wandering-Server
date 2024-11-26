package com.wandering.Do.global.healthCheck;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class OtherServerHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        // 커스텀 로직 예시
        boolean isDatabaseUp = checkDatabaseConnection(); // 데이터베이스 연결 확인 로직
        if (isDatabaseUp) {
            return Health.up().withDetail("Database", "Running").build();
        }
        return Health.down().withDetail("Database", "Down").build();
    }

    private boolean checkDatabaseConnection() {
        // 여기서 실제 DB 연결 확인 로직을 구현
        return true; // 예제: 항상 정상
    }
}

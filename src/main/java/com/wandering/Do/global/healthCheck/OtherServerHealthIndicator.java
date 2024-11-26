package com.wandering.Do.global.healthCheck;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class OtherServerHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        boolean isDatabaseUp = checkDatabaseConnection();
        if (isDatabaseUp) {
            return Health.up().withDetail("Database", "Running").build();
        }
        return Health.down().withDetail("Database", "Down").build();
    }

    private boolean checkDatabaseConnection() {
        return true;
    }
}

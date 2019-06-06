package com.example.demo.health;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.health.Health;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@Health
@ApplicationScoped
public class ServiceHealthCheck implements HealthCheck {
	
    @Inject
    @ConfigProperty(name = "build.version")
    private String buildVersion;

    @Inject
    @ConfigProperty(name = "build.date")
    private String buildDate;
    
    @Override
    public HealthCheckResponse call() {

        return HealthCheckResponse.named(ServiceHealthCheck.class.getSimpleName()).up().withData("buildVersion", this.buildVersion).withData("buildDate", this.buildDate).build();

    }
}

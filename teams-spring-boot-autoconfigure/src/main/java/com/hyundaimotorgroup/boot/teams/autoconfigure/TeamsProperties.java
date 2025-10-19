package com.hyundaimotorgroup.boot.teams.autoconfigure;

import jakarta.validation.constraints.NotEmpty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

// FIXME: 2-2 TeamsProperties 살펴보기
@ConfigurationProperties(prefix = "teams")
@Validated
public record TeamsProperties(@NotEmpty String incomingWebhookUrl) {
}

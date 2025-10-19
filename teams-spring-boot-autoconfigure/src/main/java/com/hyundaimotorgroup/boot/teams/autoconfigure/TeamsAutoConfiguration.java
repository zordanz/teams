package com.hyundaimotorgroup.boot.teams.autoconfigure;

import com.hyundaimotorgroup.boot.teams.TeamsIncomingWebhookable;
import com.hyundaimotorgroup.boot.teams.TeamsTemplate;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

// FIXME: 2-1 TeamsAutoConfiguration 살펴보기
@AutoConfiguration
@ConditionalOnMissingBean(TeamsIncomingWebhookable.class)
@EnableConfigurationProperties(TeamsProperties.class)
public class TeamsAutoConfiguration {

    @Bean
    public TeamsTemplate teamsTemplate(TeamsProperties properties) {
        return new TeamsTemplate(properties.incomingWebhookUrl());
    }
}

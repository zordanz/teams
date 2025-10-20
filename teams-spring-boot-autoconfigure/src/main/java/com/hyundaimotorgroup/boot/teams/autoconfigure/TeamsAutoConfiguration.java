package com.hyundaimotorgroup.boot.teams.autoconfigure;

import com.hyundaimotorgroup.boot.teams.TeamsIncomingWebhookable;
import com.hyundaimotorgroup.boot.teams.TeamsTemplate;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

// TODO: 2. AutoConfiguration 완성하기
// Auto Configuration 설정
// TeamsIncomingWebhookable를 구현한 Bean이 없는 경우 생성되게 설정
// TeamsProperties를 사용할 수 있게 설정
public class TeamsAutoConfiguration {

    @Bean
    public TeamsTemplate teamsTemplate(TeamsProperties properties) {
        return new TeamsTemplate(properties.incomingWebhookUrl());
    }
}

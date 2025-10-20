package com.hyundaimotorgroup.boot.starter;

import com.hyundaimotorgroup.boot.teams.TeamsIncomingWebhookable;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SpringBootStarterApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootStarterApplication.class, args);
    }
}

@RestController
@RequiredArgsConstructor
class TeamsMessageController {
    // FIXME: 5-1. teamsTemplate 의존성 추가 from TeamsAutoConfiguration
    private final TeamsIncomingWebhookable teamsTemplate;

    // TODO: 4. 해당 API로 테스트
    /**
     * Teams에 Text 메시지를 전송하는 API
     */
    @PostMapping("/teams/messages")
    public void message(@RequestBody TeamsMessage body) {
        teamsTemplate.send(body.text());
    }
}

record TeamsMessage(String text) {
}

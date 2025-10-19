package com.hyundaimotorgroup.boot.teams;

import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;

// FIXME: 2-3 TeamsTemplate 살펴보기
/**
 * Teams 를 통한 요청
 */
@SuppressWarnings("ClassCanBeRecord")
public class TeamsTemplate implements TeamsIncomingWebhookable {
    private final RestClient restClient;

    public TeamsTemplate(String incomingWebhookUrl) {
        this.restClient = RestClient.create(incomingWebhookUrl);
    }

    /**
     * Teams Incoming Webhook을 통해서 Text 메시지 발송
     */
    @Override
    public void send(String message) {
        restClient.post()
            .contentType(MediaType.APPLICATION_JSON)
            .body(new TeamsSimpleMessage(message))
            .retrieve().toBodilessEntity();
    }
}

package com.br.rodrigoarcanjo.picpaydesafio.authorization;


import org.springframework.boot.autoconfigure.pulsar.PulsarProperties.Transaction;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class AuthorizerService {
    private RestClient restClient;

    public AuthorizerService(RestClient.Builder builder) {
        this.restClient = builder
        .baseUrl("https://run.mocky.io/v3/031c9e3a-d4ad-4f81-8ed0-8005ba1c5116")
        .build();
    }

    public void authorize(Transaction transaction) {
        var response = restClient.get()
            .retrieve()
            .toEntity(Authorization.class);

            if(response.getStatusCode().isError() || !response.getBody().isAuthorized()) {
                throw new UnauthorizedTransactionException("Unauthorized transaction!");
            }
    }
}

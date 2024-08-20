package com.br.rodrigoarcanjo.picpaydesafio.notification;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.br.rodrigoarcanjo.picpaydesafio.transaction.Transaction;

@Service
public class NotificationConsumer {
  private static final Logger LOGGER = LoggerFactory.getLogger(NotificationConsumer.class);
  private RestClient restClient;

  // Instável: http://o4d9z.mocklab.io/notify
  public NotificationConsumer(RestClient.Builder builder) {
    this.restClient = builder.baseUrl(
        "https://run.mocky.io/v3/e1ccf4af-6b9b-416c-95df-91ce05ff9a7f")
        .build();
  }

  @KafkaListener(topics = "transaction-notification", groupId = "picpay-desafio-backend")
  public void receiveNotification(Transaction transaction) {
    LOGGER.info("notifying transaction {}...", transaction);

    var response = restClient.get().retrieve().toEntity(Notification.class);

    if (response.getStatusCode().isError() || !response.getBody().message())
      throw new NotificationException("Error notifying transaction " + transaction);

    LOGGER.info("notification has been sent {}...", response.getBody());
  }
}
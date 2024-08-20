package com.br.rodrigoarcanjo.picpaydesafio.authorization;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.br.rodrigoarcanjo.picpaydesafio.transaction.Transaction;
import com.br.rodrigoarcanjo.picpaydesafio.transaction.UnauthorizedTransactionException;

@Service
public class AuthorizerService {
  private static final Logger LOGGER = LoggerFactory.getLogger(AuthorizerService.class);
  private RestClient restClient;

  public AuthorizerService(RestClient.Builder builder) {
    this.restClient = builder.baseUrl(
        "https://run.mocky.io/v3/e1ccf4af-6b9b-416c-95df-91ce05ff9a7f").build();
  }

  public void authorize(Transaction transaction) {
    LOGGER.info("authorizing transaction {}...", transaction);

    var response = restClient.get().retrieve().toEntity(Authorization.class);
    if (response.getStatusCode().isError() || !response.getBody().isAuthorized())
      throw new UnauthorizedTransactionException("Unauthorized!");
  }
}

record Authorization(String message) {
  public boolean isAuthorized() {
    return message.equals("Autorizado");
  }
}

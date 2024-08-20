package com.br.rodrigoarcanjo.picpaydesafio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jdbc.repository.config.EnableJdbcAuditing;

@EnableJdbcAuditing
@SpringBootApplication
public class PicpayDesafioApplication {

	public static void main(String[] args) {
		SpringApplication.run(PicpayDesafioApplication.class, args);
	}

}

package com.fakeitau.desafioconta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
@EnableFeignClients(basePackages = "com.fakeitau.desafioconta.infrastructure.client")
public class DesafiocontaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafiocontaApplication.class, args);
	}

}

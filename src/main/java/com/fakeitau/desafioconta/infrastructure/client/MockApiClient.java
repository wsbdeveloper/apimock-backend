package com.fakeitau.desafioconta.infrastructure.client;


import com.fakeitau.desafioconta.application.controller.web.dtos.MockResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "MockClient", url = "${mock.api.url}")
public interface MockApiClient {
    @GetMapping("/contas/{id}")
    MockResponse consultaContaExterno(@PathVariable String id);
}

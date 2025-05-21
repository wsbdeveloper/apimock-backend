package com.apimock.backendpoc.infrastructure.client;


import com.apimock.backendpoc.application.controller.web.dtos.ConsultaRespostaMock;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "MockClient", url = "${mock.api.url}")
public interface MockApiClient {
    @GetMapping("/contas/{id}")
    ConsultaRespostaMock consultaContaExterno(@PathVariable String id);
}

package com.fakeitau.desafioconta.controller;

import com.fakeitau.desafioconta.application.controller.ContaController;
import com.fakeitau.desafioconta.application.controller.web.dtos.ConsultaRespostaController;
import com.fakeitau.desafioconta.application.controller.web.dtos.ConsultaRespostaMock;
import com.fakeitau.desafioconta.domain.Conta;
import com.fakeitau.desafioconta.infrastructure.client.MockApiClient;
import com.fakeitau.desafioconta.infrastructure.client.repository.ConsultaRepository;
import com.fakeitau.desafioconta.model.entity.Consultas;
import com.fakeitau.desafioconta.service.ContaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

public class ContaControllerTests {
    // OBS: Teste da controler que contempla também a chamada a api externa
    @Mock
    private ContaService contaService;

    @Mock
    private MockApiClient client;

    @InjectMocks
    private ContaController contaController;


    @Mock
    private ConsultaRepository repository;


    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(contaController).build();
    }

    @Test
    void testBuscarDadosConta() throws Exception {
        String idConta = "5df13be4-423e-42a2-8932-0dbf6acd3b29";

        // Criando uma instância de Conta com os dados fictícios
        Conta conta = new Conta(
                idConta,
                "6315",
                "0093149",
                "8",
                "10fa8077-2g27-44eb-8d12-7a3d6290ca35",
                "300.00"

        );

        ConsultaRespostaController consultaRespostaController = new ConsultaRespostaController(
                conta.saldo()
        );
        when(contaService.consultarConta(idConta)).thenReturn(consultaRespostaController);

        // Realizando a requisição GET para o controlador
        mockMvc.perform(get("/conta/{idConta}", idConta)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.saldo").value("300.00"));
    }

    @Test
    void testBuscarDadosConta_ErroInterno() throws Exception {
        when(contaService.consultarConta("222"))
                .thenReturn(null);
        mockMvc.perform(get("/conta/222")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadGateway());
    }
}

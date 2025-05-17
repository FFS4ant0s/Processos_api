package com.seatecnologia.processos_api.controller;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.seatecnologia.processos_api.repository.ProcessoRepository;
import com.seatecnologia.processos_api.models.Processo;

@WebMvcTest(ProcessoController.class)
public class ProcessoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ProcessoRepository processoRepository;

    @Test
    public void testGetProcessos() throws Exception {
        Processo processo = new Processo(
                "2024-00001", 
                "Teste de processo", 
                LocalDate.now(), 
                "Aberto"
        );
        processo.setId(1L);

        Mockito.when(processoRepository.findAll())
                .thenReturn(Arrays.asList(processo));

        mockMvc.perform(get("/processos")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath("$[0].numeroProcesso").value("2024-00001"))
                .andExpect(jsonPath("$[0].assunto").value("Teste de processo"))
                .andExpect(jsonPath("$[0].status").value("Aberto"));
    }
}

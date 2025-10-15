package com.osg.cidadesinteligentes;

import com.osg.cidadesinteligentes.controller.CidadeController;
import com.osg.cidadesinteligentes.model.Cidade;
import com.osg.cidadesinteligentes.service.CidadeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CidadeController.class)
public class CidadeControllerTest {
    
    @Autowired
    private MockMvc mockMvc;
    
    @MockBean
    private CidadeService cidadeService;
    
    @Test
    public void testListarTodas() throws Exception {
        Cidade cidade = new Cidade("São Paulo", "SP", 12000000, 8.5, "Energia solar, transporte público");
        when(cidadeService.listarTodas()).thenReturn(Arrays.asList(cidade));
        
        mockMvc.perform(get("/api/cidades"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nome").value("São Paulo"));
    }
    
    @Test
    public void testBuscarPorId() throws Exception {
        Cidade cidade = new Cidade("São Paulo", "SP", 12000000, 8.5, "Energia solar");
        cidade.setId(1L);
        when(cidadeService.buscarPorId(1L)).thenReturn(Optional.of(cidade));
        
        mockMvc.perform(get("/api/cidades/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("São Paulo"));
    }
    
    @Test
    public void testHealthCheck() throws Exception {
        mockMvc.perform(get("/api/cidades/health"))
                .andExpect(status().isOk())
                .andExpect(content().string("API Cidades osg Inteligentes está funcionando!"));
    }
}

package com.ceiba.usuario.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.controlador.ComandoControladorEnvio;
import com.ceiba.usuario.comando.ComandoCotizacion;
import com.ceiba.usuario.comando.ComandoEnvio;
import com.ceiba.usuario.servicio.testdatabuilder.ComandoEnvioTestDataBuilder;
import com.ceiba.usuario.servicio.testdatabuilder.ComandoCotizacionTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ComandoControladorEnvio.class)
@ContextConfiguration(classes = ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ComandoControladorUsuarioEnvioTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Test
    void deberiaCrearUsuarioEnvio() throws Exception {
        ComandoEnvio comandoEnvio = new ComandoEnvioTestDataBuilder().build();

        mocMvc.perform(post("/envios/registro")
                        .content(objectMapper.writeValueAsString(comandoEnvio))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated()
                );
    }

    @Test
    void deberiaGenerarUnaCotizacion() throws Exception {
        ComandoCotizacion comandoCotizacion = new ComandoCotizacionTestDataBuilder().build();

        mocMvc.perform(
                        post("/envios")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(comandoCotizacion)))
                .andExpect(status().isOk())
        ;

    }

    @Test
    void deberiaEliminarUnUsuario() throws Exception {
        // arrange
        Long id = 1L;
        // act - assert
        mocMvc.perform(delete("/envios?id={id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        mocMvc.perform(get("/envios")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)));
    }
}

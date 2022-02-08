package com.ceiba.usuario.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.usuario.modelo.entidad.UsuarioEnvio;
import com.ceiba.usuario.servicio.testdatabuilder.EnvioTestDataBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UsuarioEnvioTest {

    @Test
    void deberiaCrearElEnvioCorrectamente() {

        UsuarioEnvio usuarioEnvio = new EnvioTestDataBuilder()
                .conId(1L)
                .build();

        assertEquals(1, usuarioEnvio.getId());
        assertEquals("NombreEnvio", usuarioEnvio.getNombre());
        assertEquals("password", usuarioEnvio.getClave());
        assertEquals(true, usuarioEnvio.isPremium());
    }

    @Test
    void deberiaFallarSinNombre() {

        EnvioTestDataBuilder envioTestDataBuilder = new EnvioTestDataBuilder()
                .conNombre(null)
                .conId(1L);

        BasePrueba.assertThrows(() -> {
                    envioTestDataBuilder.build();
                }, ExcepcionValorObligatorio.class, "Se requiere ingresar el nombre del usuario"
        );
    }

    @Test
    void deberiaFallarSinClave(){

        EnvioTestDataBuilder envioTestDataBuilder = new EnvioTestDataBuilder()
                .conId(1L)
                .conClave(null);

        BasePrueba.assertThrows(() -> {
                    envioTestDataBuilder.build();
                }, ExcepcionValorObligatorio.class, "Se requiere ingresar un contraseña"
        );

    }
}

package com.ceiba.usuario.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.usuario.modelo.entidad.UsuarioEnvio;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuarioEnvio;
import com.ceiba.usuario.servicio.testdatabuilder.EnvioTestDataBuilder;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServicioCrearUsuarioEnvioTest {

    @Test
    void deberiaCrearDeManeraExitosa() {
        UsuarioEnvio usuarioEnvio = new EnvioTestDataBuilder().build();
        RepositorioUsuarioEnvio repositorioUsuarioEnvio = Mockito.mock(RepositorioUsuarioEnvio.class);
        Mockito.when(repositorioUsuarioEnvio.existe(Mockito.anyString())).thenReturn(false);
        Mockito.when(repositorioUsuarioEnvio.crear(usuarioEnvio)).thenReturn(11L);
        ServicioCrearUsuarioEnvio servicioCrearUsuarioEnvio = new ServicioCrearUsuarioEnvio(repositorioUsuarioEnvio);

        Long idTest = servicioCrearUsuarioEnvio.ejecutar(usuarioEnvio);

        assertEquals(11L, idTest);
        Mockito.verify(repositorioUsuarioEnvio, Mockito.times(1)).crear(usuarioEnvio);
    }

    @Test
    void deberiaLanzarUnaExcepcionCuandoValideLaExistencia() {
        UsuarioEnvio usuarioEnvio = new EnvioTestDataBuilder().build();
        RepositorioUsuarioEnvio repositorioUsuarioEnvio = Mockito.mock(RepositorioUsuarioEnvio.class);
        Mockito.when(repositorioUsuarioEnvio.existe(Mockito.anyString())).thenReturn(true);

        ServicioCrearUsuarioEnvio servicioCrearUsuarioEnvio = new ServicioCrearUsuarioEnvio(repositorioUsuarioEnvio);

        BasePrueba.assertThrows(() ->
                    servicioCrearUsuarioEnvio.ejecutar(usuarioEnvio), ExcepcionDuplicidad.class,"Nombre de usuario se encuentra registrado"
        );
    }
}

package com.ceiba.usuario.servicio;

import com.ceiba.usuario.puerto.repositorio.RepositorioUsuarioEnvio;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioEliminarUsuarioEnvioTest {

    @Test
    void deberiaEliminarUsuarioEnvio(){

        RepositorioUsuarioEnvio repositorioUsuarioEnvio = Mockito.mock(RepositorioUsuarioEnvio.class);
        ServicioEliminarUsuarioEnvio servicioEliminarUsuarioEnvio = new ServicioEliminarUsuarioEnvio(repositorioUsuarioEnvio);

        servicioEliminarUsuarioEnvio.ejecutar(1L);

        Mockito.verify(repositorioUsuarioEnvio, Mockito.times(1)).eliminar(1l);

    }
}

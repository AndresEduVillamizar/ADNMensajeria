package com.ceiba.usuario.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.usuario.servicio.ServicioEliminarUsuarioEnvio;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarUsuarioEnvio implements ManejadorComando<Long> {

    private final ServicioEliminarUsuarioEnvio servicioEliminarUsuarioEnvio;

    public ManejadorEliminarUsuarioEnvio(ServicioEliminarUsuarioEnvio servicioEliminarUsuarioEnvio) {
        this.servicioEliminarUsuarioEnvio = servicioEliminarUsuarioEnvio;
    }

    @Override
    public void ejecutar(Long id) {
        this.servicioEliminarUsuarioEnvio.ejecutar(id);
    }
}

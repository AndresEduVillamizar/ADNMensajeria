package com.ceiba.usuario.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.usuario.comando.ComandoEnvio;
import com.ceiba.usuario.comando.fabrica.FabricaEnvio;
import com.ceiba.usuario.modelo.entidad.UsuarioEnvio;
import com.ceiba.usuario.servicio.ServicioCrearUsuarioEnvio;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearUsuarioEnvio implements ManejadorComandoRespuesta<ComandoEnvio, ComandoRespuesta<Long>> {

    private final FabricaEnvio fabricaEnvio;
    private final ServicioCrearUsuarioEnvio servicioCrearUsuarioEnvio;

    public ManejadorCrearUsuarioEnvio(FabricaEnvio fabricaEnvio, ServicioCrearUsuarioEnvio servicioCrearUsuarioEnvio) {
        this.fabricaEnvio = fabricaEnvio;
        this.servicioCrearUsuarioEnvio = servicioCrearUsuarioEnvio;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoEnvio comandoEnvio) {
        UsuarioEnvio usuarioEnvio = this.fabricaEnvio.crear(comandoEnvio);
        return new ComandoRespuesta<>(this.servicioCrearUsuarioEnvio.ejecutar(usuarioEnvio));
    }
}

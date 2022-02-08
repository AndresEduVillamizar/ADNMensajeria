package com.ceiba.usuario.comando.fabrica;

import com.ceiba.usuario.comando.ComandoEnvio;
import com.ceiba.usuario.modelo.entidad.UsuarioEnvio;
import org.springframework.stereotype.Component;

@Component
public class FabricaEnvio {

    public UsuarioEnvio crear(ComandoEnvio comandoEnvio){
        return new UsuarioEnvio(
                comandoEnvio.getId(),
                comandoEnvio.getNombre(),
                comandoEnvio.getClave(),
                comandoEnvio.isPremium()
        );

    }
}
